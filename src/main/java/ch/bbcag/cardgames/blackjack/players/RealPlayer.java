package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Count;
import ch.bbcag.cardgames.blackjack.Stack;

public class RealPlayer extends Player {

    private boolean hit;

    public RealPlayer(Stack stack) {
        super(stack);
    }

    @Override
    public void turn() {
        if (hit) {
            int MAX_CARD_VALUE = 21;
            if(getCount(Count.BEST, getCards()) < MAX_CARD_VALUE)takeCard();
        } else {
            pass();
        }
    }

    @Override
    public void split() {
        doSplit();
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void setDone(boolean done) {
        this.done = done;

    }
}