package ch.bbcag.cardgames.gui.scenes;

import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import ch.bbcag.cardgames.gui.common.TextLayout;
import ch.bbcag.cardgames.gui.common.TitleLayout;
import ch.bbcag.cardgames.gui.common.TransparentButton;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;


import java.util.Objects;


public class StartScene extends BackgroundScene {

    private static final String IMAGE_PATH_FROM_AS = "/pokerdeck/AS.png";
    private static final String IMAGE_PATH_FROM_AC = "/pokerdeck/AC.png";
    private static final String IMAGE_PATH_FROM_AH = "/pokerdeck/AH.png";
    private static final String IMAGE_PATH_FROM_AD = "/pokerdeck/AD.png";
    private static final String IMAGE_PATH_ARROW = "/objects/arrow.png";

    private static final int POS_X_FOR_AC = 250;
    private static final int POS_Y_FOR_AC = 120;

    private static final int POS_X_FOR_AS = 210;
    private static final int POS_Y_FOR_AS = 290;

    private static final int POS_X_FOR_AH = 100;
    private static final int POS_Y_FOR_AH = 420;

    private static final int POS_X_FOR_AD = 600;
    private static final int POS_Y_FOR_AD = 580;

    private static final double WIDTH_CARD = 250;
    private static final double HEIGHT_CARD = 350;

    private static final Image as = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_FROM_AS)));
    private static final Image ac = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_FROM_AC)));
    private static final Image ah = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_FROM_AH)));
    private static final Image ad = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_FROM_AD)));
    private static final Image arrow = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_ARROW)));

    private static final TextLayout BLACKJACK = new TextLayout("Blackjack");
    private static final TitleLayout CARDGAMES = new TitleLayout("Select Game: ");
    private static final BorderPane MAIN_BORDER_PANE = new BorderPane();
    private static final VBox MAIN_VBOX = new VBox();

    private static final int NULL = 0;
    private static final int RIGHT_INSETS = 120;
    private static final int LEFT_INSETS = 50;

    private static final int POS_X_Y_ARROW = 60;

    private static final int ANGLE_AC = -30;
    private static final int ANGLE_AH = 30;

    private static final TransparentButton BTN_1_CARD = new TransparentButton("");

    private static final String link = "https://www.blackjackapprenticeship.com/blackjACK-STRATEGY-CHARTS";

    private Application app;

    public StartScene(Navigator navigator, Application app) {
        super(navigator);
        this.app = app;
    }

    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void paint() {
        super.paint();
        setupButtonsAsPicture();
        drawImages();
    }

    private void drawImages() {
        drawRotatedImage(gc, ac, ANGLE_AC, POS_X_FOR_AC, POS_Y_FOR_AC);
        drawRotatedImage(gc, as, NULL, POS_X_FOR_AS, POS_Y_FOR_AS);
        drawRotatedImage(gc, ah, ANGLE_AH, POS_X_FOR_AH, POS_Y_FOR_AH);

        gc.drawImage(arrow, POS_X_Y_ARROW, POS_X_Y_ARROW);
    }


    @Override
    public void onEnter() {
        super.onEnter();
        setupBorderPane();
        setupButtonsAsPicture();
    }

    private void setupButtonsAsPicture(){
        ImageView asForBlackJack = new ImageView(ad);
        asForBlackJack.setRotate(asForBlackJack.getRotate() + 45);
        asForBlackJack.setFitHeight(HEIGHT_CARD);
        asForBlackJack.setFitWidth(WIDTH_CARD);
        BTN_1_CARD.setGraphic(asForBlackJack);
        BTN_1_CARD.setLayoutX(POS_X_FOR_AD);
        BTN_1_CARD.setLayoutY(POS_Y_FOR_AD);
        BTN_1_CARD.setOnAction(e -> app.getHostServices().showDocument(link));
    }

    private void setupBorderPane() {
        setupVBox();
        MAIN_BORDER_PANE.setPrefSize(BaseScene.SCREEN_WIDTH, BaseScene.SCREEN_HEIGHT);
        MAIN_BORDER_PANE.setPadding(new Insets(NULL, RIGHT_INSETS, NULL, LEFT_INSETS));
        MAIN_BORDER_PANE.setRight(BLACKJACK);
        MAIN_BORDER_PANE.setTop(CARDGAMES);


        MAIN_BORDER_PANE.getChildren().addAll(BTN_1_CARD, MAIN_VBOX);
        getGroup().getChildren().add(MAIN_BORDER_PANE);
    }

    private void setupVBox(){
        MAIN_VBOX.getChildren().addAll(BLACKJACK, CARDGAMES);
        MAIN_VBOX.setSpacing(100);
    }

    private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double posX, double posY) {
        gc.save();
        rotate(gc, angle, posX + image.getWidth() / 2, posY + image.getHeight() / 2);
        gc.drawImage(image, posX, posY, WIDTH_CARD, HEIGHT_CARD);
        gc.restore();
    }

    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }
}