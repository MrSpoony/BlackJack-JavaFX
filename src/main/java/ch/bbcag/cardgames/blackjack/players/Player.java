package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Count;
import ch.bbcag.cardgames.blackjack.Stack;
import ch.bbcag.cardgames.common.cards.Card;
import ch.bbcag.cardgames.common.cards.enums.Face;

import java.util.ArrayList;
import java.util.List;

import static ch.bbcag.cardgames.blackjack.Blackjack.NUMBER_OF_CARDS_TO_GET_AT_BEGIN;
import static ch.bbcag.cardgames.blackjack.Blackjack.VALUE_TO_WIN;

public abstract class Player {

    private final Stack stack;

    private final List<Card> cards = new ArrayList<>();
    private final List<Card> splitCards = new ArrayList<>();

    private List<Card> activeCards = new ArrayList<>();

    private int bet;
    private boolean done = false;
    protected boolean isSplit = false;

    public Player(Stack stack) {
        this.stack = stack;
    }

    public boolean isSplitPossible() {
        return cards.get(0) == cards.get(1) && cards.size() == NUMBER_OF_CARDS_TO_GET_AT_BEGIN;
    }

    public abstract void turn();

    public abstract void split();

    public void doDoubleDown() {
        bet *= 2;
        takeCard();
        pass();
    }

    protected void takeCard() {
        activeCards.add(stack.drawCard());
    }

    protected void pass() {
        if (isSplit) {
            isSplit = false;
            activeCards = splitCards;
        } else {
            done = true;
        }
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

    protected void doSplit() {
        splitCards.add(cards.get(1));
        cards.remove(1);

        splitCards.add(stack.drawCard());
        cards.add(stack.drawCard());
    }

    private int getHighCount() {
        int count = 0;
        for (Card card : activeCards) {
            count += card.getValue();
        }
        return count;
    }

    private int getBestCount() {
        int count = 0;
        for (Card card : activeCards) {
            if (card.getFace() != Face.ASS) {
                count += card.getValue();
            }
        }
        for (Card card : activeCards) {
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
        for (Card card : activeCards) {
            if (card.getFace() == Face.ASS) {
                count++;
            } else {
                count += card.getValue();
            }
        }
        return count;
    }

    private void initiateActiveCards() {
        activeCards = cards;
    }

    public boolean isDone() {
        return done;
    }

    public void setBet(int value) {
        bet = value;
    }

    public int getBet() {
        return bet;
    }
}