package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.players.RealPlayer;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class BetButtonHandler extends MainButtonHandler{

    private TextField amountField;
    public BetButtonHandler(RealPlayer player, TextField amountField) {
        super(player);
        this.amountField = amountField;
    }

    @Override
    public void handle(ActionEvent event) {
        int bet;
        try {
            bet = Integer.parseInt(amountField.getText());
        } catch (NumberFormatException nfe) {
            return;
        }
        if (bet != 0 && bet <= player.getMoney()) {
            player.setBet(bet);
            player.setMoney(player.getMoney() - player.getBet());
        }
    }
}
