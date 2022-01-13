package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Count;
import ch.bbcag.cardgames.blackjack.Stack;
import ch.bbcag.cardgames.common.cards.Card;
import ch.bbcag.cardgames.common.cards.enums.Face;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static ch.bbcag.cardgames.blackjack.Blackjack.NUMBER_OF_CARDS_TO_GET_AT_BEGIN;
import static ch.bbcag.cardgames.blackjack.Blackjack.VALUE_TO_WIN;

public abstract class Player {

    private final Stack stack;
    public boolean isSplitHappend;

    private List<Card> beforeSplitCards = new CopyOnWriteArrayList<>();
    private  List<Card> splitCards = new CopyOnWriteArrayList<>();

    private List<Card> activeCards = new CopyOnWriteArrayList<>();

    private int bet;
    private boolean splitHappend = false;
    protected boolean done = false;
    protected boolean isSplit = false;

    public Player(Stack stack) {
        this.stack = stack;
    }

    public boolean isSplitPossible() {
        return activeCards.get(0).getFace() == activeCards.get(1).getFace() && activeCards.size() == NUMBER_OF_CARDS_TO_GET_AT_BEGIN;
    }

    public abstract void turn();

    public abstract void split();

    public void doDoubleDown() {
        bet *= 2;
        takeCard();
        pass();
    }

    public void takeCard() {
        activeCards.add(stack.drawCard());
    }

    public void pass() {
        if (isSplit) {
            beforeSplitCards = activeCards;
            isSplit = false;
            activeCards = splitCards;
        } else {
            splitCards = activeCards;
            done = true;
        }
    }

    public int getCount(Count highOrLowValue, List<Card> cards) {
        switch (highOrLowValue) {
            case HIGH -> {
                return getHighCount(cards);
            }
            case BEST -> {
                return getBestCount(cards);
            }
            case LOW -> {
                return getLowCount(cards);
            }
            default -> throw new IllegalStateException("highOrLowValue is not part of the Card enum");
        }
    }

    protected void doSplit() {
        isSplit = true;
        splitCards.add(activeCards.get(1));

        beforeSplitCards.add(activeCards.get(0));

        splitCards.add(stack.drawCard());
        beforeSplitCards.add(stack.drawCard());

        activeCards.clear();
        activeCards = beforeSplitCards;
        splitHappend = true;
    }

    private int getHighCount(List<Card> cards) {
        int count = 0;
        for (Card card : cards) {
            count += card.getValue();
        }
        return count;
    }

    private int getBestCount(List<Card> cards) {
        int count = 0;
        for (Card card : cards) {
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

    private int getLowCount(List<Card> cards) {
        int count = 0;
        for (Card card : cards) {
            if (card.getFace() == Face.ASS) {
                count++;
            } else {
                count += card.getValue();
            }
        }
        return count;
    }

    public void setDone(boolean done) {
        this.done = done;
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

    public List<Card> getCards() {
        return activeCards;
    }

    public List<Card> getBeforeSplitCards() {
        return beforeSplitCards;
    }

    public List<Card> getSplitCards() {
        return splitCards;
    }

    public void setSplitHappend(boolean splitHappend) {
        isSplitHappend = splitHappend;
    }

    public boolean isSplitHappend() {
        return splitHappend;
    }
}