package View;

import Model.TTTButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenu {

    Scene mainMenuScene;
    VBox mainMenuVBox = new VBox();
    TTTButton vsFriendButton = new TTTButton("vs Friend");
    TTTButton vsComputerButton = new TTTButton("vs Computer");
    TTTButton creditsButton = new TTTButton("Credits");
    TTTButton quitButton = new TTTButton("Quit");
    ImageView logoImage;

    public Scene getMainMenu()
    {
        mainMenuScene = new Scene(mainMenuVBox, 200, 300);
        mainMenuScene.getStylesheets().add("Resources/Styles/MainMenuStyles.css");

        vsFriendButton.getStyleClass().add("main-menu-button");
        vsComputerButton.getStyleClass().add("main-menu-button");
        creditsButton.getStyleClass().add("main-menu-button");
        quitButton.getStyleClass().add("main-menu-button");

        mainMenuVBox.getChildren().addAll(logoImage, vsFriendButton, vsComputerButton, creditsButton, quitButton);
        this.setButtonsOnAction();

        return mainMenuScene;
    }

    public void setButtonsOnAction()
    {
        vsFriendButton.setOnAction(event -> {
            //ToDO
        });

        vsComputerButton.setOnAction(event -> {
            //ToDo
        });

        creditsButton.setOnAction(event -> {
            //ToDo
        });

        quitButton.setOnAction(event -> {
            System.exit(1);
        });
    }
}
