package ch.bbcag.cardgames;

import ch.bbcag.cardgames.common.scene.Navigator;
import ch.bbcag.cardgames.common.scene.SceneType;
import ch.bbcag.cardgames.gui.scenes.BlackjackScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Navigator nav = new Navigator(stage);

        nav.registerScene(SceneType.BLACKJACK, new BlackjackScene(nav));
        nav.navigateTo(SceneType.BLACKJACK);

        stage.show();
    }
}