package View;

import Controllers.GameplayController;
import Controllers.MainMenuController;
import Model.TTTButton;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Credentials {

    Scene scnCredentials;

    VBox vBox = new VBox();
    HBox hBox = new HBox();
    HBox hBox2 = new HBox();
    HBox hBox3 = new HBox();

    Label lblInsertNames = new Label("Insert players names");
    Label lblPlayer1Name = new Label("Player 1 name");
    Label lblPlayer2Name = new Label("Player 2 name");

    static TextField txtPlayer1Name = new TextField();
    static TextField txtPlayer2Name = new TextField();

    TTTButton btnContinue = new TTTButton("Continue");
    TTTButton btnBack = new TTTButton("Go back");

    String msgWarning = "Insert Name";

    public Scene getCredentials()
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
                txtPlayer1Name.setPromptText(msgWarning);
                txtPlayer2Name.setPromptText(msgWarning);
            }
            else if (txtPlayer1Name.getText().trim().equals(""))
                txtPlayer1Name.setPromptText(msgWarning);

            else if (txtPlayer2Name.getText().trim().equals(""))
                txtPlayer2Name.setPromptText(msgWarning);

            else
                GameplayController.gameplayController.setGameplayToStage();
                GameplayController.gameplayController.ClearSquareButtons();
                GameplayController.gameplayController.setRandomTurnsCounter();

                if (GameplayController.turnsCount % 2 == 0)
                    GameplayController.gameplayController.player1Starts();
                else
                    GameplayController.gameplayController.player2Starts();
        });

        btnBack.setOnAction(event -> {
            MainMenuController.mainMenuController.setMainMenuToStage();
        });
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
