package ch.bbcag.cardgames.blackjack;

import ch.bbcag.cardgames.blackjack.players.Dealer;
import ch.bbcag.cardgames.blackjack.players.Player;
import ch.bbcag.cardgames.blackjack.players.RealPlayer;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {

    public static final int VALUE_TO_WIN = 21;
    public static final int NUMBER_OF_CARDS_TO_GET_AT_BEGIN = 2;
    private static final int NUMBER_OF_DECKS_USED = 3;
    private static final int NUMBER_OF_PLAYERS = 1;

    private int numberOfRealPlayers;
    private int dealerHand;
    private int playerHand;
    private Player dealer;
    private Player winner;
    private Stack mainStack = new Stack(NUMBER_OF_DECKS_USED);

    private List<Player> players = new ArrayList<>();

    public Blackjack(int numberOrRealPlayers) {
        this.numberOfRealPlayers = numberOrRealPlayers;
        setupGame();
    }

    public void dealerTurn() {
        getCurrentRealPlayer().setDone(false);
        while (!dealer.isDone()) {
            dealer.turn();
        }
        System.out.println("Dealer done");
        if (!isDraw()) winner = findWinner();
        else System.out.println("its a draw");
        getCurrentRealPlayer().isDone();
        // getCurrentRealPlayer().setDone(false);
        System.out.println(winner);
        if(getCurrentRealPlayer().isSplitHappend){
            if (!isDraw()) winner = findWinner();
            else System.out.println("its a draw");
            getCurrentRealPlayer().isDone();
            // getCurrentRealPlayer().setDone(false);
            System.out.println(winner);
            getCurrentRealPlayer().setSplitHappend(false);
        }
    }

    private RealPlayer getCurrentRealPlayer() {
        for (Player player : players) {
            if (player instanceof RealPlayer) {
                return (RealPlayer) player;
            }
        }
        throw new IllegalStateException("There is no real player");
    }


    private Player findWinner() {
        refreshCounters();
        Player winner;
        if (playerHand <= VALUE_TO_WIN) {
            if (dealerHand <= VALUE_TO_WIN) {
                if (dealerHand < playerHand) {
                    winner = getCurrentRealPlayer();
                } else {
                    winner = dealer;
                }
            } else winner = getCurrentRealPlayer();
        } else winner = dealer;
        return winner;
    }

    private boolean isAmountTheSame() {
        return players.get(players.size() - 1).getCount(Count.BEST, dealer.getCards()) == getCurrentRealPlayer().getCount(Count.BEST, getCurrentRealPlayer().getCards());
    }

    private boolean isDraw() {
        return isAmountTheSame() && getCurrentRealPlayer().getCount(Count.BEST, getCurrentRealPlayer().getCards()) < VALUE_TO_WIN + 1;
    }

    private void setupVariables() {
        dealer = players.get(players.size() - 1);
        refreshCounters();
    }

    private void refreshCounters() {
        dealerHand = dealer.getCount(Count.BEST, dealer.getCards());
        playerHand = getCurrentRealPlayer().getCount(Count.BEST, getCurrentRealPlayer().getCards());
    }

    private void dealStartCards() {
        for (int i = 0; i < NUMBER_OF_CARDS_TO_GET_AT_BEGIN; i++) {
            for (Player player : players) {
                player.takeCard();
            }
        }
    }

    private void setupGame() {
        setupPlayers();
        setupVariables();
        dealStartCards();
    }

    private void setupPlayers() {
        players.add(new RealPlayer(mainStack));
        players.add(new Dealer(mainStack));
    }

    public RealPlayer getPlayer() {
        return getCurrentRealPlayer();
    }

    public Dealer getDealer() {
        return (Dealer) players.get(players.size() - 1);
    }
}