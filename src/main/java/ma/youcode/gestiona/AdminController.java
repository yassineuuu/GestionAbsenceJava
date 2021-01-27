package ma.youcode.gestiona;

import javafx.fxml.FXML;

import java.io.IOException;

public class AdminController {

    @FXML
    private void switchToSecretaire() throws IOException {
        Main.setRoot("secretaire");
    }
}
