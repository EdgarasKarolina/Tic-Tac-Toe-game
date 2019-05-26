package View;

import Model.TTTButton;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class Gameplay {

    BorderPane borderPane = new BorderPane();

    Scene scnGameplay;

    VBox vBoxGameplay = new VBox();
    HBox hBoxFirstLine = new HBox();
    HBox hBoxSecondLine = new HBox();
    HBox hBoxThirdLine = new HBox();

    TTTButton btnSquare1 = new TTTButton();
    TTTButton btnSquare2 = new TTTButton();
    TTTButton btnSquare3 = new TTTButton();
    TTTButton btnSquare4 = new TTTButton();
    TTTButton btnSquare5 = new TTTButton();
    TTTButton btnSquare6 = new TTTButton();
    TTTButton btnSquare7 = new TTTButton();
    TTTButton btnSquare8 = new TTTButton();
    TTTButton btnSquare9 = new TTTButton();


    static ArrayList<TTTButton> listSquaresX = new ArrayList<>();
    static ArrayList<TTTButton> listSquares0 = new ArrayList<>();

    Image imgWhiteX = new Image(getClass().getResourceAsStream("x.png"));
    Image imgWhite0 = new Image(getClass().getResourceAsStream("o.png"));
    Image imgBlackX = new Image(getClass().getResourceAsStream("x_black.png"));
    Image imgBlack0 = new Image(getClass().getResourceAsStream("o_black.png"));

    ArrayList<TTTButton> allButtons = new ArrayList<TTTButton>();

    Panel playersPanel = new Panel();


    public Scene getGameplay()
    {
        scnGameplay = new Scene(borderPane, 580, 420);
        scnGameplay.getStylesheets().add("Resources/Styles/GameplayStyles.css");

        setAllSquaresToList();
        allButtons.forEach(squareButton->squareButton.getStyleClass().add("square-button"));

        hBoxFirstLine.getChildren().addAll(btnSquare1, btnSquare2, btnSquare3);
        hBoxSecondLine.getChildren().addAll(btnSquare4, btnSquare5, btnSquare6);
        hBoxThirdLine.getChildren().addAll(btnSquare7, btnSquare8, btnSquare9);
        vBoxGameplay.getChildren().addAll(hBoxFirstLine, hBoxSecondLine, hBoxThirdLine);

        borderPane.setLeft(vBoxGameplay);
        borderPane.setRight(playersPanel.getPanel());

        return scnGameplay;
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