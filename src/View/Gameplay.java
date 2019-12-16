package View;


import Controllers.GameplayController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Gameplay {

    private Button btnSquare1;
    private Button btnSquare2;
    private Button btnSquare3;
    private Button btnSquare4;
    private Button btnSquare5;
    private Button btnSquare6;
    private Button btnSquare7;
    private Button btnSquare8;
    private Button btnSquare9;

    private static ArrayList<Button> xListOfButtons = new ArrayList<>();
    private static ArrayList<Button> oListOfButtons = new ArrayList<>();
    private static ArrayList<Button> allButtons = new ArrayList<>();

    private Image imgWhiteX = new Image(getClass().getResourceAsStream("/Resources/Images/Xsign.png"));
    private Image imgWhite0 = new Image(getClass().getResourceAsStream("/Resources/Images/0sign.png"));
    private Image imgBlackX = new Image(getClass().getResourceAsStream("/Resources/Images/XsignBlack.png"));
    private Image imgBlack0 = new Image(getClass().getResourceAsStream("/Resources/Images/0signBlack.png"));

    private VBox vBoxGameplay;
    private HBox hBoxFirstLine;
    private HBox hBoxSecondLine;
    private HBox hBoxThirdLine;

    private BorderPane borderPane;
    private Scene scnGameplay;
    Panel panel;

    private static int clicksCounter;
    private static int winnerCounter;
    Random random = new Random();

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

        Panel panel = new Panel();
        borderPane.setLeft(vBoxGameplay);
        borderPane.setRight(panel.getPanel());

        scnGameplay = new Scene(borderPane, 580, 420);
        scnGameplay.getStylesheets().add("Resources/Styles/GameplayStyles.css");

        this.setAllSquareButtonsOnAction();

        return scnGameplay;
    }

    public int getClicksCounter() {
        return clicksCounter;
    }

    public int getWhoHasWonCounter() {
        return winnerCounter;
    }

    public void setWinnerCounter(int count) {
        winnerCounter = count;
    }

    private void ifXHasWon() {
        if (isItDraw1CheckX()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare1, btnSquare2, btnSquare3), imgBlackX);
            disableAllButtons();
            setWinnerCounter(1);
        } else if (isItDraw2CheckX()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare4, btnSquare5, btnSquare6), imgBlackX);
            disableAllButtons();
            setWinnerCounter(1);
        } else if (isItDraw3CheckX()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare7, btnSquare8, btnSquare9), imgBlackX);
            disableAllButtons();
            setWinnerCounter(1);
        } else if (isItDraw4CheckX()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare1, btnSquare4, btnSquare7), imgBlackX);
            disableAllButtons();
            setWinnerCounter(1);
        } else if (isItDraw5CheckX()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare2, btnSquare5, btnSquare8), imgBlackX);
            disableAllButtons();
            setWinnerCounter(1);
        } else if (isItDraw6CheckX()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare3, btnSquare6, btnSquare9), imgBlackX);
            disableAllButtons();
            setWinnerCounter(1);
        } else if (isItDraw7CheckX()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare3, btnSquare5, btnSquare7), imgBlackX);
            disableAllButtons();
            setWinnerCounter(1);
        } else if (isItDraw8CheckX()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare1, btnSquare5, btnSquare9), imgBlackX);
            disableAllButtons();
            setWinnerCounter(1);
        }
    }

    private void ifOHasWon() {
        if (isItDraw1CheckO()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare1, btnSquare2, btnSquare3), imgBlack0);
            disableAllButtons();
            setWinnerCounter(2);
        } else if (isItDraw2CheckO()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare4, btnSquare5, btnSquare6), imgBlack0);
            disableAllButtons();
            setWinnerCounter(2);
        } else if (isItDraw3CheckO()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare7, btnSquare8, btnSquare9), imgBlack0);
            disableAllButtons();
            setWinnerCounter(2);
        } else if (isItDraw4CheckO()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare1, btnSquare4, btnSquare7), imgBlack0);
            disableAllButtons();
            setWinnerCounter(2);
        } else if (isItDraw5CheckO()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare2, btnSquare5, btnSquare8), imgBlack0);
            disableAllButtons();
            setWinnerCounter(2);
        } else if (isItDraw6CheckO()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare3, btnSquare6, btnSquare9), imgBlack0);
            disableAllButtons();
            setWinnerCounter(2);
        } else if (isItDraw7CheckO()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare3, btnSquare5, btnSquare7), imgBlack0);
            disableAllButtons();
            setWinnerCounter(2);
        } else if (isItDraw8CheckO()) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare1, btnSquare5, btnSquare9), imgBlack0);
            disableAllButtons();
            setWinnerCounter(2);
        }
    }

    private void buttonsAction(Button button) {
        clicksCounter++;
        if (clicksCounter % 2 == 0) {
            GameplayController.setXonButton(button, imgWhiteX, xListOfButtons);
            ifXHasWon();
            panel = new Panel();
            panel.setWhoseTurnToPlayLabel();
        } else {
            GameplayController.setOonButton(button, imgWhite0, oListOfButtons);
            ifOHasWon();
            panel = new Panel();
            panel.setWhoseTurnToPlayLabel();
        }
    }

    private void setAllSquareButtonsOnAction() {
        allButtons.stream().forEach(b -> b.setOnAction(event -> buttonsAction(b)));
    }

    //set numberOfCLicksCounter to 1 or 2
    //is used to change the player who is starting the game
    public void setNumberOfClicksCounterToRandomNumber() {
        clicksCounter = random.nextInt(2);
    }

    public int returnSizeOfArrayLists() {
        return oListOfButtons.size() + xListOfButtons.size();
    }

    public void setArrayListsToBeEmpty() {
        xListOfButtons.clear();
        oListOfButtons.clear();
    }

    public boolean isItDraw1CheckO() {
        return oListOfButtons.containsAll(Arrays.asList(btnSquare1, btnSquare2, btnSquare3));
    }

    public boolean isItDraw2CheckO() {
        return oListOfButtons.containsAll(Arrays.asList(btnSquare4, btnSquare5, btnSquare6));
    }

    public boolean isItDraw3CheckO() {
        return oListOfButtons.containsAll(Arrays.asList(btnSquare7, btnSquare8, btnSquare9));
    }

    public boolean isItDraw4CheckO() {
        return oListOfButtons.containsAll(Arrays.asList(btnSquare1, btnSquare4, btnSquare7));
    }

    public boolean isItDraw5CheckO() {
        return oListOfButtons.containsAll(Arrays.asList(btnSquare2, btnSquare5, btnSquare8));
    }

    public boolean isItDraw6CheckO() {
        return oListOfButtons.containsAll(Arrays.asList(btnSquare3, btnSquare6, btnSquare9));
    }

    public boolean isItDraw7CheckO() {
        return oListOfButtons.containsAll(Arrays.asList(btnSquare3, btnSquare5, btnSquare7));
    }

    public boolean isItDraw8CheckO() {
        return oListOfButtons.containsAll(Arrays.asList(btnSquare1, btnSquare5, btnSquare9));
    }

    public boolean isItDraw1CheckX() {
        return xListOfButtons.containsAll(Arrays.asList(btnSquare1, btnSquare2, btnSquare3));
    }

    public boolean isItDraw2CheckX() {
        return xListOfButtons.containsAll(Arrays.asList(btnSquare4, btnSquare5, btnSquare6));
    }

    public boolean isItDraw3CheckX() {
        return xListOfButtons.containsAll(Arrays.asList(btnSquare7, btnSquare8, btnSquare9));
    }

    public boolean isItDraw4CheckX() {
        return xListOfButtons.containsAll(Arrays.asList(btnSquare1, btnSquare4, btnSquare7));
    }

    public boolean isItDraw5CheckX() {
        return xListOfButtons.containsAll(Arrays.asList(btnSquare2, btnSquare5, btnSquare8));
    }

    public boolean isItDraw6CheckX() {
        return xListOfButtons.containsAll(Arrays.asList(btnSquare3, btnSquare6, btnSquare9));
    }

    public boolean isItDraw7CheckX() {
        return xListOfButtons.containsAll(Arrays.asList(btnSquare3, btnSquare5, btnSquare7));
    }

    public boolean isItDraw8CheckX() {
        return xListOfButtons.containsAll(Arrays.asList(btnSquare1, btnSquare5, btnSquare9));
    }

    private void setAllButtonsToList() {
        allButtons.addAll(Arrays.asList(btnSquare1, btnSquare2, btnSquare3, btnSquare4,
                    btnSquare5, btnSquare6, btnSquare7, btnSquare8, btnSquare9));
    }

    private void disableAllButtons() {
        allButtons.stream().forEach(b -> b.setDisable(true));
    }
}
