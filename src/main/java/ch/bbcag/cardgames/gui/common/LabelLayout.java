package ch.bbcag.cardgames.gui.common;


import javafx.scene.control.Label;

public class LabelLayout extends Label {
    public LabelLayout(String text){
        super(text);
        this.setStyle("-fx-text-fill: #000000; -fx-font-size: 25");
    }
}
