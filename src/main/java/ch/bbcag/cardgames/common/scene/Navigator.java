package ch.bbcag.cardgames.common.scene;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Navigator {

    private Stage stage;
    private Map<SceneType, BaseScene> sceneMap = new HashMap<>();
    private BaseScene currentScene;

    public Navigator(Stage stage) {
        this.stage = stage;
    }

    public void registerScene(SceneType sceneType, BaseScene scene) {
        sceneMap.put(sceneType, scene);
    }

    public void navigateTo(SceneType sceneType) {
        if (currentScene != null) {
            currentScene = (BaseScene) stage.getScene();
            currentScene.onExit();
        }
        currentScene = sceneMap.get(sceneType);
        currentScene.onEnter();
        stage.setScene(currentScene);
    }

    public BaseScene getScene(SceneType sceneType) {
        return sceneMap.get(sceneType);
    }
}