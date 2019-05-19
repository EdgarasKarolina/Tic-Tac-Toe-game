package View;

import Model.TTTButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenu {

    Stage mainMenuStage;
    Scene mainMenuScene;
    VBox mainMenuVBox = new VBox();
    TTTButton vsFriendButton = new TTTButton("vs Friend");
    TTTButton vsComputerButton = new TTTButton("vs Computer");
    TTTButton creditsButton = new TTTButton("Credits");
    TTTButton quitButton = new TTTButton("Quit");
    ImageView logoImage;

    public Scene getMainMenu()
    {
        vsFriendButton.setStyle("-fx-background-color: lightyellow");
        vsFriendButton.setMinSize(130, 40);
        vsFriendButton.setFont(Font.font ("Serif", 20));
        vsFriendButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");

        vsComputerButton.setStyle("-fx-background-color: lightyellow");
        vsComputerButton.setMinSize(130, 40);
        vsComputerButton.setFont(Font.font ("Serif", 20));
        vsComputerButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15, 0.0 , 2 , 0)");

        creditsButton.setStyle("-fx-background-color: lightyellow");
        creditsButton.setMinSize(130, 40);
        creditsButton.setFont(Font.font ("Serif", 20));
        creditsButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");

        quitButton.setStyle("-fx-background-color: lightyellow");
        quitButton.setMinSize(130, 40);
        quitButton.setFont(Font.font ("Serif", 20));
        quitButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");

        mainMenuVBox.setStyle("-fx-background-color: lightblue");
        mainMenuVBox.setAlignment(Pos.CENTER);
        mainMenuVBox.setSpacing(20);
        mainMenuVBox.getChildren().addAll(logoImage, vsFriendButton, vsComputerButton, creditsButton, quitButton);

        mainMenuScene = new Scene(mainMenuVBox, 200, 300);
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
