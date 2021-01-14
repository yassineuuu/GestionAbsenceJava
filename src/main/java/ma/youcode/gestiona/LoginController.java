package ma.youcode.gestiona;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void switchToAdmin() throws IOException {
        Main.setRoot("admin");
    }
}
