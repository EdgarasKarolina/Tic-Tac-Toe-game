package Utilities;

import javafx.scene.control.TextField;

public class Validation {

    public static boolean validateName(TextField name) {
        return name.getText().trim().equals("");
    }
}
