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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;


public class BlackjackScene extends BackgroundScene {


    private static int NUMBER_OF_PLAYERS = 1;
    private final int NUMBER_OF_DECKS = 6;
    private String cardFace;


    private Blackjack blackjack;
    private final Stack stack = new Stack(NUMBER_OF_DECKS);
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


    private final TextField moneyInsertTxt = new TextField("Enter your Money Insert");

    private final double marginforAnchorPain = 10.0;
    private final double marginForMoneyInserts = 75.5;
    private final double marginForButtons = 50.0;

    private final double textFieldWidth = 150;
    private final double textFieldHeight = 30;

    private final double posXDefault = 150;
    private final double posY = 360;
    private final double widtForCards = 125;
    private final double heightForCards = 175;


    public BlackjackScene(Navigator navigator) {
        super(navigator);
    }

    @Override
    public void update(double deltaInSec) {
        btnDouble.setOnMouseClicked(doubleButtonHandler);
        btnSplit.setOnMouseClicked(splitButtonHandler);
        btnHold.setOnMouseClicked(holdButtonHandler);
        btnHit.setOnMouseClicked(hitButtonHandler);

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


        player = blackjack.getPlayer();
        cards = player.getCards();

       double posX = posXDefault;
       for(Card card : cards){
           gc.drawImage(card.getImage() , posX, posY, widtForCards, heightForCards);
           posX +=50;
       }


        mainHbox.setSpacing(5);

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
}


