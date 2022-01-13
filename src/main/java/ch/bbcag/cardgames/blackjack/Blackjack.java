package ch.bbcag.cardgames.blackjack;

import ch.bbcag.cardgames.blackjack.players.Dealer;
import ch.bbcag.cardgames.blackjack.players.Player;
import ch.bbcag.cardgames.blackjack.players.RealPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Blackjack {

    public static final int VALUE_TO_WIN = 21;
    public static final int NUMBER_OF_CARDS_TO_GET_AT_BEGIN = 2;
    private static final int NUMBER_OF_DECKS_USED = 3;
    private static final int INITIAL_PLAYER_MONEY = 1000;
    private final Stack MAIN_STACK = new Stack(NUMBER_OF_DECKS_USED);

    private int dealerHand;
    private int playerHand;
    private Player dealer;
    private RealPlayer realPlayer;
    private Player winner;

    private List<Player> players = new ArrayList<>();

    public Blackjack() {
        setupGame();
    }

    public String dealersTurn() {
        String winnerString;

        realPlayer.setDone(false);
        while (!dealer.isDone()) {
            dealer.turn();
        }
        winnerString = drawOrWin(false);
        if (realPlayer.isSplitHappend()) {
            playerHand = realPlayer.getCount(Count.BEST, realPlayer.getSplitCards());
            winnerString = winnerString + " and for split " + drawOrWin(true).toLowerCase(Locale.ROOT);
            realPlayer.setSplitHappend(false);
        }
        return winnerString;
    }

    private String drawOrWin(boolean ofSplit) {
        if (!isDraw()) winner = findWinner(ofSplit);
        else return "It's a draw";
        if (winner == realPlayer) return "Player wins";
        else return "Dealer wins";
    }

    public void newGame() {
        setupNewGame();
    }

    public void startGame() {
        dealStartCards();
    }

    private Player findWinner(boolean ofSplit) {
        if (!ofSplit) {
            refreshCounters();
        }
        if (playerHand <= VALUE_TO_WIN) {
            if (dealerHand <= VALUE_TO_WIN) {
                if (dealerHand < playerHand) {
                    setRealPlayerAsWinner();
                } else {
                    setRealPlayerAsLooser();
                }
            } else {
                setRealPlayerAsWinner();
            }
        } else {
            setRealPlayerAsLooser();
        }
        return winner;
    }

    private void setRealPlayerAsWinner() {
        winner = realPlayer;
        realPlayer.setMoney(realPlayer.getMoney() + realPlayer.getBet() * 2);
        realPlayer.setBet(0);
    }

    private void setRealPlayerAsLooser() {
        winner = dealer;
        realPlayer.setBet(0);
    }

    private boolean isAmountTheSame() {
        return players.get(players.size() - 1).getCount(Count.BEST, dealer.getCards()) == realPlayer.getCount(Count.BEST, realPlayer.getCards());
    }

    private boolean isDraw() {
        return isAmountTheSame() && realPlayer.getCount(Count.BEST, realPlayer.getCards()) < VALUE_TO_WIN + 1;
    }

    private void setupVariables() {
        dealer = players.get(players.size() - 1);
        realPlayer = (RealPlayer) players.get(0);
        refreshCounters();
    }

    private void refreshCounters() {
        dealerHand = dealer.getCount(Count.BEST, dealer.getCards());
        playerHand = realPlayer.getCount(Count.BEST, realPlayer.getCards());
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
    }

    private void setupNewGame() {
        setupNewPlayers();
        setupVariables();
    }

    private void setupNewPlayers() {
        dealer = new Dealer(MAIN_STACK);
        realPlayer.clear();
        players.add(new Dealer(MAIN_STACK));
    }

    private void setupPlayers() {
        players.add(new RealPlayer(MAIN_STACK, INITIAL_PLAYER_MONEY));
        players.add(new Dealer(MAIN_STACK));
    }

    public RealPlayer getPlayer() {
        return realPlayer;
    }

    public Dealer getDealer() {
        return (Dealer) players.get(players.size() - 1);
    }
}