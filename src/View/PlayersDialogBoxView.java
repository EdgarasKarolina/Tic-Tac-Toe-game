package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Controllers.EnterNamesController;


public class PlayersDialogBoxView {

    private Button btnReturn = new Button("Return to menu");
    private Button btnRestart = new Button("Restart");
    private Button btnQuit = new Button("Quit the game");

    private Label lblPlayer1Name = new Label();
    private Label lblPlayer2Name = new Label();
    private static Label lblPlayersTurn = new Label();

    private VBox vBoxDialogBox = new VBox();
    private HBox hBox1 = new HBox();
    private HBox hBox2 = new HBox();

    EnterNamesController enterNamesController = new EnterNamesController();
    GameView gameView = new GameView();

    static StartMenu startMenu = new StartMenu();


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

        lblPlayer1Name.setText("Player1: " + enterNamesController.getNamePlayer1());
        lblPlayer2Name.setText("Player2: " + enterNamesController.getNamePlayer2());

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

            startMenu.setSceneToMainStage();

            gameView.setArrayListsToBeEmpty();
            gameView.setWinnerCounter(0);
            gameView.setNumberOfClicksCounterToRandomNumber();

            if (gameView.getClicksCounter() % 2 == 0) {
                lblPlayersTurn.setText(enterNamesController.getNamePlayer1() + " turn");
                p1Starts();
            } else {
                lblPlayersTurn.setText(enterNamesController.getNamePlayer2() + " turn");
                p2Starts();
            }
        });

        btnReturn.setOnAction(event -> {
            startMenu.setMainSceneToStage();
        });

        btnQuit.setOnAction(event -> {
            System.exit(1);
        });
    }

   public void setWhoseTurnToPlayLabel()
   {

        if (gameView.getWhoHasWonCounter() == 1) {
            lblPlayersTurn.setText( enterNamesController.getNamePlayer2() + " has won");


        } else if (gameView.getWhoHasWonCounter() == 2){
                lblPlayersTurn.setText( enterNamesController.getNamePlayer1() + " has won");
            }

        else if (gameView.returnSizeOfArrayLists() >= 9 && gameView.isItDraw1CheckX() == false
                && gameView.isItDraw2CheckX() == false && gameView.isItDraw3CheckX() == false
                && gameView.isItDraw4CheckX() == false && gameView.isItDraw5CheckX() == false
                && gameView.isItDraw6CheckX() == false && gameView.isItDraw7CheckX() == false
                && gameView.isItDraw8CheckX() == false && gameView.isItDraw1CheckO() == false
                && gameView.isItDraw2CheckO() == false && gameView.isItDraw3CheckO() == false
                && gameView.isItDraw4CheckO() == false && gameView.isItDraw5CheckO() == false
                && gameView.isItDraw6CheckO() == false && gameView.isItDraw7CheckO() == false
                && gameView.isItDraw8CheckO() == false )
        {

            lblPlayersTurn.setText("Draw");
        }

        //checks if counter is even then is player nr 1 turn
        //if counter is odd then it is player nr 2 turn
        else  {
                if (( gameView.getClicksCounter()) % 2 == 0 ) {

                    lblPlayersTurn.setText(enterNamesController.getNamePlayer1() + " turn");
                    lblPlayersTurn.setAlignment(Pos.CENTER);

                } else if (( gameView.getClicksCounter()) % 2 != 0){

                    lblPlayersTurn.setText(enterNamesController.getNamePlayer2() + " turn");
                    lblPlayersTurn.setAlignment(Pos.CENTER);
                }
            }
        }

    public void p1Starts()
{
    lblPlayersTurn.setText(enterNamesController.getNamePlayer1() + " turn");
}

    public void p2Starts()
    {
        lblPlayersTurn.setText(enterNamesController.getNamePlayer2() + " turn");
    }
}






