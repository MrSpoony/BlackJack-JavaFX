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

    private final TransparentButton btnSplit = new TransparentButton("btnSplit");
    private final TransparentButton btnDouble = new TransparentButton("btnDouble");
    private final TransparentButton btnHit = new TransparentButton("btnHit");
    private final TransparentButton btnHold = new TransparentButton("btnHold");

    private final Label money = new Label("Money:");
    private final Label subtotal = new Label("Subtotal:");

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


        money.setFont(new Font("Arial", 25));
        subtotal.setFont(new Font("Arial", 25));
        money.setTextFill(Color.web("#000000"));
        subtotal.setTextFill(Color.web("#000000"));

        mainAnchorPain.setPrefSize(BaseScene.SCREEN_WIDTH, BaseScene.SCREEN_HEIGHT);
        AnchorPane.setTopAnchor(money, 10.0);
        AnchorPane.setBottomAnchor(subtotal, 10.0);

        mainHbox.getChildren().addAll(btnHit, btnHold, btnDouble, btnSplit);
        mainAnchorPain.getChildren().addAll(money, subtotal, mainHbox);

        AnchorPane.setRightAnchor(mainHbox, 10.0);
        AnchorPane.setBottomAnchor(mainHbox, 10.0);


        getGroup().getChildren().add(mainAnchorPain);
        super.paint();
    }
}