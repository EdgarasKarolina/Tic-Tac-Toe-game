package View;

import Controllers.GameViewController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by Edgaras on 18/07/2016.
 */
public class EnterNamesView {

    Label pleaseInsertNamesLabel;
    Label player1NameLabel;
    Label player2NameLabel;

    static TextField player1NameTextField = new TextField();
    static TextField player2NameTextField = new TextField();

    Button continueButton;
    Button goBackButton;

    Stage enterNamesStage;
    Scene enterNamesScene;

    VBox vBox;
    HBox hBox;
    HBox hBox2;
    HBox hBox3;

    GameViewController gameViewController = new GameViewController();
    GameView gameView = new GameView();
    PlayersDialogBoxView playersDialogBoxView;


     static StartMenu startMenu = new StartMenu();



    public Scene getEnterNamesScene()
    {

        pleaseInsertNamesLabel = new Label("Insert players names");
        pleaseInsertNamesLabel.setMinSize(130, 40);
        pleaseInsertNamesLabel.setFont(Font.font ("Serif", 20));
        pleaseInsertNamesLabel.setPadding(new Insets(10, 10, 10, 57));
        player1NameLabel = new Label("Player 1 name");
        player1NameLabel.setMinSize(130, 40);
        player1NameLabel.setFont(Font.font ("Serif", 20));
        player2NameLabel = new Label("Player 2 name");
        player2NameLabel.setMinSize(130, 40);
        player2NameLabel.setFont(Font.font ("Serif", 20));
        player1NameTextField = new TextField();
        player1NameTextField.setMinSize(130, 40);
        player1NameTextField.setMaxSize(130, 40);
        player1NameTextField.setFont(Font.font ("Serif", 20));
        player2NameTextField = new TextField();
        player2NameTextField.setMinSize(130, 40);
        player2NameTextField.setMaxSize(130, 40);
        player2NameTextField.setFont(Font.font ("Serif", 20));

        continueButton = new Button("Continue");
        continueButton.setStyle("-fx-background-color: lightyellow");
        continueButton.setMinSize(139, 40);
        continueButton.setFont(Font.font ("Serif", 20));
        continueButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        continueButton.setOnAction(event -> {

            //checks if names are inserted
            //if thei are not inserted asks to insert them
            if (player1NameTextField.getText().trim().equals("") || player2NameTextField.getText().trim().equals(""))
            {
                player1NameTextField.setPromptText("Insert name");
                player2NameTextField.setPromptText("Insert name");

            }
            else if (player1NameTextField.getText().trim().equals(""))
            {
                player1NameTextField.setPromptText("Insert name");
            }

            else if (player2NameTextField.getText().trim().equals(""))
            {
                player2NameTextField.setPromptText("Insert name");
            }

            else {


               startMenu.setSceneToMainStage();

                gameView.setArrayListsToBeEmpty();
                gameView.setWhoHasWonCounterToZero();
                gameView.setNumberOfClicksCounterToRandomNumber();


                playersDialogBoxView = new PlayersDialogBoxView();

                if (gameView.getNumberOfClicksCounter() % 2 == 0) {
                    playersDialogBoxView.p1Starts();
                } else {
                    playersDialogBoxView.p2Starts();
                }
            }
        });


        goBackButton = new Button("Go back");
        goBackButton.setStyle("-fx-background-color: lightyellow");
        goBackButton.setMinSize(139, 40);
        goBackButton.setFont(Font.font ("Serif", 20));
        goBackButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        goBackButton.setOnAction(event -> startMenu.setMainSceneToStage());

        vBox = new VBox();
        hBox = new HBox();
        hBox2 = new HBox();
        hBox3 = new HBox();

        hBox.getChildren().addAll(player1NameLabel, player1NameTextField);
        hBox2.getChildren().addAll(player2NameLabel, player2NameTextField);
        hBox3.getChildren().addAll( goBackButton, continueButton);

        vBox.getChildren().addAll(pleaseInsertNamesLabel, hBox,hBox2, hBox3);
        vBox.setStyle("-fx-background-color: lightblue");

        enterNamesScene = new Scene(vBox, 280, 200);


        return enterNamesScene;

    }

    //returns name of Player 1
    public String getNamePlayer1()
    {
        String name;
        name = player1NameTextField.getText();

        return name;
    }

    //returns name of Player 2
    public String getNamePlayer2()
    {
        String name;
        name = player2NameTextField.getText();

        return name;
    }

}
