package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Controllers.CredentialsController;


public class Panel {
    private Button btnReturn = new Button("Return to menu");
    private Button btnRestart = new Button("Restart");
    private Button btnQuit = new Button("Quit the game");

    private Label lblPlayer1Name = new Label();
    private Label lblPlayer2Name = new Label();
    private static Label lblPlayersTurn = new Label();

    private VBox vBoxDialogBox = new VBox();
    private HBox hBox1 = new HBox();
    private HBox hBox2 = new HBox();

    CredentialsController credentialsController = new CredentialsController();
    Gameplay gameplay = new Gameplay();

    static Start start = new Start();

    public VBox getPanel() {
        vBoxDialogBox.getStylesheets().add("Resources/Styles/PanelStyles.css");
        vBoxDialogBox.getStyleClass().add("panel-vbox");

        btnRestart.getStyleClass().add("panel-button");
        btnReturn.getStyleClass().add("panel-button");
        btnQuit.getStyleClass().add("panel-button");

        lblPlayersTurn.getStyleClass().add("turn-label");
        lblPlayer1Name.getStyleClass().add("name-label");
        lblPlayer2Name.getStyleClass().add("name-label");

        lblPlayer1Name.setText("Player1: " + credentialsController.getNamePlayer1());
        lblPlayer2Name.setText("Player2: " + credentialsController.getNamePlayer2());

        hBox1 = new HBox();
        hBox1.getChildren().addAll(lblPlayer1Name);
        hBox2 = new HBox();
        hBox2.getChildren().addAll(lblPlayer2Name);
        vBoxDialogBox.getChildren().addAll(lblPlayersTurn, hBox1, hBox2, btnRestart, btnReturn, btnQuit);
        vBoxDialogBox.setSpacing(15);

        this.setButtonsOnAction();

        return vBoxDialogBox;
    }

    private void setButtonsOnAction() {
        btnRestart.setOnAction(event -> {
            start.setSceneToMainStage();

            gameplay.setArrayListsToBeEmpty();
            gameplay.setWinnerCounter(0);
            gameplay.setNumberOfClicksCounterToRandomNumber();

            if (gameplay.getClicksCounter() % 2 == 0) {
                lblPlayersTurn.setText(credentialsController.getNamePlayer1() + " turn");
                player1Turn();
            } else {
                lblPlayersTurn.setText(credentialsController.getNamePlayer2() + " turn");
                player2Turn();
            }
        });

        btnReturn.setOnAction(event -> {
            start.setMainSceneToStage();
        });

        btnQuit.setOnAction(event -> {
            System.exit(1);
        });
    }

   public void setWhoseTurnToPlayLabel() {
        if (gameplay.getWinnerCounter() == 1) {
            lblPlayersTurn.setText( credentialsController.getNamePlayer2() + " has won");
        } else if (gameplay.getWinnerCounter() == 2) {
                lblPlayersTurn.setText( credentialsController.getNamePlayer1() + " has won");
        } else if (gameplay.returnSizeOfArrayLists() >= 9 && !gameplay.getIsWinner()) {
            lblPlayersTurn.setText("Draw");
        } else {
                if ((gameplay.getClicksCounter()) % 2 == 0) {
                    lblPlayersTurn.setText(credentialsController.getNamePlayer1() + " turn");
                    lblPlayersTurn.setAlignment(Pos.CENTER);
                } else if ((gameplay.getClicksCounter()) % 2 != 0) {
                    lblPlayersTurn.setText(credentialsController.getNamePlayer2() + " turn");
                    lblPlayersTurn.setAlignment(Pos.CENTER);
                }
            }
        }

    public void player1Turn() {
    lblPlayersTurn.setText(credentialsController.getNamePlayer1() + " turn");
    }

    public void player2Turn() {
        lblPlayersTurn.setText(credentialsController.getNamePlayer2() + " turn");
    }
}






