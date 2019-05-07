package View;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Edgaras on 15/07/2016.
 */
public class GameView {

   static Stage gameStage = new Stage(); //cia padaryt pakeitimai



    static int numberOfClicksCounter;
    static int whoHasWonCounter = 0;
    static ArrayList<Button> xListOfButtons = new ArrayList<>();
    static ArrayList<Button> oListOfButtons = new ArrayList<>();
    //if arraylist contains these buttons then you win

    //   Button button;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    HBox firstLineHBox;
    HBox secondLineHBox;
    HBox thirdLineHBox;

    VBox gameStageVBox;

    Scene gameStageScene;

    BorderPane borderPane;

    PlayersDialogBoxView playersDialogBoxView;

    Image xImage = new Image(getClass().getResourceAsStream("x.png"));
    Image oImage = new Image(getClass().getResourceAsStream("o.png"));
    Image xBlackImage = new Image(getClass().getResourceAsStream("x_black.png"));
    Image oBlackImage = new Image(getClass().getResourceAsStream("o_black.png"));

    public Scene getGameStage() {
        gameStageVBox = new VBox();


        button1 = new Button();
        button1.setStyle("-fx-font: 50 arial; -fx-base: #FFFFFF;");
        button1.setMinSize(133, 133);
        button1.setMaxSize(133, 133);
        button2 = new Button();
        button2.setStyle("-fx-font: 50 arial; -fx-base: #FFFFFF;");
        button2.setMinSize(133, 133);
        button2.setMaxSize(133, 133);
        button3 = new Button();
        button3.setStyle("-fx-font: 50 arial; -fx-base: #FFFFFF;");
        button3.setMinSize(133, 133);
        button3.setMaxSize(133, 133);
        button4 = new Button();
        button4.setStyle("-fx-font: 50 arial; -fx-base: #FFFFFF;");
        button4.setMinSize(133, 133);
        button4.setMaxSize(133, 133);
        button5 = new Button();
        button5.setStyle("-fx-font: 50 arial; -fx-base: #FFFFFF;");
        button5.setMinSize(133, 133);
        button5.setMaxSize(133, 133);
        button6 = new Button();
        button6.setStyle("-fx-font: 50 arial; -fx-base: #FFFFFF;");
        button6.setMinSize(133, 133);
        button6.setMaxSize(133, 133);
        button7 = new Button();
        button7.setStyle("-fx-font: 50 arial; -fx-base: #FFFFFF;");
        button7.setMinSize(133, 133);
        button7.setMaxSize(133, 133);
        button8 = new Button();
        button8.setStyle("-fx-font: 50 arial; -fx-base: #FFFFFF;");
        button8.setMinSize(133, 133);
        button8.setMaxSize(133, 133);
        button9 = new Button();
        button9.setStyle("-fx-font: 50 arial; -fx-base: #FFFFFF;");
        button9.setMinSize(133, 133);
        button9.setMaxSize(133, 133);


        button1.setOnAction(event -> buttonsAction(button1));
        button2.setOnAction(event -> buttonsAction(button2));
        button3.setOnAction(event -> buttonsAction(button3));
        button4.setOnAction(event -> buttonsAction(button4));
        button5.setOnAction(event -> buttonsAction(button5));
        button6.setOnAction(event -> buttonsAction(button6));
        button7.setOnAction(event -> buttonsAction(button7));
        button8.setOnAction(event -> buttonsAction(button8));
        button9.setOnAction(event -> buttonsAction(button9));


        firstLineHBox = new HBox();
        firstLineHBox.getChildren().addAll(button1, button2, button3);
        secondLineHBox = new HBox();
        secondLineHBox.getChildren().addAll(button4, button5, button6);
        thirdLineHBox = new HBox();
        thirdLineHBox.getChildren().addAll(button7, button8, button9);
        gameStageVBox.getChildren().addAll(firstLineHBox, secondLineHBox, thirdLineHBox);


        borderPane = new BorderPane();
        PlayersDialogBoxView playersDialogBoxView = new PlayersDialogBoxView();
        borderPane.setLeft(gameStageVBox);
        borderPane.setRight(playersDialogBoxView.getPlayersDialogBoxVBox());

        gameStageScene = new Scene(borderPane, 580, 420);


        return gameStageScene;

    }
    //when button is clicked method inserts picture, disables button and adds it to ArrayList
    public void setXonButton(Button button) {
        button.setGraphic(new ImageView(xImage));
        button.setDisable(true);
        xListOfButtons.add(button);
    }
//when button is clicked method inserts picture, disables button and adds it to ArrayList
    public void setOonButton(Button button) {
        button.setGraphic(new ImageView(oImage));
        button.setDisable(true);
        oListOfButtons.add(button);
    }

