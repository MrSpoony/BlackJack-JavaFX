package ch.bbcag.cardgames.gui.common;

import javafx.scene.control.Button;

public class TransparentButton extends Button {

    public TransparentButton(String text) {
        super(text);
        this.setStyle("-fx-background-color:rgba(0.5, 0.5, 0.5, 0.2); -fx-text-fill: #ffffff");
    }
}
