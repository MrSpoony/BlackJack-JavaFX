package ch.bbcag.cardgames.gui.scenes;


import ch.bbcag.cardgames.blackjack.Blackjack;
import ch.bbcag.cardgames.blackjack.buttonhandler.*;
import ch.bbcag.cardgames.blackjack.players.Dealer;
import ch.bbcag.cardgames.blackjack.players.RealPlayer;
import ch.bbcag.cardgames.common.cards.Card;
import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import ch.bbcag.cardgames.gui.common.LabelLayout;
import ch.bbcag.cardgames.gui.common.PositionOfNodes;
import ch.bbcag.cardgames.gui.common.TransparentButton;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BlackjackScene extends BackgroundScene {

    private static final double CARDS_Y_OFFSET = 50;

    private static final double WIDTH_PLAYER_CARDS = 125;
    private static final double HEIGHT_PLAYER_CARDS = 175;
    private static final double POSITION_Y_PLAYER_CARDS = canvas.getHeight() - HEIGHT_PLAYER_CARDS - CARDS_Y_OFFSET;
    private static final double PLAYER_CARDS_INITIAL_X = 150;
    private static final double PLAYER_CARDS_X_SPACE = canvas.getWidth() - PLAYER_CARDS_INITIAL_X - 350;
    private static final double PLAYER_CARDS_INCREMENT_CHANGE = 5;

    private static final double PLAY_AGAIN_BUTTON_TEXT_SIZE = 50;
    private static final double WINNER_IS_TEXT_SIZE = 100;
    private static final double PLAY_AGAIN_BUTTON_MAX_HEIGHT = 20;
    private static final String PLAY_AGAIN_BUTTON_RGBA = "0.5, 0.5, 0.5, 0.2";
    private static final String PLAY_AGAIN_BUTTON_TEXT_RGB = "#ffffff";
    private static final String WINNER_IS_LABEL_RGBA = "1, 1, 1, 0.7";

    private static final double WIDTH_DEALER_CARDS = 83;
    private static final double HEIGHT_DEALER_CARDS = 117;
    private static final double POSITION_Y_DEALER_CARDS = CARDS_Y_OFFSET;
    private static final double DEALER_CARDS_INITIAL_X = 300;
    private static final double DEALER_CARDS_X_SPACE = canvas.getWidth() - (2 * DEALER_CARDS_INITIAL_X);
    private static final double DEALER_CARDS_INCREMENT_CHANGE = 3;

    private static final String PATH_TO_BACK_CARD = "/pokerdeck/1B.png";
    private static final Image BACK_CARD_IMAGE = new Image(Objects.requireNonNull(BlackjackScene.class.getResourceAsStream(PATH_TO_BACK_CARD)));

    private static final TransparentButton SPLIT_BUTTON = new TransparentButton("Split");
    private static final TransparentButton DOUBLE_BUTTON = new TransparentButton("Double");
    private static final TransparentButton HIT_BUTTON = new TransparentButton("Hit");
    private static final TransparentButton HOLD_BUTTON = new TransparentButton("Hold");
    private static final TransparentButton HELP_BUTTON = new TransparentButton("Help");
    private static final TransparentButton SET_BUTTON = new TransparentButton("Set");
    private static final TransparentButton EXIT_BUTTON = new TransparentButton("Exit");
    private static final TransparentButton PLAY_AGAIN_BUTTON = new TransparentButton("Play again?");

    private static final LabelLayout MONEY_LABEL = new LabelLayout("Money:");
    private static final LabelLayout INSERT_MONEY_LABEL = new LabelLayout("Your Insert:");
    private static final LabelLayout WINNER_IS_LABEL = new LabelLayout("");
    private static final TextField INSERT_MONEY_TEXT_FIELD = new TextField("Enter your Money ");

    private static final double MONEY_TEXT_FIELD_WIDTH = 150;
    private static final double MONEY_TEXT_FIELD_HEIGHT = 30;

    private static final double MARGIN_ANCHOR_PANE = 10.0;
    private static final double MARGIN_MONEY_INSERTS = 75.5;
    private static final double MARGIN_MONEY_LABEL = 100;
    private static final double MARGIN_BUTTONS = 50.0;

    private static final double SPACING_IN_H_BOXES = 10;
    private static final double SPACING_IN_V_BOX = 20;

    private static final AnchorPane ANCHOR_PANE = new AnchorPane();
    private static final HBox BOTTOM_RIGHT_H_BOX = new HBox();
    private static final HBox TOP_RIGHT_H_BOX = new HBox();
    private static final HBox H_BOX_SET_BUTTON = new HBox();
    private static final VBox WIN_SCREEN_V_BOX = new VBox(SPACING_IN_V_BOX);
    private static final BorderPane CENTER_BORDERPANE = new BorderPane();

    private double playerXIncrement = WIDTH_PLAYER_CARDS - 25;
    private double dealerXIncrement = WIDTH_DEALER_CARDS - 25;

    private List<Card> playerCards = new ArrayList<>();
    private List<Card> dealerCards = new ArrayList<>();

    private Blackjack blackjack;
    private RealPlayer player;
    private Dealer dealer;

    private String winner = "";

    public BlackjackScene(Navigator navigator) {
        super(navigator);
    }

    @Override
    public void update(double deltaInSec) {
        setButtonAvailable();
        updateVariables();
        updateMoneyLabel();
        doWhenPlayerDone();
    }


    @Override
    public void paint() {
        clearCanvas();
        super.paint();
        drawCards();
    }

    @Override
    public void onEnter() {
        super.onEnter();
        setupScene();
    }

    public void newGame() {
        blackjack.newGame();
        setupVariablesForNewGame();
        hidePlayAgain();
        makeButtonsAvailable();
    }

    private void drawCards() {
        drawPlayerCards();
        drawDealerCards();
    }

    private void setupScene() {
        setupVariables();
        setupButtonHandlers();
        setPositionOfNodes();
        setupHBoxes();
        setupAnchorPane();
        setupEndScreen();
        setGUI();
    }

    private void doWhenPlayerDone() {
        if (player.isDone()) {
            winner = blackjack.dealersTurn();
            showPlayAgain();
        }
    }

    private void updateMoneyLabel() {
        MONEY_LABEL.setText("Your Money: " + player.getMoney());
    }

    private void setButtonAvailable() {
        if (!player.isSplitPossible()) SPLIT_BUTTON.setButtonNotAvailable();
        if (!player.canTakeACard()) HIT_BUTTON.setButtonNotAvailable();
        if (!player.isDoubleDownPossible()) DOUBLE_BUTTON.setButtonNotAvailable();
    }

    private void makeButtonsAvailable() {
        SPLIT_BUTTON.setButtonAvailable();
        HIT_BUTTON.setButtonAvailable();
        DOUBLE_BUTTON.setButtonAvailable();
    }

    private void showPlayAgain() {
        showPlayAgainButton();
        WINNER_IS_LABEL.setText(winner);
    }

    private void hidePlayAgain() {
        hidePlayAgainButton();
        WINNER_IS_LABEL.setText("");
    }

    private void hidePlayAgainButton() {
        PLAY_AGAIN_BUTTON.setDisable(true);
        PLAY_AGAIN_BUTTON.setVisible(false);
    }

    private void showPlayAgainButton() {
        PLAY_AGAIN_BUTTON.setDisable(false);
        PLAY_AGAIN_BUTTON.setVisible(true);
    }

    private void setupHBoxes() {
        setupTopRightHBox();
        H_BOX_SET_BUTTON.getChildren().add(SET_BUTTON);
        setupBottomRightHBox();
    }

    private void setupAnchorPane() {
        INSERT_MONEY_TEXT_FIELD.setPrefSize(MONEY_TEXT_FIELD_WIDTH, MONEY_TEXT_FIELD_HEIGHT);
        ANCHOR_PANE.setPrefSize(BaseScene.SCREEN_WIDTH, BaseScene.SCREEN_HEIGHT);
        ANCHOR_PANE.getChildren().addAll(MONEY_LABEL, INSERT_MONEY_TEXT_FIELD, INSERT_MONEY_LABEL, BOTTOM_RIGHT_H_BOX, TOP_RIGHT_H_BOX, H_BOX_SET_BUTTON);
    }

    private void setupEndScreen() {
        hidePlayAgainButton();
        PLAY_AGAIN_BUTTON.setStyle("-fx-background-color:rgba(" + PLAY_AGAIN_BUTTON_RGBA + "); -fx-text-fill: " + PLAY_AGAIN_BUTTON_TEXT_RGB + ";" +
                " -fx-font-size: " + PLAY_AGAIN_BUTTON_TEXT_SIZE + "; -fx-max-height: " + PLAY_AGAIN_BUTTON_MAX_HEIGHT + ";");
        WIN_SCREEN_V_BOX.getChildren().addAll(CENTER_BORDERPANE, PLAY_AGAIN_BUTTON);
        WINNER_IS_LABEL.setStyle("-fx-text-fill: rgba(" + WINNER_IS_LABEL_RGBA + "); -fx-font-size: " + WINNER_IS_TEXT_SIZE + "; -fx-font-family: Arial");

        WINNER_IS_LABEL.setAlignment(Pos.CENTER);
        CENTER_BORDERPANE.setCenter(WINNER_IS_LABEL);
        WIN_SCREEN_V_BOX.setAlignment(Pos.CENTER);
    }

    private void setGUI() {
        WIN_SCREEN_V_BOX.setPickOnBounds(false);
        ANCHOR_PANE.setPickOnBounds(false);
        getStackPane().getChildren().addAll(ANCHOR_PANE, WIN_SCREEN_V_BOX);
    }

    private void setupBottomRightHBox() {
        BOTTOM_RIGHT_H_BOX.setSpacing(SPACING_IN_H_BOXES);
        BOTTOM_RIGHT_H_BOX.getChildren().addAll(HIT_BUTTON, HOLD_BUTTON, DOUBLE_BUTTON, SPLIT_BUTTON);
    }

    private void setupTopRightHBox() {
        TOP_RIGHT_H_BOX.setSpacing(SPACING_IN_H_BOXES);
        TOP_RIGHT_H_BOX.getChildren().addAll(HELP_BUTTON, EXIT_BUTTON);
    }

    private void setPositionOfNodes() {
        PositionOfNodes.setAllFourPositions(MONEY_LABEL, HELP_BUTTON, INSERT_MONEY_LABEL, MARGIN_ANCHOR_PANE);
        PositionOfNodes.setBottomRightForSpecials(INSERT_MONEY_LABEL, MARGIN_MONEY_LABEL, MARGIN_MONEY_INSERTS);
        PositionOfNodes.setBottomRightForSpecials(INSERT_MONEY_TEXT_FIELD, MARGIN_MONEY_INSERTS, MARGIN_BUTTONS);
        PositionOfNodes.setBottomRightLbl(BOTTOM_RIGHT_H_BOX, MARGIN_ANCHOR_PANE);
        PositionOfNodes.setTopRightLbl(TOP_RIGHT_H_BOX, MARGIN_ANCHOR_PANE);
        PositionOfNodes.setBottomRightForSpecials(H_BOX_SET_BUTTON, MARGIN_ANCHOR_PANE, MARGIN_BUTTONS);
    }

    private void setupVariablesForNewGame() {
        player = blackjack.getPlayer();
        dealer = blackjack.getDealer();
        playerCards = player.getCards();
        dealerCards = dealer.getCards();
    }

    private void setupVariables() {
        blackjack = new Blackjack();
        player = blackjack.getPlayer();
        dealer = blackjack.getDealer();
        playerCards = player.getCards();
        dealerCards = dealer.getCards();
    }

    private void setupButtonHandlers() {
        SplitButtonHandler splitButtonHandler = new SplitButtonHandler(player);
        SPLIT_BUTTON.setOnAction(splitButtonHandler);

        DoubleButtonHandler doubleButtonHandler = new DoubleButtonHandler(player);
        DOUBLE_BUTTON.setOnAction(doubleButtonHandler);

        HitButtonHandler hitButtonHandler = new HitButtonHandler(player);
        HIT_BUTTON.setOnAction(hitButtonHandler);

        HoldButtonHandler holdButtonHandler = new HoldButtonHandler(player);
        HOLD_BUTTON.setOnAction(holdButtonHandler);

        BetButtonHandler betButtonHandler = new BetButtonHandler(player, INSERT_MONEY_TEXT_FIELD);
        SET_BUTTON.setOnAction(betButtonHandler);

        ReplayButtonHandler replayButtonHandler = new ReplayButtonHandler(blackjack, this);
        PLAY_AGAIN_BUTTON.setOnAction(replayButtonHandler);

        EXIT_BUTTON.setOnAction(actionEvent -> Platform.exit());
    }

    private void clearCanvas() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawPlayerCards() {
        double posXPlayerCards = PLAYER_CARDS_INITIAL_X;
        calculatePlayerXIncrement();
        for (Card card : playerCards) {
            gc.drawImage(card.getImage(), posXPlayerCards, POSITION_Y_PLAYER_CARDS, WIDTH_PLAYER_CARDS, HEIGHT_PLAYER_CARDS);
            posXPlayerCards += playerXIncrement;
        }
    }

    private void drawDealerCards() {
        double posXDealerCards = DEALER_CARDS_INITIAL_X;
        calculateDealerXIncrement();
        if (!dealer.isDealersTurn()) {
            gc.drawImage(BACK_CARD_IMAGE, posXDealerCards, POSITION_Y_DEALER_CARDS, WIDTH_DEALER_CARDS, HEIGHT_DEALER_CARDS);
            posXDealerCards += dealerXIncrement;
            gc.drawImage(dealer.getCards().get(1).getImage(), posXDealerCards, POSITION_Y_DEALER_CARDS, WIDTH_DEALER_CARDS, HEIGHT_DEALER_CARDS);
        } else {
            for (Card card : dealerCards) {
                gc.drawImage(card.getImage(), posXDealerCards, POSITION_Y_DEALER_CARDS, WIDTH_DEALER_CARDS, HEIGHT_DEALER_CARDS);
                posXDealerCards += dealerXIncrement;
            }
        }
    }

    private void calculatePlayerXIncrement() {
        if (playerCards.size() * playerXIncrement >= PLAYER_CARDS_X_SPACE) {
            if (playerXIncrement > PLAYER_CARDS_INCREMENT_CHANGE) {
                playerXIncrement -= PLAYER_CARDS_INCREMENT_CHANGE;
            }
        }
    }

    private void calculateDealerXIncrement() {
        if (dealerCards.size() * dealerXIncrement >= DEALER_CARDS_X_SPACE) {
            if (dealerXIncrement >= DEALER_CARDS_INCREMENT_CHANGE) {
                dealerXIncrement -= DEALER_CARDS_INCREMENT_CHANGE;
            }
        }
    }

    private void updateVariables() {
        playerCards = player.getCards();
        dealerCards = dealer.getCards();
    }
}