    public void ifXHasWon() {
        if (isItDraw1CheckX() == true) {
            button1.setGraphic(new ImageView(xBlackImage));
            button2.setGraphic(new ImageView(xBlackImage));
            button3.setGraphic(new ImageView(xBlackImage));
            disableAllButtons();
            whoHasWonCounter = 1;


        } else if (isItDraw2CheckX() == true) {
            button4.setGraphic(new ImageView(xBlackImage));
            button5.setGraphic(new ImageView(xBlackImage));
            button6.setGraphic(new ImageView(xBlackImage));
            disableAllButtons();
            whoHasWonCounter = 1;


        } else if (isItDraw3CheckX() == true) {
            button7.setGraphic(new ImageView(xBlackImage));
            button8.setGraphic(new ImageView(xBlackImage));
            button9.setGraphic(new ImageView(xBlackImage));
            disableAllButtons();
            whoHasWonCounter = 1;


        } else if (isItDraw4CheckX() == true) {
            button1.setGraphic(new ImageView(xBlackImage));
            button4.setGraphic(new ImageView(xBlackImage));
            button7.setGraphic(new ImageView(xBlackImage));
            disableAllButtons();
            whoHasWonCounter = 1;


        } else if (isItDraw5CheckX() == true) {
            button2.setGraphic(new ImageView(xBlackImage));
            button5.setGraphic(new ImageView(xBlackImage));
            button8.setGraphic(new ImageView(xBlackImage));
            disableAllButtons();
            whoHasWonCounter = 1;


        } else if (isItDraw6CheckX() == true) {
            button3.setGraphic(new ImageView(xBlackImage));
            button6.setGraphic(new ImageView(xBlackImage));
            button9.setGraphic(new ImageView(xBlackImage));
            disableAllButtons();
            whoHasWonCounter = 1;


        } else if (isItDraw7CheckX() == true) {
            button3.setGraphic(new ImageView(xBlackImage));
            button5.setGraphic(new ImageView(xBlackImage));
            button7.setGraphic(new ImageView(xBlackImage));
            disableAllButtons();
            whoHasWonCounter = 1;


        }
        else if (isItDraw8CheckX() == true) {
            button1.setGraphic(new ImageView(xBlackImage));
            button5.setGraphic(new ImageView(xBlackImage));
            button9.setGraphic(new ImageView(xBlackImage));
            disableAllButtons();
            whoHasWonCounter = 1;
        }


    }

    public void ifOHasWon() {

            if (isItDraw1CheckO() == true)
            {
                button1.setGraphic(new ImageView(oBlackImage));
                button2.setGraphic(new ImageView(oBlackImage));
                button3.setGraphic(new ImageView(oBlackImage));
                disableAllButtons();
                whoHasWonCounter = 2;
        }
            else if (isItDraw2CheckO() == true) {
                button4.setGraphic(new ImageView(oBlackImage));
                button5.setGraphic(new ImageView(oBlackImage));
                button6.setGraphic(new ImageView(oBlackImage));
                disableAllButtons();
                whoHasWonCounter = 2;


        } else if (isItDraw3CheckO() == true) {
                button7.setGraphic(new ImageView(oBlackImage));
                button8.setGraphic(new ImageView(oBlackImage));
                button9.setGraphic(new ImageView(oBlackImage));
                disableAllButtons();
                whoHasWonCounter = 2;


        } else if (isItDraw4CheckO() == true) {
                button1.setGraphic(new ImageView(oBlackImage));
                button4.setGraphic(new ImageView(oBlackImage));
                button7.setGraphic(new ImageView(oBlackImage));
                disableAllButtons();
                whoHasWonCounter = 2;


        } else if (isItDraw5CheckO() == true) {
                button2.setGraphic(new ImageView(oBlackImage));
                button5.setGraphic(new ImageView(oBlackImage));
                button8.setGraphic(new ImageView(oBlackImage));
                disableAllButtons();
                whoHasWonCounter = 2;


        } else if (isItDraw6CheckO() == true) {
                button3.setGraphic(new ImageView(oBlackImage));
                button6.setGraphic(new ImageView(oBlackImage));
                button9.setGraphic(new ImageView(oBlackImage));
                disableAllButtons();
                whoHasWonCounter = 2;


        } else if (isItDraw7CheckO() == true) {
                button3.setGraphic(new ImageView(oBlackImage));
                button5.setGraphic(new ImageView(oBlackImage));
                button7.setGraphic(new ImageView(oBlackImage));
                disableAllButtons();
                whoHasWonCounter = 2;


        }
        else if (isItDraw8CheckO() == true) {
                button1.setGraphic(new ImageView(oBlackImage));
                button5.setGraphic(new ImageView(oBlackImage));
                button9.setGraphic(new ImageView(oBlackImage));
                disableAllButtons();
                whoHasWonCounter = 2;
        }



    }

