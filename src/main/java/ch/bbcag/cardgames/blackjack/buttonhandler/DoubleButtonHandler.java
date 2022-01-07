package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.players.RealPlayer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DoubleButtonHandler extends MainButtonHandler implements EventHandler<MouseEvent> {
    public DoubleButtonHandler(RealPlayer player) {
        super(player);
    }

    @Override
    public void handle(MouseEvent event) {
        player.doDoubleDown();
    }
}