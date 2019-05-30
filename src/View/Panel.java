package View;

import Controllers.CredentialsController;
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
    Label lblX = new Label();
    Label lblO = new Label();
    Label lblPlayersTurn = new Label();

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

        lblPlayer1Name.getStyleClass().add("name-label");
        lblPlayer2Name.getStyleClass().add("name-label");
        lblX.getStyleClass().add("name-label");
        lblO.getStyleClass().add("name-label");

        vBoxDialogBox.getStyleClass().add("panel-vbox");

        lblPlayer1Name.setText("Player1: " + credentialsController.getPlayer1Name());
        lblPlayer2Name.setText("Player2: " + credentialsController.getPlayer2Name());

        hBox1.getChildren().addAll(lblPlayer1Name, lblX);
        hBox2.getChildren().addAll(lblPlayer2Name, lblO);

        vBoxDialogBox.getChildren().addAll( lblPlayersTurn, hBox1, hBox2, btnRestart, btnReturn, btnQuit);

        return vBoxDialogBox;
    }
}
