package ma.youcode.gestiona;

import javafx.fxml.FXML;

import java.io.IOException;

public class ApprenantController {

    @FXML
    private void switchToLogin() throws IOException {
        Main.setRoot("login");
    }
}
