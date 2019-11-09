package Controllers;

import View.Credentials;
import javafx.scene.Scene;

/**
 * Created by Edgaras on 18/07/2016.
 */
public class CredentialsController {

    //Should use/have view instance and player model instance

    Credentials credentials = new Credentials();

    public Scene getCredentials()
    {

        return credentials.getScnCredentials();
    }

    public String getNamePlayer1()
    {
        String name;
        name = credentials.getPlayer1Name();

        return name;
    }

    public String getNamePlayer2()
    {
        String name;
        name = credentials.getPlayer2Name();

        return name;
    }
}
