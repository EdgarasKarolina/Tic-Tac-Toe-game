package Controllers;

import Model.TTTButton;
import View.GameView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;


public class GameViewController {

    GameView gameView = new GameView();

    public Scene getGameViewStage()
    {
        return gameView.getGameplay();
    }

    public static void setXonButton(Button button, Image imgWhiteX, ArrayList<Button> xListOfButtons)
    {
        button.setGraphic(new ImageView(imgWhiteX));
        button.setDisable(true);
        xListOfButtons.add(button);
    }

    public static void setOonButton(Button button, Image imgWhite0, ArrayList<Button> oListOfButtons )
    {
        button.setGraphic(new ImageView(imgWhite0));
        button.setDisable(true);
        oListOfButtons.add(button);
    }




}
