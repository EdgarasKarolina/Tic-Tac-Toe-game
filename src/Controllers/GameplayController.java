package Controllers;

import View.Gameplay;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;


public class GameplayController {

    Gameplay gameplay = new Gameplay();

    public Scene getGameViewStage()
    {
        return gameplay.getGameplay();
    }

    public static void setXonButton(Button button, Image imgWhiteX, ArrayList<Button> xListOfButtons) {
        button.setGraphic(new ImageView(imgWhiteX));
        button.setDisable(true);
        xListOfButtons.add(button);
    }

    public static void setOonButton(Button button, Image imgWhite0, ArrayList<Button> oListOfButtons) {
        button.setGraphic(new ImageView(imgWhite0));
        button.setDisable(true);
        oListOfButtons.add(button);
    }

    public static void setBlackBackground(List<Button> buttons, Image background) {
        for (Button button : buttons)
            button.setGraphic(new ImageView(background));
    }
}
