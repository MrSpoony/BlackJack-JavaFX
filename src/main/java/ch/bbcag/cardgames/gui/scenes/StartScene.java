package ch.bbcag.cardgames.gui.scenes;

import ch.bbcag.cardgames.common.scene.Navigator;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

import java.util.Objects;

public class StartScene extends BackgroundScene {

    private static final String IMAGE_PATH_FROM_AS = "/pokerdeck/AS.png";
    private static final String IMAGE_PATH_FROM_AC = "/pokerdeck/AC.png";
    private static final String IMAGE_PATH_FROM_AH = "/pokerdeck/AH.png";

    private static final int POSX_FOR_AC = 250;
    private static final int POSY_FOR_AC = 190;
    private static final int POSX_FOR_AS = 210;
    private static final int POSY_FOR_AS = 380;

    private static final double WIDTH_CARD = 250;
    private static final double HEIGHT_CARD = 350;

    private static final Image as = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_FROM_AS)));
    private static final Image ac = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_FROM_AC)));
    private static final Image ah = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_FROM_AH)));

    public StartScene(Navigator navigator) {
        super(navigator);
    }

    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void paint(){
        super.paint();
        drawRotatedImage(gc, ac, -30, POSX_FOR_AC, POSY_FOR_AC, HEIGHT_CARD, WIDTH_CARD);
        drawRotatedImage(gc, as, 0, POSX_FOR_AS, POSY_FOR_AS, HEIGHT_CARD, WIDTH_CARD);
    }
    private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double posX, double posY, double HEIGHT_CARD, double WIDTH_CARD){
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
