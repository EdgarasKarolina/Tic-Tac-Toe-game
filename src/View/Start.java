package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {

    static Stage stgMainStage = new Stage();
    MainMenu mainMenu = new MainMenu();

    @Override
    public void start(Stage primaryStage) throws Exception {

        stgMainStage.setResizable(false);
        stgMainStage.setScene(mainMenu.getMainMenu());
        stgMainStage.show();
    }

    public static void setSceneToStage(Scene scene)
    {
        stgMainStage.setScene(scene);
    }

    public void setMainSceneToStage()
    {
        stgMainStage.setScene(mainMenu.getMainMenu());
    }
}
