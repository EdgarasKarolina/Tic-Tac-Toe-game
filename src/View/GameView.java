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


public class GameView {

   static Stage gameStage = new Stage();



    static int numberOfClicksCounter;
    static int whoHasWonCounter = 0;


    static ArrayList<Button> xListOfButtons = new ArrayList<>();
    static ArrayList<Button> oListOfButtons = new ArrayList<>();
    public static ArrayList<Button> allButtons = new ArrayList<>();

    public  Button btnSquare1;
    public  Button btnSquare2;
    public  Button btnSquare3;
    public  Button btnSquare4;
    public  Button btnSquare5;
    public  Button btnSquare6;
    public  Button btnSquare7;
    public  Button btnSquare8;
    public  Button btnSquare9;

    HBox firstLineHBox;
    HBox secondLineHBox;
    HBox thirdLineHBox;

    VBox gameStageVBox;

    Scene gameStageScene;

    BorderPane borderPane;

    PlayersDialogBoxView playersDialogBoxView;


    Image imgWhiteX = new Image(getClass().getResourceAsStream("Xsign.png"));
    Image imgWhite0 = new Image(getClass().getResourceAsStream("0sign.png"));
    Image imgBlackX = new Image(getClass().getResourceAsStream("XsignBlack.png"));
    Image imgBlack0 = new Image(getClass().getResourceAsStream("0signBlack.png"));

    public Scene getGameStage() {

        btnSquare1 = new Button();
        btnSquare2 = new Button();
        btnSquare3 = new Button();
        btnSquare4 = new Button();
        btnSquare5 = new Button();
        btnSquare6 = new Button();
        btnSquare7 = new Button();
        btnSquare8 = new Button();
        btnSquare9 = new Button();

        setAllSquaresToList();

        allButtons.forEach(squareButton->squareButton.getStyleClass().add("square-button"));

        gameStageVBox = new VBox();


        btnSquare1.setOnAction(event -> buttonsAction(btnSquare1));
        btnSquare2.setOnAction(event -> buttonsAction(btnSquare2));
        btnSquare3.setOnAction(event -> buttonsAction(btnSquare3));
        btnSquare4.setOnAction(event -> buttonsAction(btnSquare4));
        btnSquare5.setOnAction(event -> buttonsAction(btnSquare5));
        btnSquare6.setOnAction(event -> buttonsAction(btnSquare6));
        btnSquare7.setOnAction(event -> buttonsAction(btnSquare7));
        btnSquare8.setOnAction(event -> buttonsAction(btnSquare8));
        btnSquare9.setOnAction(event -> buttonsAction(btnSquare9));


        firstLineHBox = new HBox();
        firstLineHBox.getChildren().addAll(btnSquare1, btnSquare2, btnSquare3);
        secondLineHBox = new HBox();
        secondLineHBox.getChildren().addAll(btnSquare4, btnSquare5, btnSquare6);
        thirdLineHBox = new HBox();
        thirdLineHBox.getChildren().addAll(btnSquare7, btnSquare8, btnSquare9);
        gameStageVBox.getChildren().addAll(firstLineHBox, secondLineHBox, thirdLineHBox);


        borderPane = new BorderPane();
        PlayersDialogBoxView playersDialogBoxView = new PlayersDialogBoxView();
        borderPane.setLeft(gameStageVBox);
        borderPane.setRight(playersDialogBoxView.getPlayersDialogBoxVBox());

        gameStageScene = new Scene(borderPane, 580, 420);
        
        gameStageScene.getStylesheets().add("Resources/Styles/GameplayStyles.css");


        return gameStageScene;

    }
    //when button is clicked method inserts picture, disables button and adds it tosetXonButton ArrayList
    public void setXonButton(Button button) {
        button.setGraphic(new ImageView(imgWhiteX));
        button.setDisable(true);
        xListOfButtons.add(button);
    }
//when button is clicked method inserts picture, disables button and adds it to ArrayList
    public void setOonButton(Button button) {
        button.setGraphic(new ImageView(imgWhite0));
        button.setDisable(true);
        oListOfButtons.add(button);
    }

