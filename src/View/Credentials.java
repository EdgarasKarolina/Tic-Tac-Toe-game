package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Credentials {

    private Button btnContinue = new Button("Continue");
    private Button btnBack = new Button("Go back");

    private Label lblInsertNames = new Label("Insert players names");
    private Label lblPlayer1Name = new Label("Player 1 name");
    private Label lblPlayer2Name = new Label("Player 2 name");

    private static TextField txtPlayer1Name = new TextField();
    private static TextField txtPlayer2Name = new TextField();

    private final String msgWarning = "Insert Name";

    private VBox vBox;
    private HBox hBox;
    private HBox hBox2;
    private HBox hBox3;

    private Scene scnCredentials;

    Gameplay gameplay = new Gameplay();
    Panel panel;
    static Start start = new Start();

    public Scene getScnCredentials() {
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

    private void setButtonsOnAction() {
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
                start.setSceneToMainStage();
                gameplay.setArrayListsToBeEmpty();
                gameplay.setWinnerCounter(0);
                gameplay.setNumberOfClicksCounterToRandomNumber();
                panel = new Panel();

                if (gameplay.getClicksCounter() % 2 == 0)
                    panel.p1Starts();

                else
                    panel.p2Starts();
        });

        btnBack.setOnAction(event -> start.setMainSceneToStage());
    }

    public String getPlayer1Name() {
        return  txtPlayer1Name.getText();
    }

    public String getPlayer2Name() {
        return  txtPlayer2Name.getText();
    }
}
