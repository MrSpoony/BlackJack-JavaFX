package ch.bbcag.cardgames.gui.common;

import java.awt.*;

public class TitleLayout extends Label {
    public TitleLayout(String text){
        super(text);
        this.setStyle("-fx-text-fill: #000000; -fx-font-size: 25; -fx-font-family: Arial");
    }

    private void setStyle(String s) {
    }
}
