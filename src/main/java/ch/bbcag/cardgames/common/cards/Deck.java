package ch.bbcag.cardgames.common.cards;

import ch.bbcag.cardgames.common.cards.enums.DeckName;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Deck {

    private static final int NUMBER_OF_POKER_FACES = 13;
    private static final int NUMBER_OF_POKER_SUITS = 4;
    private static final int POKER_START_NUMBER = 2;

    private static final String IMAGE_ENDING = ".png";

    private int numberOfFaces;
    private int numberOfSuits;
    private int startNumber;

    private List<Card> deck = new CopyOnWriteArrayList<>();
    private DeckName deckName;

    public Deck(DeckName deckName) {
        this.deckName = deckName;
        setVariables();
        addCards();
    }

    public Card getRandomCard() {
        Random random = new Random();
        return deck.get(random.nextInt(deck.size()));
    }

    private void setVariables() {
        switch (deckName) {
            case POKER -> {
                numberOfFaces = NUMBER_OF_POKER_FACES;
                numberOfSuits = NUMBER_OF_POKER_SUITS;
                startNumber = POKER_START_NUMBER;
            }
        }
    }

    private void addCards() {
        switch (deckName) {
            case POKER -> createPokerDeck();
        }
    }

    private void createPokerDeck() {
        String prefix;
        String suffix;
        for (int i = 0; i < NUMBER_OF_POKER_SUITS; i++) {
            for (int j = POKER_START_NUMBER; j < NUMBER_OF_POKER_FACES+POKER_START_NUMBER; j++) {
                switch (j) {
                    case 2, 3, 4, 5, 6, 7, 8, 9 -> prefix = Integer.toString(j);
                    case 10 -> prefix = "T";
                    case 11 -> prefix = "J";
                    case 12 -> prefix = "Q";
                    case 13 -> prefix = "K";
                    case 14 -> prefix = "A";
                    default -> throw new IllegalStateException("Unexpected value: " + i % 4);
                }
                switch (i) {
                    case 1 -> suffix = "C";
                    case 2 -> suffix = "D";
                    case 3 -> suffix = "H";
                    case 0 -> suffix = "S";
                    default -> throw new IllegalStateException("Unexpected value: " + i % 4);
                }
                String fullPath = prefix + suffix + IMAGE_ENDING;
                deck.add(new Card(fullPath));
            }
        }
    }
}