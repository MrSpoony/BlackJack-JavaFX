package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.players.RealPlayer;
import ch.bbcag.cardgames.gui.scenes.BlackjackScene;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class BetButtonHandler extends MainButtonHandler{

    private TextField amountField;
    private BlackjackScene blackjackScene;

    public BetButtonHandler(RealPlayer player, TextField amountField, BlackjackScene blackjackScene) {
        super(player);
        this.amountField = amountField;
        this.blackjackScene = blackjackScene;
    }

    @Override
    public void handle(ActionEvent event) {
        int bet;
        try {
            bet = Integer.parseInt(amountField.getText());
        } catch (NumberFormatException nfe) {
            return;
        }
        if (bet >= 0 && bet <= player.getMoney()) {
            player.setBet(bet);
            player.setMoney(player.getMoney() - player.getBet());
            blackjackScene.startGame();
            blackjackScene.setWaitingForMoneySet(false);
        }
    }
}