package ch.bbcag.cardgames.gui.common;

import javafx.scene.control.Button;

public class TransparentButton extends Button {

    public TransparentButton(String text) {
        super(text);
        setStyle("-fx-background-color:rgba(0.5, 0.5, 0.5, 0.2); -fx-text-fill: #ffffff;" +
                " -fx-font-size: 18; -fx-font-family: Arial;-fx-min-height: 15; -fx-min-width: 20; -fx-start-margin: 6");
    }

    public void setButtonNotAvailable() {
        setDisable(true);
        setStyle("-fx-background-color:rgba(0.5, 0.5, 0.5, 0.2); -fx-text-fill:rgba(0.7, 1, 1, 1);" +
                " -fx-font-size: 18; -fx-font-family: Arial;-fx-min-height: 15; -fx-min-width: 20; -fx-start-margin: 6");
    }

    public void setButtonAvailable() {
        setDisable(true);
        setStyle("-fx-background-color:rgba(0.5, 0.5, 0.5, 0.2); -fx-text-fill: #ffffff;" +
                " -fx-font-size: 18; -fx-font-family: Arial;-fx-min-height: 15; -fx-min-width: 20; -fx-start-margin: 6");
    }
}