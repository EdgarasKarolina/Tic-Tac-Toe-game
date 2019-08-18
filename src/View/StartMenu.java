package View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import Controllers.GameViewController;
import Controllers.EnterNamesController;


public class StartMenu extends Application {

    Button btnVsFriend = new Button("vs Friend");
    Button btnVsComputer = new Button("vs Computer");
    Button btnCredits = new Button("Credits");
    Button btnQuit = new Button("Quit");

    VBox vBoxMainMenu;

    static Stage mainStage;
    Scene scnMainMenu;

    GameViewController gameViewController = new GameViewController();
    EnterNamesController enterNamesController = new EnterNamesController();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        mainStage = new Stage();
        mainStage.setScene(getScnMainMenu());
        mainStage.show();
    }

    public Scene getScnMainMenu()
    {
        vBoxMainMenu = new VBox();

        scnMainMenu = new Scene(vBoxMainMenu, 200, 300);

        btnVsFriend.getStyleClass().add("main-menu-button");
        btnVsComputer.getStyleClass().add("main-menu-button");
        btnCredits.getStyleClass().add("main-menu-button");
        btnQuit.getStyleClass().add("main-menu-button");
        vBoxMainMenu.getStyleClass().add("main-menu-vbox");

        scnMainMenu.getStylesheets().add("Resources/Styles/MainMenuStyles.css");
        vBoxMainMenu.getChildren().addAll(btnVsFriend, btnVsComputer, btnCredits, btnQuit);
        vBoxMainMenu.setAlignment(Pos.CENTER);
        vBoxMainMenu.setSpacing(20);

        this.setButtonsOnAction();

        return scnMainMenu;
    }

    public void setButtonsOnAction()
    {
        btnVsFriend.setOnAction(event -> {
            mainStage.setScene(enterNamesController.getEnterNamesView());
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

    public void setSceneToMainStage()
    {
        mainStage.setScene(gameViewController.getGameViewStage());
    }

    public void setMainSceneToStage()
    {
        mainStage.setScene(getScnMainMenu());
    }
}
