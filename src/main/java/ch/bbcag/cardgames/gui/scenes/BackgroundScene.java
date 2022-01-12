package ch.bbcag.cardgames.gui.scenes;

import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import javafx.scene.image.Image;

import java.util.Objects;

public abstract class BackgroundScene extends BaseScene {

    private static final String BACKGROUND_IMAGE_PATH = "/backgrounds/mat.png";
    protected final Image image = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(BACKGROUND_IMAGE_PATH)));


    public BackgroundScene(Navigator navigator) {
        super(navigator);
    }

    @Override
    public void onEnter() {
        super.onEnter();
        gc.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight());
    }
}