package View;

import Model.TTTButton;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class Gameplay {

    BorderPane borderPane;

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

    static ArrayList<TTTButton> listSquaresX = new ArrayList<>();
    static ArrayList<TTTButton> listSquares0 = new ArrayList<>();

    Image imgWhiteX = new Image(getClass().getResourceAsStream("x.png"));
    Image imgWhite0 = new Image(getClass().getResourceAsStream("o.png"));
    Image imgBlackX = new Image(getClass().getResourceAsStream("x_black.png"));
    Image imgBlack0 = new Image(getClass().getResourceAsStream("o_black.png"));
}
