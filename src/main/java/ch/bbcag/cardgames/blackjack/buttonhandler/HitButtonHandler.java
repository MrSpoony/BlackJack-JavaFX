package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.players.RealPlayer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class HitButtonHandler extends MainButtonHandler implements EventHandler<MouseEvent> {
    public HitButtonHandler(RealPlayer player) {
        super(player);
    }

    @Override
    public void handle(MouseEvent event) {
        player.setHit(true);
        player.turn();
    }
}
