package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Count;
import ch.bbcag.cardgames.blackjack.Stack;
import ch.bbcag.cardgames.common.cards.Card;
import ch.bbcag.cardgames.common.cards.enums.Face;

import java.util.ArrayList;
import java.util.List;

import static ch.bbcag.cardgames.blackjack.Blackjack.VALUE_TO_WIN;

public abstract class Player implements PlayerActions {

    private Stack stack;

    private List<Card> cards = new ArrayList<>();

    public Player(Stack stack) {
        this.stack = stack;
    }

    protected void takeCard() {
        cards.add(stack.drawCard());
    }
    public boolean isSplitPossible(){
        return cards.get(0) == cards.get(1);
    }

    protected int getCount(Count highOrLowValue) {
        switch (highOrLowValue) {
            case HIGH -> {
                return getHighCount();
            }
            case BEST -> {
                return getBestCount();
            }
            case LOW -> {
                return getLowCount();
            }
            default -> throw new IllegalStateException("highOrLowValue is not part of the Card enum");
        }
    }
    public abstract void drawNext();
    public abstract void split();

    private int getHighCount() {
        int count = 0;
        for(Card card : cards) {
            count += card.getValue();
        }
        return count;
    }
    private int getBestCount() {
        int count = 0;
        for(Card card : cards) {
            if (card.getFace() != Face.ASS) {
                count += card.getValue();
            }
        }
        for (Card card : cards) {
            if (card.getFace() == Face.ASS) {
                if (count > VALUE_TO_WIN - card.getValue()) {
                    count++;
                } else {
                    count += card.getValue();
                }
            }
        }
        return count;
    }

    private int getLowCount() {
        int count = 0;
        for(Card card : cards) {
            if (card.getFace() == Face.ASS) {
                count++;
            } else {
                count += card.getValue();
            }
        }
        return count;
    }
}