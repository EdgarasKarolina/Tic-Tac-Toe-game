package View;

import Controllers.CredentialsController;
import Controllers.MainMenuController;
import Model.TTTButton;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Panel {

    TTTButton btnReturn = new TTTButton("Return to menu");
    TTTButton btnRestart = new TTTButton("Restart");
    TTTButton btnQuit = new TTTButton("Quit the game");

    Label lblPlayer1Name = new Label();
    Label lblPlayer2Name = new Label();
    public static Label lblPlayersTurn = new Label();

    VBox vBoxDialogBox = new VBox();
    HBox hBox1 = new HBox();
    HBox hBox2 = new HBox();

    CredentialsController credentialsController = new CredentialsController();

    public VBox getPanel()
    {
        vBoxDialogBox.getStylesheets().add("Resources/Styles/PanelStyles.css");

        btnRestart.getStyleClass().add("panel-button");
        btnReturn.getStyleClass().add("panel-button");
        btnQuit.getStyleClass().add("panel-button");

        lblPlayersTurn.getStyleClass().add("turn-label");
        lblPlayer1Name.getStyleClass().add("name-label");
        lblPlayer2Name.getStyleClass().add("name-label");

        vBoxDialogBox.getStyleClass().add("panel-vbox");

        lblPlayer1Name.setText("Player1: " + credentialsController.getPlayer1Name());
        lblPlayer2Name.setText("Player2: " + credentialsController.getPlayer2Name());

        hBox1.getChildren().addAll(lblPlayer1Name);
        hBox2.getChildren().addAll(lblPlayer2Name);

        vBoxDialogBox.getChildren().addAll( lblPlayersTurn, hBox1, hBox2, btnRestart, btnReturn, btnQuit);

        this.setButtonsOnAction();

        return vBoxDialogBox;
    }

    public void setButtonsOnAction()
    {
        btnRestart.setOnAction(event -> {

        });

        btnReturn.setOnAction(event -> {
            MainMenuController.mainMenuController.setMainMenuToStage();
        });

        btnQuit.setOnAction(event -> {
            System.exit(1);
        });
    }
}
