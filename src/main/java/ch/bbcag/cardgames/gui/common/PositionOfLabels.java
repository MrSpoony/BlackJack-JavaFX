package ch.bbcag.cardgames.gui.common;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class PositionOfLabels {
    public void positionOfLabels(){}
    public void setTopRightLbL(Label label, double hallo) {
        AnchorPane.setTopAnchor(label, hallo);
        AnchorPane.setRightAnchor(label,hallo);
    }
    public void setBottomRightLbL(Label label, double hallo){
        AnchorPane.setBottomAnchor(label,hallo);
        AnchorPane.setRightAnchor(label,hallo);
    }
    public void setBottomLeftLbl(Label label, double hallo){
        AnchorPane.setLeftAnchor(label, hallo);
        AnchorPane.setBottomAnchor(label, hallo);
    }
    public void setTopLeftLbl(Label label, double hallo){
        AnchorPane.setLeftAnchor(label, hallo);
        AnchorPane.setTopAnchor(label, hallo);
    }
    public void setBottomRightForSpecials(Label label, double hallo, double number){
        AnchorPane.setBottomAnchor(label, number);
        AnchorPane.setRightAnchor(label, hallo);
    }
}
