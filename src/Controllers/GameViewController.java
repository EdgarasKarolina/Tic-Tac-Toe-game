package Controllers;

import View.GameView;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Edgaras on 15/07/2016.
 */
public class GameViewController {

    GameView gameView = new GameView();

    public Scene getGameViewStage()
    {
        return gameView.getGameStage();
    }




}
