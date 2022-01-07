package ch.bbcag.cardgames.gui.common;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PositionOfTextFields {

    public void positionOfTextFields(){}
    public void setTopRightTxT(TextField textField, double marginFromPain) {
        AnchorPane.setTopAnchor(textField, marginFromPain);
        AnchorPane.setRightAnchor(textField,marginFromPain);
    }
    public void setBottomRightTxT(TextField textField, double marginFromPain){
        AnchorPane.setBottomAnchor(textField,marginFromPain);
        AnchorPane.setRightAnchor(textField,marginFromPain);
    }
    public void setBottomLeftTxT(TextField textField, double marginFromPain){
        AnchorPane.setLeftAnchor(textField, marginFromPain);
        AnchorPane.setBottomAnchor(textField, marginFromPain);
    }
    public void setTopLeftTxT(TextField textField, double marginFromPain){
        AnchorPane.setLeftAnchor(textField, marginFromPain);
        AnchorPane.setTopAnchor(textField, marginFromPain);
    }
    public void setBottomRightForSpecials(TextField textField, double marginFromPain, double number){
        AnchorPane.setBottomAnchor(textField, number);
        AnchorPane.setRightAnchor(textField, marginFromPain);
    }
}
