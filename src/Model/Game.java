package Model;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class Game {

    public Player player1;
    public Player player2;
    private String status;

    public static int turnsCount = 0;
    public static int winnerCount = 0;

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
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


}
