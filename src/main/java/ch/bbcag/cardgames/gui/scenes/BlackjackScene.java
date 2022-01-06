package ch.bbcag.cardgames.gui.scenes;


import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BlackjackScene extends BackgroundScene{

    public BlackjackScene(Navigator navigator) {
        super(navigator);
    }

    private final Button btnSplit = new Button("btnSplit");
    private final Button btnDouble = new Button("btnDouble");
    private final Button btnHit = new Button("btnHit");
    private final Button btnHold = new Button("btnHold");

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

        mainAnchorPain.setPrefSize(BaseScene.SCREEN_WIDTH,BaseScene.SCREEN_HEIGHT);
        AnchorPane.setTopAnchor(money,10.0);
        AnchorPane.setBottomAnchor(subtotal, 10.0);

        customizedBTN(btnSplit);
        customizedBTN(btnHit);
        customizedBTN(btnDouble);
        customizedBTN(btnHold);
        mainHbox.getChildren().addAll(btnHit,btnHold,btnDouble,btnSplit);
        mainAnchorPain.getChildren().addAll(money, subtotal, mainHbox);

        AnchorPane.setRightAnchor(mainHbox, 10.0);
        AnchorPane.setBottomAnchor(mainHbox, 10.0);



        getGroup().getChildren().add(mainAnchorPain);
        super.paint();
    }

    private void customizedBTN(Button button){
        button.setStyle("-fx-background-color:rgba(0.5, 0.5, 0.5, 0.2); -fx-background-radius: 15px; -fx-border-width: 2px; -fx-text-fill: #ffffff" );
    }


}
