package ch.bbcag.cardgames.gui.scenes;


import ch.bbcag.cardgames.blackjack.Blackjack;
import ch.bbcag.cardgames.blackjack.buttonhandler.DoubleButtonHandler;
import ch.bbcag.cardgames.blackjack.buttonhandler.HitButtonHandler;
import ch.bbcag.cardgames.blackjack.buttonhandler.HoldButtonHandler;
import ch.bbcag.cardgames.blackjack.buttonhandler.SplitButtonHandler;
import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BlackjackScene extends BackgroundScene {

    private static final int NUMBER_OF_REAL_PLAYERS = 1;

    private Blackjack mainBlackjack = new Blackjack(NUMBER_OF_REAL_PLAYERS);

    private final SplitButtonHandler splitEventHandler = new SplitButtonHandler(mainBlackjack.getCurrentRealPlayer());
    private final DoubleButtonHandler doubleEventHandler = new DoubleButtonHandler(mainBlackjack.getCurrentRealPlayer());
    private final HitButtonHandler hitEventHandler = new HitButtonHandler(mainBlackjack.getCurrentRealPlayer());
    private final HoldButtonHandler holdEventHandler = new HoldButtonHandler(mainBlackjack.getCurrentRealPlayer());

    private final Button btnSplit = new Button();
    private final Button btnDouble = new Button();
    private final Button btnHit = new Button();
    private final Button btnHold = new Button();

    private final Label money = new Label("Money:");
    private final Label subtotal = new Label("Subtotal:");

    public BlackjackScene(Navigator navigator) {
        super(navigator);
    }

    @Override
    public void update(double deltaInSec) {

        btnSplit.setOnMouseClicked(splitEventHandler);
        btnDouble.setOnMouseClicked(doubleEventHandler);
        btnHit.setOnMouseClicked(hitEventHandler);
        btnHold.setOnMouseClicked(holdEventHandler);
    }

    @Override
    public void paint() {
        AnchorPane mainAnchorPain = new AnchorPane();


        money.setFont(new Font("Arial", 25));
        subtotal.setFont(new Font("Arial", 25));
        money.setTextFill(Color.web("#000000"));
        subtotal.setTextFill(Color.web("#000000"));


        mainAnchorPain.setPrefSize(BaseScene.SCREEN_WIDTH, BaseScene.SCREEN_HEIGHT);
        AnchorPane.setTopAnchor(money, 10.0);
        AnchorPane.setBottomAnchor(subtotal, 10.0);
//        AnchorPane.setLeftAnchor(subtotal, 10.0);

        mainAnchorPain.getChildren().addAll(money, subtotal);

        VBox mainVBox = new VBox(mainAnchorPain);


        getGroup().getChildren().add(mainVBox);
        super.paint();
    }


}