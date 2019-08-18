package Controllers;

import View.GameView;
import javafx.scene.Scene;

/**
 * Created by Edgaras on 15/07/2016.
 */
public class GameViewController {

    GameView gameView = new GameView();

    public Scene getGameViewStage()
    {
        return gameView.getGameplay();
    }




}
