package View;

import Model.TTTButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenu {

    Scene scnMainMenu;
    VBox vBoxMainMenu = new VBox();
    TTTButton btnVsFriend = new TTTButton("vs Friend");
    TTTButton btnVsComputer = new TTTButton("vs Computer");
    TTTButton btnCredits = new TTTButton("Credits");
    TTTButton btnQuit = new TTTButton("Quit");
    ImageView imgLogo;

    public Scene getMainMenu()
    {
        scnMainMenu = new Scene(vBoxMainMenu, 200, 300);
        scnMainMenu.getStylesheets().add("Resources/Styles/MainMenuStyles.css");

        btnVsFriend.getStyleClass().add("main-menu-button");
        btnVsComputer.getStyleClass().add("main-menu-button");
        btnCredits.getStyleClass().add("main-menu-button");
        btnQuit.getStyleClass().add("main-menu-button");

        vBoxMainMenu.getChildren().addAll(imgLogo, btnVsFriend, btnVsComputer, btnCredits, btnQuit);
        this.setButtonsOnAction();

        return scnMainMenu;
    }

    public void setButtonsOnAction()
    {
        btnVsFriend.setOnAction(event -> {
            //ToDO
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
