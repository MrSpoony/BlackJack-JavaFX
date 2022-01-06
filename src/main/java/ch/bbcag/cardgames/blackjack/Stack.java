package ch.bbcag.cardgames.blackjack;

import ch.bbcag.cardgames.common.cards.Card;
import ch.bbcag.cardgames.common.cards.Deck;
import ch.bbcag.cardgames.common.cards.enums.DeckName;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Stack extends CopyOnWriteArrayList<Card> implements List<Card> {

    private List<Card> drawnCards = new CopyOnWriteArrayList<>();

    private int numberOfDecks;

    public Stack(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
        createStack();
    }

    private void createStack() {
        List<Deck> decks = new CopyOnWriteArrayList<>();
        for (int i = 0; i < numberOfDecks; i++) {
            decks.add(new Deck(DeckName.POKER));
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

    private void throwErrorIfEmpty() {
        if (isEmpty()) {
            throw new NullPointerException("For this operation deck cannot be empty!");
        }
    }

}