package ch.bbcag.cardgames.gui.scenes;

import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import ch.bbcag.cardgames.gui.common.TitleLayout;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Rotate;

import java.util.Objects;

public class StartScene extends BackgroundScene {

    private static final String IMAGE_PATH_FROM_AS = "/pokerdeck/AS.png";
    private static final String IMAGE_PATH_FROM_AC = "/pokerdeck/AC.png";
    private static final String IMAGE_PATH_FROM_AH = "/pokerdeck/AH.png";
    private static final String IMAGE_PATH_FROM_AD = "/pokerdeck/AD.png";

    private static final int POS_X_FOR_AC = 250;
    private static final int POS_Y_FOR_AC = 190;

    private static final int POS_X_FOR_AS = 210;
    private static final int POS_Y_FOR_AS = 380;

    private static final int POS_X_FOR_AH = 100;
    private static final int POS_Y_FOR_AH = 510;

    private static final int POS_X_FOR_AD = -60;
    private static final int POS_Y_FOR_AD = 550;

    private static final double WIDTH_CARD = 250;
    private static final double HEIGHT_CARD = 350;


    private static final Image as = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_FROM_AS)));
    private static final Image ac = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_FROM_AC)));
    private static final Image ah = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_FROM_AH)));
    private static final Image ad = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_FROM_AD)));

    private static final TitleLayout title = new TitleLayout("BlackJack");
    private static final BorderPane MAIN_BORDER_PANE = new BorderPane();


    public StartScene(Navigator navigator) {
        super(navigator);
    }

    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void paint() {
        super.paint();
        drawImages();
    }

    private void drawImages() {
        drawRotatedImage(gc, ac, -30, POS_X_FOR_AC, POS_Y_FOR_AC);
        drawRotatedImage(gc, as, 0, POS_X_FOR_AS, POS_Y_FOR_AS);
        drawRotatedImage(gc, ah, 30, POS_X_FOR_AH, POS_Y_FOR_AH);
        drawRotatedImage(gc, ad, 61, POS_X_FOR_AD, POS_Y_FOR_AD);
    }

    @Override
    public void onEnter() {
        super.onEnter();
        setupBorderPane();
    }

    private void setupBorderPane() {
        MAIN_BORDER_PANE.setPrefSize(BaseScene.SCREEN_WIDTH, BaseScene.SCREEN_HEIGHT);
        MAIN_BORDER_PANE.setTop(title);
        getGroup().getChildren().add(MAIN_BORDER_PANE);
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