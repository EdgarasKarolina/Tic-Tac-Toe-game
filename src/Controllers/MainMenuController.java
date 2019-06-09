package Controllers;

import View.MainMenu;
import View.Start;
import javafx.scene.Scene;

public class MainMenuController {

    public static MainMenuController mainMenuController = new MainMenuController();

    MainMenu mainMenu = new MainMenu();

    public void setMainMenuToStage()
    {
        Start.setSceneToStage(getMainMenuScene());
    }

    public Scene getMainMenuScene()
    {
        return mainMenu.getMainMenu();
    }
}
