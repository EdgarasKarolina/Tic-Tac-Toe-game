package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Credits {

    private BorderPane borderPane = new BorderPane();
    private Scene scnCredits;
    private VBox vBoxCredits;
    private Button btnBack = new Button("Back");
    private Label lblCredits = new Label("Tic Tac Toe \n\n CREDITS \n\n CODE WRITER \n Edgaras Kazlauskas");

    static Start start = new Start();

    public Scene getCredits() {
        vBoxCredits = new VBox();
        vBoxCredits.getChildren().addAll(lblCredits, btnBack);
        scnCredits = new Scene(vBoxCredits, 200, 300);
        scnCredits.getStylesheets().add("Resources/Styles/CreditsStyles.css");
        vBoxCredits.getStyleClass().add("credits-vbox");
        btnBack.getStyleClass().add("credits-button");
        lblCredits.getStyleClass().add("credits-label");
        setButtonsOnAction();

        return scnCredits;
    }

    private void setButtonsOnAction() {
        btnBack.setOnAction(event -> {
            start.setMainSceneToStage();
        });
    }
}
