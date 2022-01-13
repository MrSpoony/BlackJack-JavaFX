package ch.bbcag.cardgames.blackjack;

import ch.bbcag.cardgames.common.cards.Card;
import ch.bbcag.cardgames.common.cards.Deck;
import ch.bbcag.cardgames.common.cards.enums.DeckName;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Stack extends CopyOnWriteArrayList<Card> implements List<Card> {

    private static final DeckName BLACKJACK_DECK = DeckName.POKER;
    private List<Card> drawnCards = new CopyOnWriteArrayList<>();

    private int numberOfDecks;

    public Stack(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
        createStack();
        shuffle();
    }

    private void createStack() {
        List<Deck> decks = new CopyOnWriteArrayList<>();
        for (int i = 0; i < numberOfDecks; i++) {
            decks.add(new Deck(BLACKJACK_DECK));
        }
        for (Deck deck : decks) {
            this.addAll(deck);
        }
    }

    public Card drawCard() {
        throwErrorIfEmpty();
        Card card = get(size() - 1);
        drawnCards.add(card);
        remove(size() - 1);
        return card;
    }

    public void renewStack() {
        this.addAll(drawnCards);
        this.shuffle();
    }

    private void throwErrorIfEmpty() {
        if (isEmpty()) {
            throw new NullPointerException("For this operation deck cannot be empty!");
        }
    }

    private void shuffle() {
        Collections.shuffle(this);
    }
}