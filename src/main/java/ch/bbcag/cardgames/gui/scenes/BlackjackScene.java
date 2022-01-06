package ch.bbcag.cardgames.gui.scenes;


import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BlackjackScene extends BackgroundScene{

    public BlackjackScene(Navigator navigator) {
        super(navigator);
    }

    private final Button btnSplit = new Button();
    private final Button btnDouble = new Button();
    private final Button btnHit = new Button();
    private final Button btnHold = new Button();

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




        money.setFont(new Font("Arial", 25));
        subtotal.setFont(new Font("Arial", 25));
        money.setTextFill(Color.web("#000000"));
        subtotal.setTextFill(Color.web("#000000"));



        mainAnchorPain.setPrefSize(BaseScene.SCREEN_WIDTH,BaseScene.SCREEN_HEIGHT);
        AnchorPane.setTopAnchor(money,10.0);
        AnchorPane.setBottomAnchor(subtotal, 10.0);
//        AnchorPane.setLeftAnchor(subtotal, 10.0);

        mainAnchorPain.getChildren().addAll(money, subtotal);

        VBox mainVBox = new VBox(mainAnchorPain);


        getGroup().getChildren().add(mainVBox);
        super.paint();
    }


}
