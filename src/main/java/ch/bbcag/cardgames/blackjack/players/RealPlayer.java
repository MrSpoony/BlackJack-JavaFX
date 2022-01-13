package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Count;
import ch.bbcag.cardgames.blackjack.Stack;

public class RealPlayer extends Player {

    private static final int MAX_CARD_VALUE = 21;
    private boolean hit;

    public RealPlayer(Stack stack) {
        super(stack);
    }

    @Override
    public void turn() {
        if (hit) {
            if(canTakeACard()) takeCard();
        } else {
            pass();
        }
    }

    public boolean canTakeACard() {
        return getCount(Count.BEST, getCards()) < MAX_CARD_VALUE;
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