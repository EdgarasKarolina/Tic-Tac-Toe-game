package View;

import Controllers.GameViewController;
import Controllers.GameplayController;
import Controllers.MainMenuController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Created by Edgaras on 18/07/2016.
 */
public class EnterNamesView {

    Label lblInsertNames = new Label("Insert players names");
    Label lblPlayer1Name = new Label("Player 1 name");
    Label lblPlayer2Name = new Label("Player 2 name");

    static TextField txtPlayer1Name = new TextField();
    static TextField txtPlayer2Name = new TextField();

    Button btnContinue = new Button("Continue");
    Button btnBack = new Button("Go back");

    String msgWarning = "Insert Name";

    Scene scnCredentials;

    VBox vBox = new VBox();
    HBox hBox = new HBox();
    HBox hBox2 = new HBox();
    HBox hBox3 = new HBox();





    GameViewController gameViewController = new GameViewController();
    GameView gameView = new GameView();
    PlayersDialogBoxView playersDialogBoxView;
     static StartMenu startMenu = new StartMenu();


    public Scene getScnCredentials()
    {
        scnCredentials = new Scene(vBox, 280, 200);
        scnCredentials.getStylesheets().add("Resources/Styles/CredentialsStyles.css");

        lblInsertNames.getStyleClass().add("title-label");
        lblPlayer1Name.getStyleClass().add("name-label");
        lblPlayer2Name.getStyleClass().add("name-label");

        txtPlayer1Name.getStyleClass().add("name-text-field");
        txtPlayer2Name.getStyleClass().add("name-text-field");

        
        btnContinue.getStyleClass().add("credentials-button");
        btnBack.getStyleClass().add("credentials-button");

        vBox.getStyleClass().add("credentials-vbox");

        hBox.getChildren().addAll(lblPlayer1Name, txtPlayer1Name);
        hBox2.getChildren().addAll(lblPlayer2Name, txtPlayer2Name);
        hBox3.getChildren().addAll( btnBack, btnContinue);

        vBox.getChildren().addAll(lblInsertNames, hBox,hBox2, hBox3);

        this.setButtonsOnAction();

        return scnCredentials;
        }

    public void setButtonsOnAction()
    {
        btnContinue.setOnAction(event -> {

            if (txtPlayer1Name.getText().trim().equals("") || txtPlayer2Name.getText().trim().equals(""))
            {
                txtPlayer1Name.setPromptText("Insert name");
                txtPlayer2Name.setPromptText("Insert name");
            }
            else if (txtPlayer1Name.getText().trim().equals(""))
                txtPlayer1Name.setPromptText("Insert name");

            else if (txtPlayer2Name.getText().trim().equals(""))
                txtPlayer2Name.setPromptText("Insert name");

            else
                startMenu.setSceneToMainStage();
                gameView.setArrayListsToBeEmpty();
                gameView.setWhoHasWonCounterToZero();
                gameView.setNumberOfClicksCounterToRandomNumber();
                playersDialogBoxView = new PlayersDialogBoxView();

                if (gameView.getNumberOfClicksCounter() % 2 == 0)
                    playersDialogBoxView.p1Starts();

                else
                    playersDialogBoxView.p2Starts();
        });

        btnBack.setOnAction(event -> startMenu.setMainSceneToStage());
    }

    public String getPlayer1Name()
    {
        return  txtPlayer1Name.getText();
    }

    public String getPlayer2Name()
    {
        return  txtPlayer2Name.getText();
    }
}
