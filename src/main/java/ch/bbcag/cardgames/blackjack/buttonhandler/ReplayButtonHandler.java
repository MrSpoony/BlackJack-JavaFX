package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.Blackjack;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ReplayButtonHandler implements EventHandler<ActionEvent> {

    private Blackjack blackjack;

    public ReplayButtonHandler(Blackjack blackjack) {
        this.blackjack = blackjack;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("aoiresntaoriesntaroiesnatoiresn");
        blackjack.newGame();
    }
}