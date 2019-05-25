package View;

import Model.TTTButton;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Panel {

    TTTButton btnReturn = new TTTButton("Return to menu");
    TTTButton btnRestart = new TTTButton("Restart");
    TTTButton btnQuit = new TTTButton("Quit the game");

    Label lblPlayer1Name = new Label();
    Label lblPlayer2Name = new Label();
    Label lblX = new Label();
    Label lblO = new Label();

    VBox vBoxDialogBox = new VBox();
    HBox hBox1 = new HBox();
    HBox hBox2 = new HBox();

    public VBox getPanel()
    {
        return vBoxDialogBox;
    }
}
