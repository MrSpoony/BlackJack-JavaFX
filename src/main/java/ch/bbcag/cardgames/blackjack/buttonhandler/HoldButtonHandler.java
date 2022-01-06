package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.players.RealPlayer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class HoldButtonHandler extends MainButtonHandler implements EventHandler<MouseEvent> {
    public HoldButtonHandler(RealPlayer player) {
        super(player);
    }

    @Override
    public void handle(MouseEvent event) {
        player.setHit(false);
        player.turn();
    }
}
