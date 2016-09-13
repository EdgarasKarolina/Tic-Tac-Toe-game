package View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import Controllers.GameViewController;
import Controllers.EnterNamesController;

/**
 * Created by Edgaras on 15/07/2016.
 */
public class StartMenu extends Application {

    static Stage mainStage;
    Scene mainScene;
    VBox mainVBox;
    Button vsFriendButton;
    Button vsComputerButton;
    Button creditsButton;
    Button quitButton;
    ImageView logoImage;

    GameViewController gameViewController = new GameViewController();
    EnterNamesController enterNamesController = new EnterNamesController();



    @Override
    public void start(Stage primaryStage) throws Exception {



        mainStage = new Stage();
        mainStage.setScene(getMainScene());
        mainStage.show();

    }

    public Scene getMainScene()
    {

        logoImage = new ImageView();

        //buttons
        vsFriendButton = new Button("vs Friend");
        vsFriendButton.setStyle("-fx-background-color: lightyellow");
        vsFriendButton.setMinSize(130, 40);
        vsFriendButton.setFont(Font.font ("Serif", 20));
        vsFriendButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        vsFriendButton.setOnAction(event -> {


            mainStage.setScene(enterNamesController.getEnterNamesView());
        });
        vsComputerButton = new Button("vs Computer");
        vsComputerButton.setStyle("-fx-background-color: lightyellow");
        vsComputerButton.setMinSize(130, 40);
        vsComputerButton.setFont(Font.font ("Serif", 20));
        vsComputerButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15, 0.0 , 2 , 0)");
        creditsButton = new Button("Credits");
        creditsButton.setStyle("-fx-background-color: lightyellow");
        creditsButton.setMinSize(130, 40);
        creditsButton.setFont(Font.font ("Serif", 20));
        creditsButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        quitButton = new Button("Quit");
        quitButton.setStyle("-fx-background-color: lightyellow");
        quitButton.setMinSize(130, 40);
        quitButton.setFont(Font.font ("Serif", 20));
        quitButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        quitButton.setOnAction(event -> {
            System.exit(1);
        });

        mainVBox = new VBox();
        mainVBox.getChildren().addAll(logoImage, vsFriendButton, vsComputerButton, creditsButton, quitButton);
        mainVBox.setStyle("-fx-background-color: lightblue");




        mainScene = new Scene(mainVBox, 200, 300);

        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setSpacing(20);

        return mainScene;
    }

    public void setSceneToMainStage()
    {
        mainStage.setScene(gameViewController.getGameViewStage());
    }

    //setting Start Menu scene to stage
    public void setMainSceneToStage()
    {
        mainStage.setScene(getMainScene());
    }
}
