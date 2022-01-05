package ch.bbcag.cardgames.common.scene;

import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class BaseScene extends Scene implements Initialization{
    public BaseScene(Parent root) {
        super(root);
    }
}