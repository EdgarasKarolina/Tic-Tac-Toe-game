package Controllers;

import View.Credentials;
import View.Start;
import javafx.scene.Scene;

public class CredentialsController {

    Credentials credentials = new Credentials();

    public void setCredentialsToStage()
    {
        Start.setSceneToStage(credentials.getCredentials());
    }

    public Scene getCredentialsScene()
    {
        return credentials.getCredentials();
    }

    public String getPlayer1Name()
    {
        return credentials.getPlayer1Name();
    }

    public String getPlayer2Name()
    {
        return credentials.getPlayer2Name();
    }
}
