package View;


import Controllers.GameViewController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import java.util.ArrayList;
import java.util.Random;


public class GameView {

    BorderPane borderPane;
    Scene scnGameplay;

    VBox vBoxGameplay;
    HBox hBoxFirstLine;
    HBox hBoxSecondLine;
    HBox hBoxThirdLine;

    public Button btnSquare1;
    public Button btnSquare2;
    public Button btnSquare3;
    public Button btnSquare4;
    public Button btnSquare5;
    public Button btnSquare6;
    public Button btnSquare7;
    public Button btnSquare8;
    public Button btnSquare9;

    public static ArrayList<Button> xListOfButtons = new ArrayList<>();
    public static ArrayList<Button> oListOfButtons = new ArrayList<>();
    public static ArrayList<Button> allButtons = new ArrayList<>();

    Image imgWhiteX = new Image(getClass().getResourceAsStream("/Resources/Images/Xsign.png"));
    Image imgWhite0 = new Image(getClass().getResourceAsStream("/Resources/Images/0sign.png"));
    Image imgBlackX = new Image(getClass().getResourceAsStream("/Resources/Images/XsignBlack.png"));
    Image imgBlack0 = new Image(getClass().getResourceAsStream("/Resources/Images/0signBlack.png"));

    static int numberOfClicksCounter;
    static int whoHasWonCounter = 0;

    PlayersDialogBoxView playersDialogBoxView;

    public Scene getGameplay() {

        btnSquare1 = new Button();
        btnSquare2 = new Button();
        btnSquare3 = new Button();
        btnSquare4 = new Button();
        btnSquare5 = new Button();
        btnSquare6 = new Button();
        btnSquare7 = new Button();
        btnSquare8 = new Button();
        btnSquare9 = new Button();

        setAllButtonsToList();
        allButtons.forEach(squareButton->squareButton.getStyleClass().add("square-button"));

        vBoxGameplay = new VBox();

        hBoxFirstLine = new HBox();
        hBoxFirstLine.getChildren().addAll(btnSquare1, btnSquare2, btnSquare3);
        hBoxSecondLine = new HBox();
        hBoxSecondLine.getChildren().addAll(btnSquare4, btnSquare5, btnSquare6);
        hBoxThirdLine = new HBox();
        hBoxThirdLine.getChildren().addAll(btnSquare7, btnSquare8, btnSquare9);
        vBoxGameplay.getChildren().addAll(hBoxFirstLine, hBoxSecondLine, hBoxThirdLine);

        borderPane = new BorderPane();

        PlayersDialogBoxView playersDialogBoxView = new PlayersDialogBoxView();
        borderPane.setLeft(vBoxGameplay);
        borderPane.setRight(playersDialogBoxView.getPanel());

        scnGameplay = new Scene(borderPane, 580, 420);
        scnGameplay.getStylesheets().add("Resources/Styles/GameplayStyles.css");

        this.setAllSquareButtonsOnAction();

        return scnGameplay;
    }

