package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Stack;
import ch.bbcag.cardgames.common.cards.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private Stack stack;

    private List<Card> cards = new ArrayList<>();

    private boolean dealerReady = false;

    public Player(Stack stack) {
        this.stack = stack;
    }

    public void takeCard() {
        cards.add(stack.drawCard());
    }
    public boolean isSplitPossible(){
        return cards.get(0) == cards.get(1);
    }
}