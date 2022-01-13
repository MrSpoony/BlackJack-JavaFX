package ch.bbcag.cardgames.gui.common;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class PositionOfNodes {


    public static void setTopRightLbl(Node node, double margin) {
        AnchorPane.setTopAnchor(node, margin);
        AnchorPane.setRightAnchor(node,margin);
    }
    public static void setBottomRightLbl(Node node, double margin){
        AnchorPane.setBottomAnchor(node,margin);
        AnchorPane.setRightAnchor(node,margin);
    }
    public static void setBottomLeftLbl(Node node, double margin){
        AnchorPane.setLeftAnchor(node, margin);
        AnchorPane.setBottomAnchor(node, margin);
    }
    public static void setTopLeftLbl(Node node, double margin){
        AnchorPane.setLeftAnchor(node, margin);
        AnchorPane.setTopAnchor(node, margin);
    }
    public static void setBottomRightForSpecials(Node node, double margin, double number){
        AnchorPane.setBottomAnchor(node, number);
        AnchorPane.setRightAnchor(node, margin);
    }

    public static void setAllFourPositions(Node TopLeft, Node TopRight, Node BotRight, double margin) {
        setTopLeftLbl(TopLeft, margin);
        setTopRightLbl(TopRight, margin);
        setBottomRightLbl(BotRight, margin);
    }
}