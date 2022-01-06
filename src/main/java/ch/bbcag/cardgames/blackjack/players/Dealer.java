package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Count;
import ch.bbcag.cardgames.blackjack.Stack;


public class Dealer extends Player {
    private static final int DEALER_MUST_STAY = 17;
    private int dealerHandValue;


    public Dealer(Stack stack) {
        super(stack);
    }

    @Override
    public void turn() {
        while (dealerHandValue < DEALER_MUST_STAY) {
            takeCard();
            dealerHandValue = getCount(Count.HIGH);
        }
    }

    @Override
    public void split() {
    }
}
