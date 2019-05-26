package View;

import Controllers.CredentialsController;
import Model.TTTButton;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MainMenu {

    Scene scnMainMenu;
    VBox vBoxMainMenu = new VBox();
    TTTButton btnVsFriend = new TTTButton("vs Friend");
    TTTButton btnVsComputer = new TTTButton("vs Computer");
    TTTButton btnCredits = new TTTButton("Credits");
    TTTButton btnQuit = new TTTButton("Quit");
    ImageView imgLogo = new ImageView();

    CredentialsController credentialsController = new CredentialsController();

    public Scene getMainMenu()
    {
        scnMainMenu = new Scene(vBoxMainMenu, 200, 300);
        scnMainMenu.getStylesheets().add("Resources/Styles/MainMenuStyles.css");

        btnVsFriend.getStyleClass().add("main-menu-button");
        btnVsComputer.getStyleClass().add("main-menu-button");
        btnCredits.getStyleClass().add("main-menu-button");
        btnQuit.getStyleClass().add("main-menu-button");
        vBoxMainMenu.getStyleClass().add("main-menu-vbox");

        vBoxMainMenu.getChildren().addAll(imgLogo, btnVsFriend, btnVsComputer, btnCredits, btnQuit);
        this.setButtonsOnAction();

        return scnMainMenu;
    }

    public void setButtonsOnAction()
    {
        btnVsFriend.setOnAction(event -> {
            credentialsController.setCredentialsToStage();
        });

        btnVsComputer.setOnAction(event -> {
            //ToDo
        });

        btnCredits.setOnAction(event -> {
            //ToDo
        });

        btnQuit.setOnAction(event -> {
            System.exit(1);
        });
    }
}