    public void buttonsAction(Button button) {
        numberOfClicksCounter++;
        if (numberOfClicksCounter % 2 == 0) {

            setXonButton(button);
            ifXHasWon();
            playersDialogBoxView = new PlayersDialogBoxView();
            playersDialogBoxView.setWhoseTurnToPlayLabel();


        } else {

            setOonButton(button);
            ifOHasWon();
            playersDialogBoxView = new PlayersDialogBoxView();
            playersDialogBoxView.setWhoseTurnToPlayLabel();

        }
    }

    //after player won all buttons are disabled
    public void disableAllButtons()
    {
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);
    }



    //set numberOfCLicksCounter to 1 or 2
    //is used to change the player who is starting the game
    public void setNumberOfClicksCounterToRandomNumber()
    {
        Random random = new Random();
        numberOfClicksCounter = random.nextInt(2);
    }

    public int getNumberOfClicksCounter()
    {
        return numberOfClicksCounter;
    }

   public int getWhoHasWonCounter()
   {
       return whoHasWonCounter;
   }


    //sets whoHasWonCounter to zero
    //is used when starting or restarting the game
    public void setWhoHasWonCounterToZero()
    {
        whoHasWonCounter = 0;
    }


    //keeps a track of how many buttons are in both lists
    public int returnSizeOfArrayLists()
    {
        int size = oListOfButtons.size() + xListOfButtons.size();

        return size;
    }

    //makes empty both array lists
    public void setArrayListsToBeEmpty()
    {
        xListOfButtons.clear();
        oListOfButtons.clear();
    }

    public void closeGameView()
    {
        gameStage.close();
    }

   //this is used to check if arraylists does not contain buttons and that the size of both of them combined is 9
    //this means that no one has won the game

    public boolean isItDraw1CheckO()
    {
      if  (oListOfButtons.contains(button1) & (oListOfButtons.contains(button2) & (oListOfButtons.contains(button3))))
      {
          return true;
      }

        else {
          return false;
      }
    }

    public boolean isItDraw2CheckO()
    {
        if  (oListOfButtons.contains(button4) & (oListOfButtons.contains(button5) & (oListOfButtons.contains(button6))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw3CheckO()
    {
        if  (oListOfButtons.contains(button7) & (oListOfButtons.contains(button8) & (oListOfButtons.contains(button9))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw4CheckO()
    {
        if  (oListOfButtons.contains(button1) & (oListOfButtons.contains(button4) & (oListOfButtons.contains(button7))))
        {
            return true;
        }

        else {
            return false;
        }
    }
    public boolean isItDraw5CheckO()
    {
        if  (oListOfButtons.contains(button2) & (oListOfButtons.contains(button5) & (oListOfButtons.contains(button8))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw6CheckO()
    {
        if  (oListOfButtons.contains(button3) & (oListOfButtons.contains(button6) & (oListOfButtons.contains(button9))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw7CheckO()
    {
        if  (oListOfButtons.contains(button3) & (oListOfButtons.contains(button5) & (oListOfButtons.contains(button7))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw8CheckO()
    {
        if  (oListOfButtons.contains(button1) & (oListOfButtons.contains(button5) & (oListOfButtons.contains(button9))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw1CheckX()
    {
        if  (xListOfButtons.contains(button1) & (xListOfButtons.contains(button2) & (xListOfButtons.contains(button3))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw2CheckX()
    {
        if  (xListOfButtons.contains(button4) & (xListOfButtons.contains(button5) & (xListOfButtons.contains(button6))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw3CheckX()
    {
        if  (xListOfButtons.contains(button7) & (xListOfButtons.contains(button8) & (xListOfButtons.contains(button9))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw4CheckX()
    {
        if  (xListOfButtons.contains(button1) & (xListOfButtons.contains(button4) & (xListOfButtons.contains(button7))))
        {
            return true;
        }
        

        else {
            return false;
        }
    }
    public boolean isItDraw5CheckX()
    {
        if  (xListOfButtons.contains(button2) & (xListOfButtons.contains(button5) & (xListOfButtons.contains(button8))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw6CheckX()
    {
        if  (xListOfButtons.contains(button3) & (xListOfButtons.contains(button6) & (xListOfButtons.contains(button9))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw7CheckX()
    {
        if  (xListOfButtons.contains(button3) & (xListOfButtons.contains(button5) & (xListOfButtons.contains(button7))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw8CheckX()
    {
        if  (xListOfButtons.contains(button1) & (xListOfButtons.contains(button5) & (xListOfButtons.contains(button9))))
        {
            return true;
        }

        else {
            return false;
        }
    }

}
