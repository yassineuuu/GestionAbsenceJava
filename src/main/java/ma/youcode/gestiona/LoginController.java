package ma.youcode.gestiona;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.prefs.Preferences;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import ma.youcode.gestiona.Connection.ConnectionFactory;


public class LoginController {

    @FXML
    private TextField userNameInput;

    @FXML
    private PasswordField mdpInput;

    @FXML
    private Button loginButton;

    @FXML
    private VBox loginBox;


    @FXML
    private void login() throws IOException, SQLException {
        String username = userNameInput.getText();
        String mdp = mdpInput.getText();

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `utilisateur` WHERE Username= ? && MDP = ?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, mdp);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            switch (resultSet.getString("Role")){
                case "Admin":
                    Main.setRoot("admin");
                    break;
                case "Secretaire":
                    Main.setRoot("secretaire");
                    break;
                case "Formateur":
                    Main.setRoot("formateur");
                    break;
                case "Apprenant":
                    Main.setRoot("Apprenant");
                    break;
                default:
                    loginBox.getChildren().add(new Label("Role n'exist pas"));
            }
            Preferences preferences = Preferences.userNodeForPackage(getClass());
            preferences.put("id", String.valueOf(resultSet.getInt("id")));
            System.out.println(preferences.get("id", "root"));

            conn.close();
        }else {
            loginBox.getChildren().add(new Label());
            loginBox.getChildren().add(new Label());
            loginBox.getChildren().add(new Label("Username or Password is wrong"));
        }

    }
}