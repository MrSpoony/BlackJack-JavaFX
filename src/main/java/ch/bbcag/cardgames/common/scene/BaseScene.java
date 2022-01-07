package ch.bbcag.cardgames.common.scene;

import ch.bbcag.cardgames.common.eventhandler.KeyEventHandler;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class BaseScene extends Scene implements Initialization {

    public static final double SCREEN_WIDTH = 859;
    public static final double SCREEN_HEIGHT = 540;


    protected static Navigator nav;
    public static GraphicsContext gc;
    protected static Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
    protected KeyEventHandler keyEventHandler = new KeyEventHandler();
    protected boolean exiting = false;

    private long lastTimeInNanoSec;

    public BaseScene(Navigator navigator) {
        super(new Group());
        nav = navigator;
    }

    private void setupScene() {
        gc = canvas.getGraphicsContext2D();
        getGroup().getChildren().add(canvas);
        setOnKeyPressed(keyEventHandler);
        setOnKeyReleased(keyEventHandler);

        lastTimeInNanoSec = System.nanoTime();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentTime) {
                if (exiting) {
                    this.stop();
                } else {
                    long deltaInNanoSec = currentTime - lastTimeInNanoSec;
                    double deltaInSec = deltaInNanoSec / 1e9d;
                    lastTimeInNanoSec = currentTime;
                    update(deltaInSec);
                    paint();
                }
            }
        };
        timer.start();
    }

    public abstract void update(double deltaInSec);

    public abstract void paint();

    protected Group getGroup() {
        return (Group) getRoot();
    }

    public void onEnter() {
        exiting = false;
        setupScene();
    }

    public void onExit() {
        exiting = true;
    }
}