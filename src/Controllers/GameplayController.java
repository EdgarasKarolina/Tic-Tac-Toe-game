package Controllers;

import Model.TTTButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class GameplayController {

    PanelController panelController = new PanelController();

    public static int turnsCount = 0;

    public void setSquareButtonsOnAction(List<TTTButton> squareButtons, Image imgX,
                Image img0, List<TTTButton> listX, List<TTTButton> list0)
    {
        for (TTTButton button : squareButtons)
            button.setOnAction(event -> squareButtonsAction(button, imgX, img0, listX, list0));
    }

    public void squareButtonsAction(TTTButton squareButton, Image imgX, Image img0, List<TTTButton> listX,
                List<TTTButton> list0)
    {
        turnsCount++;
        if (turnsCount % 2 == 0)
        {
            setXonButton(squareButton, imgX, listX);
            //ifXHasWon();
            panelController.setWhoseTurnToPlayLabel();
        }
        else
        {
            setOonButton(squareButton, img0, list0);
            //ifOHasWon();
            panelController.setWhoseTurnToPlayLabel();
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
}
