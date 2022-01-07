package ch.bbcag.cardgames.gui.scenes;


import ch.bbcag.cardgames.blackjack.Blackjack;
import ch.bbcag.cardgames.blackjack.Stack;
import ch.bbcag.cardgames.blackjack.buttonhandler.DoubleButtonHandler;
import ch.bbcag.cardgames.blackjack.buttonhandler.HitButtonHandler;
import ch.bbcag.cardgames.blackjack.buttonhandler.HoldButtonHandler;
import ch.bbcag.cardgames.blackjack.buttonhandler.SplitButtonHandler;
import ch.bbcag.cardgames.blackjack.players.Player;
import ch.bbcag.cardgames.common.cards.Card;
import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import ch.bbcag.cardgames.gui.common.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BlackjackScene extends BackgroundScene {

    private static int NUMBER_OF_PLAYERS = 1;
    private final int NUMBER_OF_DECKS = 6;
    private String cardFace;

    private Blackjack blackjack;
    private Stack stack = new Stack(NUMBER_OF_DECKS);
    private Player player;

    private List<Card> cards = new ArrayList<>();


    private final TransparentButton btnSplit = new TransparentButton("Split");
    private final TransparentButton btnDouble = new TransparentButton("Double");
    private final TransparentButton btnHit = new TransparentButton("Hit");
    private final TransparentButton btnHold = new TransparentButton("Hold");
    private final TransparentButton btnHelp = new TransparentButton("Help");
    private final TransparentButton btnSet = new TransparentButton("Set");

    private SplitButtonHandler splitButtonHandler;
    private DoubleButtonHandler doubleButtonHandler;
    private HitButtonHandler hitButtonHandler;
    private HoldButtonHandler holdButtonHandler;

    private final LabelLayout moneyLbl = new LabelLayout("Money:");
    private final LabelLayout subtotalLbl = new LabelLayout("Subtotal:");
    private final LabelLayout moneyInsertLbl = new LabelLayout("Your Insert:");

    private final String IMAGE_PATH = "/pokerdeck/2B.png";

    private final TextField moneyInsertTxt = new TextField("Enter your Money Insert");

    private final double marginforAnchorPain = 10.0;
    private final double marginForMoneyInserts = 75.5;
    private final double marginForButtons = 50.0;

    private final double textFieldWidth = 150;
    private final double textFieldHeight = 30;

    private double posX = 150;
    private final double posY = 360;
    private final double widtForCards = 125;
    private final double heightForCards = 175;

    //private Card card = new Card(cardFace);
    private Image card5 = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(IMAGE_PATH)));

    public BlackjackScene(Navigator navigator) {
        super(navigator);
    }

    @Override
    public void update(double deltaInSec) {
        btnDouble.setOnMouseClicked(doubleButtonHandler);
        btnSplit.setOnMouseClicked(splitButtonHandler);
        btnHit.setOnMouseClicked(hitButtonHandler);
        btnHold.setOnMouseClicked(holdButtonHandler);

        player = blackjack.getPlayer();
        cards = player.getCards();


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

        //drawcards(gc, cards);
//        gc.drawImage(card1.getImage(), 150, 360, 125, 175);
//        gc.drawImage(card2.getImage(), 250, 360, 125, 175);
//        gc.drawImage(card3.getImage(), 350, 360, 125, 175);
//        gc.drawImage(card4.getImage(), 450, 360, 125, 175);
//
//        gc.drawImage(card5, 310, 10, 62, 87);
//        gc.drawImage(card3.getImage(), 410, 10, 62, 87);
//        gc.drawImage(card4.getImage(), 460, 10, 62, 87);

        mainAnchorPain.getChildren().addAll(moneyLbl, subtotalLbl, moneyInsertTxt, moneyInsertLbl, mainHbox, hBoxForHelpbtn, hBoxForSetbtn);

        PositionOfNodes.setBottomRightLbl(mainHbox, marginforAnchorPain);
        PositionOfNodes.setTopRightLbl(hBoxForHelpbtn, marginforAnchorPain);
        PositionOfNodes.setBottomRightForSpecials(hBoxForSetbtn, marginforAnchorPain, marginForButtons);


        getGroup().getChildren().add(mainAnchorPain);
    }

    @Override
    public void onEnter() {
        blackjack = new Blackjack(NUMBER_OF_PLAYERS);

        splitButtonHandler = new SplitButtonHandler(blackjack.getPlayer());
        doubleButtonHandler = new DoubleButtonHandler(blackjack.getPlayer());
        hitButtonHandler = new HitButtonHandler(blackjack.getPlayer());
        holdButtonHandler = new HoldButtonHandler(blackjack.getPlayer());

        super.onEnter();
    }

/*
    private void drawcards(GraphicsContext gc, List<Card> cards) {

        for (Card card : cards) {
            if (btnHit.isPressed()) {
                 gc.drawImage(card.getImage(), posX, posY, widtForCards, heightForCards);
                 posX += 50;
                 System.out.println(posX);
            }
            else if (!btnHit.isPressed()){
                break;
            }
        }
    }

 */
}
