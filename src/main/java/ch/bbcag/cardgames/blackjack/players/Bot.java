package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Count;
import ch.bbcag.cardgames.blackjack.Stack;

import java.util.Random;

public class Bot extends Player {

    private int botHand = 0;
    private Random random = new Random();
    private static final int MAX_RANDOM_VALUE = 21;
    private static final int MIN_RANDOM_VALUE = 10;


    public Bot(Stack stack) {
        super(stack);
    }

    public void turn() {
        if (botHand > random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE) + MIN_RANDOM_VALUE) {
            takeCard();
            botHand = getCount(Count.HIGH);
        } pass();
    }

    @Override
    public void split() {
        if (isSplitPossible()) {
            doSplit();
        }
    }
}