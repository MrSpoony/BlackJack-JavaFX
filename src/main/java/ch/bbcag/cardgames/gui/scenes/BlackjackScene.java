package ch.bbcag.cardgames.gui.scenes;


import ch.bbcag.cardgames.blackjack.Blackjack;
import ch.bbcag.cardgames.blackjack.buttonhandler.DoubleButtonHandler;
import ch.bbcag.cardgames.blackjack.buttonhandler.HitButtonHandler;
import ch.bbcag.cardgames.blackjack.buttonhandler.HoldButtonHandler;
import ch.bbcag.cardgames.blackjack.buttonhandler.SplitButtonHandler;
import ch.bbcag.cardgames.common.cards.Card;
import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import ch.bbcag.cardgames.gui.common.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class BlackjackScene extends BackgroundScene {

    private static int NUMBER_OF_PLAYERS = 1;

    private Blackjack blackjack = new Blackjack(NUMBER_OF_PLAYERS);


    private final TransparentButton btnSplit = new TransparentButton("Split");
    private final TransparentButton btnDouble = new TransparentButton("Double");
    private final TransparentButton btnHit = new TransparentButton("Hit");
    private final TransparentButton btnHold = new TransparentButton("Hold");
    private final TransparentButton btnHelp = new TransparentButton("Help");
    private final TransparentButton btnSet = new TransparentButton("Set");

    private final SplitButtonHandler splitButtonHandler = new SplitButtonHandler(blackjack.getPlayer());
    private final DoubleButtonHandler doubleButtonHandler = new DoubleButtonHandler(blackjack.getPlayer());
    private final HitButtonHandler hitButtonHandler = new HitButtonHandler(blackjack.getPlayer());
    private final HoldButtonHandler holdButtonHandler = new HoldButtonHandler(blackjack.getPlayer());

    private final LabelLayout moneyLbl = new LabelLayout("Money:");
    private final LabelLayout subtotalLbl = new LabelLayout("Subtotal:");
    private final LabelLayout moneyInsertLbl = new LabelLayout("Your Insert:");

    private final TextField moneyInsertTxt = new TextField("Enter your Money Insert");

    private final double marginforAnchorPain = 10.0;
    private final double marginForMoneyInserts = 75.5;
    private final double marginForButtons = 50.0;

    private final double textFieldWidth = 150;
    private final double textFieldHeight = 30;

    private Card card1 = new Card("2C.png");
    private Card card2 = new Card("3C.png");
    private Card card3 = new Card("4C.png");
    private Card card4 = new Card("5C.png");
    private Card card5 = new Card("2B.png");


    public BlackjackScene(Navigator navigator) {
        super(navigator);
    }

    @Override
    public void update(double deltaInSec) {
        btnDouble.setOnMouseClicked(doubleButtonHandler);
        btnSplit.setOnMouseClicked(splitButtonHandler);
        btnHit.setOnMouseClicked(hitButtonHandler);
        btnHold.setOnMouseClicked(holdButtonHandler);
    }

    @Override
    public void paint() {
        super.paint();
        AnchorPane mainAnchorPain = new AnchorPane();
        HBox mainHbox = new HBox();
        HBox hBoxForHelpbtn = new HBox();
        HBox hBoxForSetbtn = new HBox();


        mainAnchorPain.setPrefSize(BaseScene.SCREEN_WIDTH, BaseScene.SCREEN_HEIGHT);

        PositionOfNodes.setAllFourPositions(moneyLbl, btnHelp, moneyInsertLbl, subtotalLbl, marginforAnchorPain);
        PositionOfNodes.setBottomRightForSpecials(moneyInsertLbl, 100.0, marginForMoneyInserts);
        PositionOfNodes.setBottomRightForSpecials(moneyInsertTxt, marginForMoneyInserts, marginForButtons);

        moneyInsertTxt.setPrefSize(textFieldWidth, textFieldHeight);

        mainHbox.getChildren().addAll(btnHit, btnHold, btnDouble, btnSplit);
        hBoxForHelpbtn.getChildren().add(btnHelp);
        hBoxForSetbtn.getChildren().add(btnSet);


        mainHbox.setSpacing(5);

        gc.drawImage(card1.getImage(), 150, 360, 125, 175);
        gc.drawImage(card2.getImage(), 250, 360, 125, 175);
        gc.drawImage(card3.getImage(), 350, 360, 125, 175);
        gc.drawImage(card4.getImage(), 450, 360, 125, 175);

        gc.drawImage(card5.getImage(), 150, 10, 62, 87);
        gc.drawImage(card2.getImage(), 210, 10, 62, 87);
        gc.drawImage(card3.getImage(), 260, 10, 62, 87);
        gc.drawImage(card4.getImage(), 310, 10, 62, 87);

        mainAnchorPain.getChildren().addAll(moneyLbl, subtotalLbl, moneyInsertTxt, moneyInsertLbl, mainHbox, hBoxForHelpbtn, hBoxForSetbtn);

        PositionOfNodes.setBottomRightLbl(mainHbox, marginforAnchorPain);
        PositionOfNodes.setTopRightLbl(hBoxForHelpbtn, marginforAnchorPain);
        PositionOfNodes.setBottomRightForSpecials(hBoxForSetbtn, marginforAnchorPain, marginForButtons);


        getGroup().getChildren().add(mainAnchorPain);
    }

}