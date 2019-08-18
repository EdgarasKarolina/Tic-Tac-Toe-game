package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class EnterNamesView {

    Scene scnCredentials;

    VBox vBox;
    HBox hBox;
    HBox hBox2;
    HBox hBox3;

    Label lblInsertNames = new Label("Insert players names");
    Label lblPlayer1Name = new Label("Player 1 name");
    Label lblPlayer2Name = new Label("Player 2 name");

    static TextField txtPlayer1Name = new TextField();
    static TextField txtPlayer2Name = new TextField();

    Button btnContinue = new Button("Continue");
    Button btnBack = new Button("Go back");

    String msgWarning = "Insert Name";

    GameView gameView = new GameView();
    PlayersDialogBoxView playersDialogBoxView;
    static StartMenu startMenu = new StartMenu();


    public Scene getScnCredentials()
    {
        vBox = new VBox();
        hBox = new HBox();
        hBox2 = new HBox();
        hBox3 = new HBox();

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

        vBox.getChildren().addAll(lblInsertNames, hBox, hBox2, hBox3);

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
