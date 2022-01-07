package ch.bbcag.cardgames.blackjack;

import ch.bbcag.cardgames.blackjack.players.Bot;
import ch.bbcag.cardgames.blackjack.players.Dealer;
import ch.bbcag.cardgames.blackjack.players.Player;
import ch.bbcag.cardgames.blackjack.players.RealPlayer;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {

    public static final int VALUE_TO_WIN = 21;
    public static final int NUMBER_OF_CARDS_TO_GET_AT_BEGIN = 2;
    private static final int NUMBER_OF_DECKS_USED = 10;
    private static final int NUMBER_OF_PLAYERS = 6;

    private int numberOfRealPlayers;
    private int numberOfBots;
    private int dealerHand;
    private int playerHand;
    private Player dealer;
    private Player winner;
    private Stack mainStack = new Stack(NUMBER_OF_DECKS_USED);

    private List<Player> players = new ArrayList<>();

    public Blackjack(int numberOrRealPlayers) {
        this.numberOfRealPlayers = numberOrRealPlayers;
        numberOfBots = NUMBER_OF_PLAYERS - (numberOrRealPlayers + 1);
        setupGame();
        startTurns();
        if (!isDraw()) {
            winner = findWinner(); // Winner is the Player that won.
        }
        // else Its a draw ;
    }

    public RealPlayer getCurrentRealPlayer() {
        for (Player player : players) {
            if (player instanceof RealPlayer) {
                return (RealPlayer) player;
            }
        }
        throw new IllegalStateException("There is no real player");
    }

    public void startTurns() {
        if (!players.get(players.size() - 1).isDone()) for (Player player : players) {
            player.turn();
        }
    }

    private Player findWinner() {
        if (playerHand < VALUE_TO_WIN + 1) {
            if (dealerHand < VALUE_TO_WIN + 1) {
                if (dealerHand < playerHand) {
                    return getCurrentRealPlayer();
                } else if (dealerHand > playerHand) {
                    return dealer;
                }
            } else return getCurrentRealPlayer();
        } else return dealer;
        return dealer;
    }

    private boolean isAmountTheSame() {
        return players.get(players.size() - 1).getCount(Count.BEST) == getCurrentRealPlayer().getCount(Count.BEST);
    }

    private boolean isDraw() {
        return isAmountTheSame() && getCurrentRealPlayer().getCount(Count.BEST) < VALUE_TO_WIN + 1;
    }

    private void setupVariables() {
        dealer = players.get(players.size() - 1);
        dealerHand = dealer.getCount(Count.BEST);
        playerHand = getCurrentRealPlayer().getCount(Count.BEST);
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
        for (int i = 0; i < numberOfRealPlayers; i++) {
            players.add(new RealPlayer(mainStack));
        }
        for (int i = 0; i < numberOfBots; i++) {
            players.add(new Bot(mainStack));
        }
        players.add(new Dealer(mainStack));
    }
    public Player getPlayer() {
        return getCurrentRealPlayer();
    }
}