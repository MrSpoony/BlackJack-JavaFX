package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.Blackjack;
import ch.bbcag.cardgames.gui.scenes.BlackjackScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ReplayButtonHandler implements EventHandler<ActionEvent> {

    BlackjackScene blackjackScene;

    public ReplayButtonHandler(Blackjack blackjack, BlackjackScene blackjackScene) {
        this.blackjackScene = blackjackScene;
    }

    @Override
    public void handle(ActionEvent event) {
        blackjackScene.newGame();
    }
}