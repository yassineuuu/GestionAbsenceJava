package ma.youcode.gestiona;

import javafx.fxml.FXML;

import java.io.IOException;

public class FormateurController {

    @FXML
    private void switchToApprenant() throws IOException {
        Main.setRoot("Apprenant");
    }
}
