package ch.bbcag.cardgames.gui.common;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class PositionOfHboxes {

    public void positionOfHboxes(){}
    public void setTopRightBox(HBox hBox, double marginFromPain) {
        AnchorPane.setTopAnchor(hBox, marginFromPain);
        AnchorPane.setRightAnchor(hBox,marginFromPain);
    }
    public void setBottomRightBox(HBox hBox, double marginFromPain){
        AnchorPane.setBottomAnchor(hBox,marginFromPain);
        AnchorPane.setRightAnchor(hBox,marginFromPain);
    }
    public void setBottomLeftBox(HBox hbox, double marginFromPain){
        AnchorPane.setLeftAnchor(hbox, marginFromPain);
        AnchorPane.setBottomAnchor(hbox, marginFromPain);
    }
    public void setTopLeftBox(HBox hbox, double marginFromPain){
        AnchorPane.setLeftAnchor(hbox, marginFromPain);
        AnchorPane.setTopAnchor(hbox, marginFromPain);
    }
    public void setBottomRightForSpecials(HBox hbox, double marginFromPain, double number){
        AnchorPane.setBottomAnchor(hbox, number);
        AnchorPane.setRightAnchor(hbox, marginFromPain);
    }
}