    public void ifXHasWon() {
        if (isItDraw1CheckX() == true) {
            btnSquare1.setGraphic(new ImageView(imgBlackX));
            btnSquare2.setGraphic(new ImageView(imgBlackX));
            btnSquare3.setGraphic(new ImageView(imgBlackX));
            disableAllButtons();
            whoHasWonCounter = 1;


        } else if (isItDraw2CheckX() == true) {
            btnSquare4.setGraphic(new ImageView(imgBlackX));
            btnSquare5.setGraphic(new ImageView(imgBlackX));
            btnSquare6.setGraphic(new ImageView(imgBlackX));
            disableAllButtons();
            whoHasWonCounter = 1;


        } else if (isItDraw3CheckX() == true) {
            btnSquare7.setGraphic(new ImageView(imgBlackX));
            btnSquare8.setGraphic(new ImageView(imgBlackX));
            btnSquare9.setGraphic(new ImageView(imgBlackX));
            disableAllButtons();
            whoHasWonCounter = 1;


        } else if (isItDraw4CheckX() == true) {
            btnSquare1.setGraphic(new ImageView(imgBlackX));
            btnSquare4.setGraphic(new ImageView(imgBlackX));
            btnSquare7.setGraphic(new ImageView(imgBlackX));
            disableAllButtons();
            whoHasWonCounter = 1;


        } else if (isItDraw5CheckX() == true) {
            btnSquare2.setGraphic(new ImageView(imgBlackX));
            btnSquare5.setGraphic(new ImageView(imgBlackX));
            btnSquare8.setGraphic(new ImageView(imgBlackX));
            disableAllButtons();
            whoHasWonCounter = 1;


        } else if (isItDraw6CheckX() == true) {
            btnSquare3.setGraphic(new ImageView(imgBlackX));
            btnSquare6.setGraphic(new ImageView(imgBlackX));
            btnSquare9.setGraphic(new ImageView(imgBlackX));
            disableAllButtons();
            whoHasWonCounter = 1;


        } else if (isItDraw7CheckX() == true) {
            btnSquare3.setGraphic(new ImageView(imgBlackX));
            btnSquare5.setGraphic(new ImageView(imgBlackX));
            btnSquare7.setGraphic(new ImageView(imgBlackX));
            disableAllButtons();
            whoHasWonCounter = 1;


        }
        else if (isItDraw8CheckX() == true) {
            btnSquare1.setGraphic(new ImageView(imgBlackX));
            btnSquare5.setGraphic(new ImageView(imgBlackX));
            btnSquare9.setGraphic(new ImageView(imgBlackX));
            disableAllButtons();
            whoHasWonCounter = 1;
        }


    }

