package Controllers;

import View.Credentials;
import javafx.scene.Scene;

/**
 * Created by Edgaras on 18/07/2016.
 */
public class CredentialsController {

    Credentials credentials = new Credentials();

    public Scene getCredentials() {
        return credentials.getScnCredentials();
    }

    public String getNamePlayer1() {
        return credentials.getPlayer1Name();
    }

    public String getNamePlayer2() {
        return credentials.getPlayer2Name();
    }
}
