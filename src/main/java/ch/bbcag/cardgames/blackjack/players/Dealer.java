package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Stack;
import ch.bbcag.cardgames.common.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player{
    private static final int DEALER_MUST_STAY = 17;
    private int dealerHandValue;


    public Dealer(Stack stack) {
        super(stack);
    }

    @Override
    public void drawNext() {
        while (dealerHandValue < DEALER_MUST_STAY){
            takeCard();
            dealerHandValue = getCount(count.HIGH);
        }
    }

    @Override
    public void split() {
    }
}