    public void ifOHasWon() {

            if (isItDraw1CheckO() == true)
            {
                btnSquare1.setGraphic(new ImageView(imgBlack0));
                btnSquare2.setGraphic(new ImageView(imgBlack0));
                btnSquare3.setGraphic(new ImageView(imgBlack0));
                disableAllButtons();
                whoHasWonCounter = 2;
        }
            else if (isItDraw2CheckO() == true) {
                btnSquare4.setGraphic(new ImageView(imgBlack0));
                btnSquare5.setGraphic(new ImageView(imgBlack0));
                btnSquare6.setGraphic(new ImageView(imgBlack0));
                disableAllButtons();
                whoHasWonCounter = 2;


        } else if (isItDraw3CheckO() == true) {
                btnSquare7.setGraphic(new ImageView(imgBlack0));
                btnSquare8.setGraphic(new ImageView(imgBlack0));
                btnSquare9.setGraphic(new ImageView(imgBlack0));
                disableAllButtons();
                whoHasWonCounter = 2;


        } else if (isItDraw4CheckO() == true) {
                btnSquare1.setGraphic(new ImageView(imgBlack0));
                btnSquare4.setGraphic(new ImageView(imgBlack0));
                btnSquare7.setGraphic(new ImageView(imgBlack0));
                disableAllButtons();
                whoHasWonCounter = 2;


        } else if (isItDraw5CheckO() == true) {
                btnSquare2.setGraphic(new ImageView(imgBlack0));
                btnSquare5.setGraphic(new ImageView(imgBlack0));
                btnSquare8.setGraphic(new ImageView(imgBlack0));
                disableAllButtons();
                whoHasWonCounter = 2;


        } else if (isItDraw6CheckO() == true) {
                btnSquare3.setGraphic(new ImageView(imgBlack0));
                btnSquare6.setGraphic(new ImageView(imgBlack0));
                btnSquare9.setGraphic(new ImageView(imgBlack0));
                disableAllButtons();
                whoHasWonCounter = 2;


        } else if (isItDraw7CheckO() == true) {
                btnSquare3.setGraphic(new ImageView(imgBlack0));
                btnSquare5.setGraphic(new ImageView(imgBlack0));
                btnSquare7.setGraphic(new ImageView(imgBlack0));
                disableAllButtons();
                whoHasWonCounter = 2;


        }
        else if (isItDraw8CheckO() == true) {
                btnSquare1.setGraphic(new ImageView(imgBlack0));
                btnSquare5.setGraphic(new ImageView(imgBlack0));
                btnSquare9.setGraphic(new ImageView(imgBlack0));
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
        btnSquare1.setDisable(true);
        btnSquare2.setDisable(true);
        btnSquare3.setDisable(true);
        btnSquare4.setDisable(true);
        btnSquare5.setDisable(true);
        btnSquare6.setDisable(true);
        btnSquare7.setDisable(true);
        btnSquare8.setDisable(true);
        btnSquare9.setDisable(true);
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
      if  (oListOfButtons.contains(btnSquare1) & (oListOfButtons.contains(btnSquare2) & (oListOfButtons.contains(btnSquare3))))
      {
          return true;
      }

        else {
          return false;
      }
    }

    public boolean isItDraw2CheckO()
    {
        if  (oListOfButtons.contains(btnSquare4) & (oListOfButtons.contains(btnSquare5) & (oListOfButtons.contains(btnSquare6))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw3CheckO()
    {
        if  (oListOfButtons.contains(btnSquare7) & (oListOfButtons.contains(btnSquare8) & (oListOfButtons.contains(btnSquare9))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw4CheckO()
    {
        if  (oListOfButtons.contains(btnSquare1) & (oListOfButtons.contains(btnSquare4) & (oListOfButtons.contains(btnSquare7))))
        {
            return true;
        }

        else {
            return false;
        }
    }
    public boolean isItDraw5CheckO()
    {
        if  (oListOfButtons.contains(btnSquare2) & (oListOfButtons.contains(btnSquare5) & (oListOfButtons.contains(btnSquare8))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw6CheckO()
    {
        if  (oListOfButtons.contains(btnSquare3) & (oListOfButtons.contains(btnSquare6) & (oListOfButtons.contains(btnSquare9))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw7CheckO()
    {
        if  (oListOfButtons.contains(btnSquare3) & (oListOfButtons.contains(btnSquare5) & (oListOfButtons.contains(btnSquare7))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw8CheckO()
    {
        if  (oListOfButtons.contains(btnSquare1) & (oListOfButtons.contains(btnSquare5) & (oListOfButtons.contains(btnSquare9))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw1CheckX()
    {
        if  (xListOfButtons.contains(btnSquare1) & (xListOfButtons.contains(btnSquare2) & (xListOfButtons.contains(btnSquare3))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw2CheckX()
    {
        if  (xListOfButtons.contains(btnSquare4) & (xListOfButtons.contains(btnSquare5) & (xListOfButtons.contains(btnSquare6))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw3CheckX()
    {
        if  (xListOfButtons.contains(btnSquare7) & (xListOfButtons.contains(btnSquare8) & (xListOfButtons.contains(btnSquare9))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw4CheckX()
    {
        if  (xListOfButtons.contains(btnSquare1) & (xListOfButtons.contains(btnSquare4) & (xListOfButtons.contains(btnSquare7))))
        {
            return true;
        }


        else {
            return false;
        }
    }
    public boolean isItDraw5CheckX()
    {
        if  (xListOfButtons.contains(btnSquare2) & (xListOfButtons.contains(btnSquare5) & (xListOfButtons.contains(btnSquare8))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw6CheckX()
    {
        if  (xListOfButtons.contains(btnSquare3) & (xListOfButtons.contains(btnSquare6) & (xListOfButtons.contains(btnSquare9))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw7CheckX()
    {
        if  (xListOfButtons.contains(btnSquare3) & (xListOfButtons.contains(btnSquare5) & (xListOfButtons.contains(btnSquare7))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isItDraw8CheckX()
    {
        if  (xListOfButtons.contains(btnSquare1) & (xListOfButtons.contains(btnSquare5) & (xListOfButtons.contains(btnSquare9))))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public void setAllSquaresToList()
    {
        allButtons.add(btnSquare1);
        allButtons.add(btnSquare2);
        allButtons.add(btnSquare3);
        allButtons.add(btnSquare4);
        allButtons.add(btnSquare5);
        allButtons.add(btnSquare6);
        allButtons.add(btnSquare7);
        allButtons.add(btnSquare8);
        allButtons.add(btnSquare9);
    }

}
