package Controllers;

import View.EnterNamesView;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Edgaras on 18/07/2016.
 */
public class EnterNamesController {

    EnterNamesView enterNamesView = new EnterNamesView();

    public Scene getEnterNamesView()
    {

        return enterNamesView.getEnterNamesScene();
    }

    public String getNamePlayer1()
    {
        String name;
        name = enterNamesView.getNamePlayer1();

        return name;
    }

    public String getNamePlayer2()
    {
        String name;
        name = enterNamesView.getNamePlayer2();

        return name;
    }
}
