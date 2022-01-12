package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Count;
import ch.bbcag.cardgames.blackjack.Stack;

public class Dealer extends Player {
    private static final int DEALER_MUST_STAY = 17;

    public Dealer(Stack stack) {
        super(stack);
    }

    @Override
    public void turn() {
        if (hasToTakeCard()) {
            takeCard();
        } else {
            pass();
        }
    }

    public boolean hasToTakeCard() {
        return getCount(Count.HIGH, getCards()) <= DEALER_MUST_STAY;
    }

    @Override
    public void split() {
    }
}