    public void ifXHasWon()
    {
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

    public void ifOHasWon()
    {
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

    public void buttonsAction(Button button)
    {
        numberOfClicksCounter++;
        if (numberOfClicksCounter % 2 == 0)
        {
            GameViewController.setXonButton(button, imgWhiteX, xListOfButtons);
            ifXHasWon();
            playersDialogBoxView = new PlayersDialogBoxView();
            playersDialogBoxView.setWhoseTurnToPlayLabel();
        }
        else
        {
            GameViewController.setOonButton(button, imgWhite0, oListOfButtons);
            ifOHasWon();
            playersDialogBoxView = new PlayersDialogBoxView();
            playersDialogBoxView.setWhoseTurnToPlayLabel();
        }
    }

    public void setAllSquareButtonsOnAction()
    {
        btnSquare1.setOnAction(event -> buttonsAction(btnSquare1));
        btnSquare2.setOnAction(event -> buttonsAction(btnSquare2));
        btnSquare3.setOnAction(event -> buttonsAction(btnSquare3));
        btnSquare4.setOnAction(event -> buttonsAction(btnSquare4));
        btnSquare5.setOnAction(event -> buttonsAction(btnSquare5));
        btnSquare6.setOnAction(event -> buttonsAction(btnSquare6));
        btnSquare7.setOnAction(event -> buttonsAction(btnSquare7));
        btnSquare8.setOnAction(event -> buttonsAction(btnSquare8));
        btnSquare9.setOnAction(event -> buttonsAction(btnSquare9));
    }


    //set numberOfCLicksCounter to 1 or 2
    //is used to change the player who is starting the game
    public void setNumberOfClicksCounterToRandomNumber()
    {
        Random random = new Random();
        numberOfClicksCounter = random.nextInt(2);
    }

    public int getNumberOfClicksCounter() {
        return numberOfClicksCounter;
    }

    public int getWhoHasWonCounter() {
        return whoHasWonCounter;
    }


    //sets whoHasWonCounter to zero
    //is used when starting or restarting the game
    public void setWhoHasWonCounterToZero()
    {
        whoHasWonCounter = 0;
    }

    public int returnSizeOfArrayLists()
    {
        return oListOfButtons.size() + xListOfButtons.size();
    }

    public void setArrayListsToBeEmpty()
    {
        xListOfButtons.clear();
        oListOfButtons.clear();
    }

    public boolean isItDraw1CheckO()
    {
        if (oListOfButtons.contains(btnSquare1) & (oListOfButtons.contains(btnSquare2) & (oListOfButtons.contains(btnSquare3))))
            return true;
        else
            return false;
    }


    public boolean isItDraw2CheckO()
    {
        if (oListOfButtons.contains(btnSquare4) & (oListOfButtons.contains(btnSquare5) & (oListOfButtons.contains(btnSquare6))))
            return true;
        else
            return false;
    }

    public boolean isItDraw3CheckO()
    {
        if (oListOfButtons.contains(btnSquare7) & (oListOfButtons.contains(btnSquare8) & (oListOfButtons.contains(btnSquare9))))
            return true;
        else
            return false;
    }

    public boolean isItDraw4CheckO()
    {
        if (oListOfButtons.contains(btnSquare1) & (oListOfButtons.contains(btnSquare4) & (oListOfButtons.contains(btnSquare7))))
            return true;
        else
            return false;
    }

    public boolean isItDraw5CheckO()
    {
        if (oListOfButtons.contains(btnSquare2) & (oListOfButtons.contains(btnSquare5) & (oListOfButtons.contains(btnSquare8))))
            return true;
        else
            return false;
    }

    public boolean isItDraw6CheckO()
    {
        if (oListOfButtons.contains(btnSquare3) & (oListOfButtons.contains(btnSquare6) & (oListOfButtons.contains(btnSquare9))))
            return true;
        else
            return false;
    }

    public boolean isItDraw7CheckO()
    {
        if (oListOfButtons.contains(btnSquare3) & (oListOfButtons.contains(btnSquare5) & (oListOfButtons.contains(btnSquare7))))
            return true;
        else
            return false;
    }

    public boolean isItDraw8CheckO()
    {
        if (oListOfButtons.contains(btnSquare1) & (oListOfButtons.contains(btnSquare5) & (oListOfButtons.contains(btnSquare9))))
            return true;
        else
            return false;
    }

    public boolean isItDraw1CheckX()
    {
        if (xListOfButtons.contains(btnSquare1) & (xListOfButtons.contains(btnSquare2) & (xListOfButtons.contains(btnSquare3))))
            return true;
        else
            return false;
    }

    public boolean isItDraw2CheckX()
    {
        if (xListOfButtons.contains(btnSquare4) & (xListOfButtons.contains(btnSquare5) & (xListOfButtons.contains(btnSquare6))))
            return true;
        else
            return false;
    }

    public boolean isItDraw3CheckX()
    {
        if (xListOfButtons.contains(btnSquare7) & (xListOfButtons.contains(btnSquare8) & (xListOfButtons.contains(btnSquare9))))
            return true;
        else
            return false;
    }

    public boolean isItDraw4CheckX()
    {
        if (xListOfButtons.contains(btnSquare1) & (xListOfButtons.contains(btnSquare4) & (xListOfButtons.contains(btnSquare7))))
            return true;
        else
            return false;
    }

    public boolean isItDraw5CheckX()
    {
        if (xListOfButtons.contains(btnSquare2) & (xListOfButtons.contains(btnSquare5) & (xListOfButtons.contains(btnSquare8))))
            return true;
        else
            return false;
    }

    public boolean isItDraw6CheckX()
    {
        if (xListOfButtons.contains(btnSquare3) & (xListOfButtons.contains(btnSquare6) & (xListOfButtons.contains(btnSquare9))))
            return true;
        else
            return false;
    }

    public boolean isItDraw7CheckX()
    {
        if (xListOfButtons.contains(btnSquare3) & (xListOfButtons.contains(btnSquare5) & (xListOfButtons.contains(btnSquare7))))
            return true;
        else
            return false;
    }

    public boolean isItDraw8CheckX()
    {
        if (xListOfButtons.contains(btnSquare1) & (xListOfButtons.contains(btnSquare5) & (xListOfButtons.contains(btnSquare9))))
            return true;
        else
            return false;
    }

    public void setAllButtonsToList()
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

    public void disableAllButtons()
    {
        for (Button button : allButtons)
            button.setDisable(true);
    }
}
