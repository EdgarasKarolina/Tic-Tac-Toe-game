package Controllers;

import Model.TTTButton;
import View.Gameplay;
import View.Start;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameplayController {

    static ArrayList<TTTButton> combination1 = new ArrayList<>(Arrays.asList(
            Gameplay.btnSquare1, Gameplay.btnSquare2, Gameplay.btnSquare3 ));

    public static ArrayList<TTTButton> combination2 = new ArrayList<>(Arrays.asList(
            Gameplay.btnSquare4, Gameplay.btnSquare5, Gameplay.btnSquare6 ));

    public static ArrayList<TTTButton> combination3 = new ArrayList<>(Arrays.asList(
            Gameplay.btnSquare7, Gameplay.btnSquare8, Gameplay.btnSquare9 ));

    public static ArrayList<TTTButton> combination4 = new ArrayList<>(Arrays.asList(
            Gameplay.btnSquare1, Gameplay.btnSquare4, Gameplay.btnSquare7 ));

    public static ArrayList<TTTButton> combination5 = new ArrayList<>(Arrays.asList(
            Gameplay.btnSquare2, Gameplay.btnSquare5, Gameplay.btnSquare8 ));

    public static ArrayList<TTTButton> combination6 = new ArrayList<>(Arrays.asList(
            Gameplay.btnSquare3, Gameplay.btnSquare6, Gameplay.btnSquare9 ));

    public static ArrayList<TTTButton> combination7 = new ArrayList<>(Arrays.asList(
            Gameplay.btnSquare3, Gameplay.btnSquare5, Gameplay.btnSquare7 ));

    public static ArrayList<TTTButton> combination8 = new ArrayList<>(Arrays.asList(
            Gameplay.btnSquare1, Gameplay.btnSquare5, Gameplay.btnSquare9 ));

    public static GameplayController gameplayController = new GameplayController();

    Gameplay gameplay = new Gameplay();
    CredentialsController credentialsController = new CredentialsController();
    PanelController panelController = new PanelController();

    public static int turnsCount = 0;

    public void setGameplayToStage()
    {
        Start.setSceneToStage(getGameplayScene());
    }

    public Scene getGameplayScene()
    {
        return gameplay.getGameplay();
    }

    public void setSquareButtonsOnAction(ArrayList<TTTButton> squareButtons, Image imgX,
                Image img0, Image imgXBlack, Image img0Black, ArrayList<TTTButton> listX, ArrayList<TTTButton> list0)
    {
        for (TTTButton button : squareButtons)
            button.setOnAction(event -> squareButtonsAction(button, imgX, img0, imgXBlack, img0Black, listX, list0));
    }

    public void squareButtonsAction(TTTButton squareButton, Image imgX, Image img0, Image imgXBlack, Image img0Black,
                    ArrayList<TTTButton> listX, ArrayList<TTTButton> list0)

    {
        turnsCount++;
        if (turnsCount % 2 == 0)
        {
            setXonButton(squareButton, imgX, listX);
            checkIfXWon(listX, imgXBlack);
            panelController.setWhoseTurnToPlayLabel(credentialsController.getPlayer1Name() + " turn");
        }
        else
        {
            setOonButton(squareButton, img0, list0);
            checkIf0Won(list0, img0Black);
            panelController.setWhoseTurnToPlayLabel(credentialsController.getPlayer2Name() + " turn");
        }
    }

    public void setXonButton(TTTButton button, Image image, List<TTTButton> list) {
        button.setGraphic(new ImageView(image));
        button.setDisable(true);
        list.add(button);
    }

    public void setOonButton(TTTButton button, Image image, List<TTTButton> list) {
        button.setGraphic(new ImageView(image));
        button.setDisable(true);
        list.add(button);
    }

    public void checkIfXWon(ArrayList<TTTButton> squareButtons, Image imgXBlack)
    {
        if (getWinningSquareButtonsX(squareButtons).size() == 3)
        {
            ArrayList<TTTButton> buttons;
            buttons = getWinningSquareButtonsX(squareButtons);
            for(TTTButton button : buttons)
                button.setGraphic(new ImageView(imgXBlack));

            Gameplay.disableSquareButtons();
        }
    }

    public void checkIf0Won(ArrayList<TTTButton> squareButtons, Image img0Black)
    {
        ArrayList<TTTButton> buttons = new ArrayList<>();
        if (getWinningSquareButtons0(squareButtons).size() == 3)
        {
            buttons = getWinningSquareButtons0(squareButtons);
            for(TTTButton button : buttons)
                button.setGraphic(new ImageView(img0Black));

            Gameplay.disableSquareButtons();
        }
    }

    public ArrayList<TTTButton> getWinningSquareButtonsX(ArrayList<TTTButton> squareButtons)
    {
        ArrayList <TTTButton> emptyList = new ArrayList<>();
        if (squareButtons.containsAll(combination1))
            return combination1;
        else if (squareButtons.containsAll(combination2))
            return combination2;
        else if (squareButtons.containsAll(combination3))
            return combination3;
        else if (squareButtons.containsAll(combination4))
            return combination4;
        else if (squareButtons.containsAll(combination5))
            return combination5;
        else if (squareButtons.containsAll(combination6))
            return combination6;
        else if (squareButtons.containsAll(combination7))
            return combination7;
        else if (squareButtons.containsAll(combination8))
            return combination8;
        else return emptyList;
    }

    public ArrayList<TTTButton> getWinningSquareButtons0(ArrayList<TTTButton> squareButtons)
    {
        ArrayList <TTTButton> emptyList = new ArrayList<>();
        if (squareButtons.containsAll(combination1))
            return combination1;
        else if (squareButtons.containsAll(combination2))
            return combination2;
        else if (squareButtons.containsAll(combination3))
            return combination3;
        else if (squareButtons.containsAll(combination4))
            return combination4;
        else if (squareButtons.containsAll(combination5))
            return combination5;
        else if (squareButtons.containsAll(combination6))
            return combination6;
        else if (squareButtons.containsAll(combination7))
            return combination7;
        else if (squareButtons.containsAll(combination8))
            return combination8;
        else return emptyList;
    }
}
