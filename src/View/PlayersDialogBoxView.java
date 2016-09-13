package View;

import Controllers.GameViewController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Controllers.EnterNamesController;
import javafx.scene.text.Font;



/**
 * Created by Edgaras on 18/07/2016.
 */
public class PlayersDialogBoxView {

    Button returnToMenuButton;
    Button restartButton;
    Button quitGameButton;
    static Label whoseTurnToPlayLabel;

    Label playerNr1NameLabel;
    Label playerNr2NameLabel;
    Label xLabel;
    Label oLabel;


    VBox playersDialogBoxVBox;
    HBox hBox1;
    HBox hBox2;

    EnterNamesController enterNamesController = new EnterNamesController();
    GameView gameView = new GameView();
    EnterNamesView enterNamesView ;

    static StartMenu startMenu = new StartMenu();


    public VBox getPlayersDialogBoxVBox()
    {


        enterNamesView = new EnterNamesView();


        playersDialogBoxVBox = new VBox();
        whoseTurnToPlayLabel = new Label();
        whoseTurnToPlayLabel.setMinSize(170, 60);
        whoseTurnToPlayLabel.setMaxSize(170, 60);
        whoseTurnToPlayLabel.setStyle("-fx-border-color: darkturquoise");
        whoseTurnToPlayLabel.setStyle("-fx-border-style: solid");
        whoseTurnToPlayLabel.setStyle("-fx-background-color: lightblue");
        whoseTurnToPlayLabel.setFont(Font.font ("Serif Bold", 20));
        whoseTurnToPlayLabel.setAlignment(Pos.CENTER);


        restartButton = new Button("Restart");
        restartButton.setStyle("-fx-background-color: lightyellow");
        restartButton.setMinSize(160, 50);
        restartButton.setMaxSize(160, 50);
        restartButton.setFont(Font.font ("Serif", 20));
        restartButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15, 0.0 , 2 , 0)");
        //restart button sets the game view scene again
        //emptyis array lists
        //decides wo will start to play firs
        restartButton.setOnAction(event -> {

            startMenu.setSceneToMainStage();

            gameView.setArrayListsToBeEmpty();
            gameView.setWhoHasWonCounterToZero();
            gameView.setNumberOfClicksCounterToRandomNumber();

            if (gameView.getNumberOfClicksCounter() % 2 == 0) {
                whoseTurnToPlayLabel.setText(enterNamesController.getNamePlayer1() + " turn");
                whoseTurnToPlayLabel.setAlignment(Pos.CENTER);
                p1Starts();
            } else {
                whoseTurnToPlayLabel.setText(enterNamesController.getNamePlayer2() + " turn");
                whoseTurnToPlayLabel.setAlignment(Pos.CENTER);
                p2Starts();
            }
        });

        returnToMenuButton = new Button("Return to menu");
        returnToMenuButton.setStyle("-fx-background-color: lightyellow");
        returnToMenuButton.setMinSize(160, 50);
        returnToMenuButton.setMaxSize(160, 50);
        returnToMenuButton.setFont(Font.font ("Serif", 20));
        returnToMenuButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15, 0.0 , 2 , 0)");
        returnToMenuButton.setOnAction(event -> {
            startMenu.setMainSceneToStage();
        });

        quitGameButton = new Button("Quit the game");
        quitGameButton.setStyle("-fx-background-color: lightyellow");
        quitGameButton.setMinSize(160, 50);
        quitGameButton.setMaxSize(160, 50);
        quitGameButton.setFont(Font.font ("Serif", 20));
        quitGameButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15, 0.0 , 2 , 0)");
        quitGameButton.setOnAction(event -> System.exit(1));

        playerNr1NameLabel = new Label();
        playerNr1NameLabel.setText("Player1: " + enterNamesController.getNamePlayer1());
        playerNr1NameLabel.setMinSize(170, 60);
        playerNr1NameLabel.setMaxSize(170, 60);
        playerNr1NameLabel.setStyle("-fx-border-color: darkturquoise");
        playerNr1NameLabel.setFont(Font.font ("Serif Bold", 20));
        playerNr1NameLabel.setAlignment(Pos.CENTER);
        playerNr1NameLabel.setStyle("-fx-background-color: lightblue");
        playerNr2NameLabel = new Label();
        playerNr2NameLabel.setText("Player2: " + enterNamesController.getNamePlayer2());
        playerNr2NameLabel.setMinSize(170, 60);
        playerNr2NameLabel.setMaxSize(170, 60);
        playerNr2NameLabel.setStyle("-fx-border-color: darkturquoise");
        playerNr2NameLabel.setFont(Font.font ("Serif Bold", 20));
        playerNr2NameLabel.setAlignment(Pos.CENTER);
        playerNr2NameLabel.setStyle("-fx-background-color: lightblue");


        xLabel = new Label();
        oLabel = new Label();

        hBox1 = new HBox();
        hBox1.getChildren().addAll(playerNr1NameLabel, xLabel);
        hBox2 = new HBox();
        hBox2.getChildren().addAll(playerNr2NameLabel, oLabel);
        playersDialogBoxVBox.getChildren().addAll( whoseTurnToPlayLabel, hBox1, hBox2, restartButton, returnToMenuButton, quitGameButton);
        playersDialogBoxVBox.setSpacing(15);


        return playersDialogBoxVBox;
    }

   public void setWhoseTurnToPlayLabel() {

        if (gameView.getWhoHasWonCounter() == 1) {
            whoseTurnToPlayLabel.setText( enterNamesController.getNamePlayer2() + " has won");


        } else if (gameView.getWhoHasWonCounter() == 2){
                whoseTurnToPlayLabel.setText( enterNamesController.getNamePlayer1() + " has won");
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

            whoseTurnToPlayLabel.setText("Draw");
        }

        //checks if counter is even then is player nr 1 turn
        //if counter is odd then it is player nr 2 turn
        else  {
                if (( gameView.getNumberOfClicksCounter()) % 2 == 0 ) {

                    whoseTurnToPlayLabel.setText(enterNamesController.getNamePlayer1() + " turn");
                    whoseTurnToPlayLabel.setAlignment(Pos.CENTER);

                } else if (( gameView.getNumberOfClicksCounter()) % 2 != 0){

                    whoseTurnToPlayLabel.setText(enterNamesController.getNamePlayer2() + " turn");
                    whoseTurnToPlayLabel.setAlignment(Pos.CENTER);

                }

            }
        }


    //methods used to set who's turn to play at the start of the game
    //later on getLabel method is deciding that
    public void p1Starts()
{
    whoseTurnToPlayLabel.setText(enterNamesController.getNamePlayer1() + " turn");
}

    public void p2Starts()
    {
        whoseTurnToPlayLabel.setText(enterNamesController.getNamePlayer2() + " turn");
    }

}






