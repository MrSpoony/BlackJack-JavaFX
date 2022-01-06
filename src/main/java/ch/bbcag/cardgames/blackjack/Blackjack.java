package ch.bbcag.cardgames.blackjack;

import ch.bbcag.cardgames.blackjack.players.Bot;
import ch.bbcag.cardgames.blackjack.players.Dealer;
import ch.bbcag.cardgames.blackjack.players.Player;
import ch.bbcag.cardgames.blackjack.players.RealPlayer;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {

    public static final int VALUE_TO_WIN = 21;
    private static final int NUMBER_OF_DECKS_USED = 6;
    private static final int NUMBER_OF_PLAYERS = 6;

    private int numberOfRealPlayers;
    private int numberOfBots;
    private Stack mainStack = new Stack(NUMBER_OF_DECKS_USED);

    private List<Player> players = new ArrayList<>();

    public Blackjack(int numberOrRealPlayers) {
        this.numberOfRealPlayers = numberOrRealPlayers;
        numberOfBots = NUMBER_OF_PLAYERS - (numberOrRealPlayers + 1);
        setupPlayers();
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

    public RealPlayer getCurrentRealPlayer() {
        for (Player player : players) {
            if (player instanceof RealPlayer) {
                return (RealPlayer) player;
            }
        }
        throw new IllegalStateException("There is no real player");
    }
}