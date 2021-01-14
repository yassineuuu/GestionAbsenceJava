package ma.youcode.gestiona;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecretaireController {

    @FXML
    private void switchToFormateur() throws IOException {
        Main.setRoot("formateur");
    }
}