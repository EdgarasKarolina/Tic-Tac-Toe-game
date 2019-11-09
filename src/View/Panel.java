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


    public VBox getPanel()
    {
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

    private void setButtonsOnAction()
    {
        btnRestart.setOnAction(event -> {

            start.setSceneToMainStage();

            gameplay.setArrayListsToBeEmpty();
            gameplay.setWinnerCounter(0);
            gameplay.setNumberOfClicksCounterToRandomNumber();

            if (gameplay.getClicksCounter() % 2 == 0) {
                lblPlayersTurn.setText(credentialsController.getNamePlayer1() + " turn");
                p1Starts();
            } else {
                lblPlayersTurn.setText(credentialsController.getNamePlayer2() + " turn");
                p2Starts();
            }
        });

        btnReturn.setOnAction(event -> {
            start.setMainSceneToStage();
        });

        btnQuit.setOnAction(event -> {
            System.exit(1);
        });
    }

   public void setWhoseTurnToPlayLabel()
   {

        if (gameplay.getWhoHasWonCounter() == 1) {
            lblPlayersTurn.setText( credentialsController.getNamePlayer2() + " has won");


        } else if (gameplay.getWhoHasWonCounter() == 2){
                lblPlayersTurn.setText( credentialsController.getNamePlayer1() + " has won");
            }

        else if (gameplay.returnSizeOfArrayLists() >= 9 && gameplay.isItDraw1CheckX() == false
                && gameplay.isItDraw2CheckX() == false && gameplay.isItDraw3CheckX() == false
                && gameplay.isItDraw4CheckX() == false && gameplay.isItDraw5CheckX() == false
                && gameplay.isItDraw6CheckX() == false && gameplay.isItDraw7CheckX() == false
                && gameplay.isItDraw8CheckX() == false && gameplay.isItDraw1CheckO() == false
                && gameplay.isItDraw2CheckO() == false && gameplay.isItDraw3CheckO() == false
                && gameplay.isItDraw4CheckO() == false && gameplay.isItDraw5CheckO() == false
                && gameplay.isItDraw6CheckO() == false && gameplay.isItDraw7CheckO() == false
                && gameplay.isItDraw8CheckO() == false )
        {

            lblPlayersTurn.setText("Draw");
        }

        //checks if counter is even then is player nr 1 turn
        //if counter is odd then it is player nr 2 turn
        else  {
                if (( gameplay.getClicksCounter()) % 2 == 0 ) {

                    lblPlayersTurn.setText(credentialsController.getNamePlayer1() + " turn");
                    lblPlayersTurn.setAlignment(Pos.CENTER);

                } else if (( gameplay.getClicksCounter()) % 2 != 0){

                    lblPlayersTurn.setText(credentialsController.getNamePlayer2() + " turn");
                    lblPlayersTurn.setAlignment(Pos.CENTER);
                }
            }
        }

    public void p1Starts()
{
    lblPlayersTurn.setText(credentialsController.getNamePlayer1() + " turn");
}

    public void p2Starts()
    {
        lblPlayersTurn.setText(credentialsController.getNamePlayer2() + " turn");
    }
}






