package ch.bbcag.cardgames.gui.scenes;


import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import ch.bbcag.cardgames.gui.common.TransparentButton;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BlackjackScene extends BackgroundScene {

    public BlackjackScene(Navigator navigator) {
        super(navigator);
    }

    private final TransparentButton btnSplit = new TransparentButton("Split");
    private final TransparentButton btnDouble = new TransparentButton("Double");
    private final TransparentButton btnHit = new TransparentButton("Hit");
    private final TransparentButton btnHold = new TransparentButton("Hold");

    private final Label money = new Label("Money:");
    private final Label subtotal = new Label("Subtotal:");

    private double marginforAnchorPain = 10.0;
    private int fontSize = 25;

    @Override
    public void update(double deltaInSec) {

        btnSplit.setOnMouseClicked(mouseEventHandler);
        btnDouble.setOnMouseClicked(mouseEventHandler);
        btnHit.setOnMouseClicked(mouseEventHandler);
        btnHold.setOnMouseClicked(mouseEventHandler);
    }

    @Override
    public void paint() {
        AnchorPane mainAnchorPain = new AnchorPane();
        HBox mainHbox = new HBox();


        money.setFont(new Font("Arial", fontSize));
        subtotal.setFont(new Font("Arial", fontSize));
        money.setTextFill(Color.web("#000000"));
        subtotal.setTextFill(Color.web("#000000"));

        mainAnchorPain.setPrefSize(BaseScene.SCREEN_WIDTH, BaseScene.SCREEN_HEIGHT);
        AnchorPane.setTopAnchor(money, marginforAnchorPain);
        AnchorPane.setBottomAnchor(subtotal, marginforAnchorPain);

        mainHbox.getChildren().addAll(btnHit, btnHold, btnDouble, btnSplit);
        mainAnchorPain.getChildren().addAll(money, subtotal, mainHbox);



        AnchorPane.setRightAnchor(mainHbox, marginforAnchorPain);
        AnchorPane.setBottomAnchor(mainHbox, marginforAnchorPain);


        getGroup().getChildren().add(mainAnchorPain);
        super.paint();
    }
}