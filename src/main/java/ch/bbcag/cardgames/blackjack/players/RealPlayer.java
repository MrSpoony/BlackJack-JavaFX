package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Stack;

public class RealPlayer extends Player{

    private boolean hit;

    public RealPlayer(Stack stack) {
        super(stack);
    }

    @Override
    public void turn() {
        if (hit) {
            takeCard();
        } else {
            pass();
        }
    }

    @Override
    public void split() {

    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

}
