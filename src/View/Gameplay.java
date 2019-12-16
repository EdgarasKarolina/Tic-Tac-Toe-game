package View;

import Controllers.GameplayController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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

    private static int turnsCounter;
    private static int winnerCounter;
    private static boolean isWinner;
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
        return turnsCounter;
    }

    public int getWinnerCounter() {
        return winnerCounter;
    }

    public void setWinnerCounter(int count) {
        winnerCounter = count;
    }

    public boolean getIsWinner() {
        return isWinner;
    }

    private void buttonsAction(Button button) {
        turnsCounter++;
        if (turnsCounter % 2 == 0) {
            GameplayController.setXonButton(button, imgWhiteX, xListOfButtons);
            playerHasWon(xListOfButtons, imgBlackX, 1);
            panel = new Panel();
            panel.setWhoseTurnToPlayLabel();
        } else {
            GameplayController.setOonButton(button, imgWhite0, oListOfButtons);
            playerHasWon(oListOfButtons, imgBlack0, 2);
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
        turnsCounter = random.nextInt(2);
    }

    public int returnSizeOfArrayLists() {
        return oListOfButtons.size() + xListOfButtons.size();
    }

    public void setArrayListsToBeEmpty() {
        xListOfButtons.clear();
        oListOfButtons.clear();
    }

    private void playerHasWon(ArrayList<Button> buttons, Image image, int winnerCounter) {
        isWinner = true;
        if (containsLine1(buttons)) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare1, btnSquare2, btnSquare3), image);
            disableAllButtons();
            setWinnerCounter(winnerCounter);
        } else if (containsLine2(buttons)) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare4, btnSquare5, btnSquare6), image);
            disableAllButtons();
            setWinnerCounter(winnerCounter);
        } else if (containsLine3(buttons)) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare7, btnSquare8, btnSquare9), image);
            disableAllButtons();
            setWinnerCounter(winnerCounter);
        } else if (containsLine4(buttons)) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare1, btnSquare4, btnSquare7), image);
            disableAllButtons();
            setWinnerCounter(winnerCounter);
        } else if (containsLine5(buttons)) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare2, btnSquare5, btnSquare8), image);
            disableAllButtons();
            setWinnerCounter(winnerCounter);
        } else if (containsLine6(buttons)) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare3, btnSquare6, btnSquare9), image);
            disableAllButtons();
            setWinnerCounter(winnerCounter);
        } else if (containsLine7(buttons)) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare3, btnSquare5, btnSquare7), image);
            disableAllButtons();
            setWinnerCounter(winnerCounter);
        } else if (containsLine8(buttons)) {
            GameplayController.setBlackBackground(Arrays.asList(btnSquare1, btnSquare5, btnSquare9), image);
            disableAllButtons();
            setWinnerCounter(winnerCounter);
        } else {
            isWinner = false;
        }
    }

    private boolean containsLine1(ArrayList<Button> buttons) {
        return buttons.containsAll(Arrays.asList(btnSquare1, btnSquare2, btnSquare3));
    }

    private boolean containsLine2(ArrayList<Button> buttons) {
        return buttons.containsAll(Arrays.asList(btnSquare4, btnSquare5, btnSquare6));
    }

    private boolean containsLine3(ArrayList<Button> buttons) {
        return buttons.containsAll(Arrays.asList(btnSquare7, btnSquare8, btnSquare9));
    }

    private boolean containsLine4(ArrayList<Button> buttons) {
        return buttons.containsAll(Arrays.asList(btnSquare1, btnSquare4, btnSquare7));
    }

    private boolean containsLine5(ArrayList<Button> buttons) {
        return buttons.containsAll(Arrays.asList(btnSquare2, btnSquare5, btnSquare8));
    }

    private boolean containsLine6(ArrayList<Button> buttons) {
        return buttons.containsAll(Arrays.asList(btnSquare3, btnSquare6, btnSquare9));
    }

    private boolean containsLine7(ArrayList<Button> buttons) {
        return buttons.containsAll(Arrays.asList(btnSquare3, btnSquare5, btnSquare7));
    }

    private boolean containsLine8(ArrayList<Button> buttons) {
        return buttons.containsAll(Arrays.asList(btnSquare1, btnSquare5, btnSquare9));
    }

    private void setAllButtonsToList() {
        allButtons.addAll(Arrays.asList(btnSquare1, btnSquare2, btnSquare3, btnSquare4,
                    btnSquare5, btnSquare6, btnSquare7, btnSquare8, btnSquare9));
    }

    private void disableAllButtons() {
        allButtons.stream().forEach(b -> b.setDisable(true));
    }
}
