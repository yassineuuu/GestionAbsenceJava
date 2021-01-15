package ma.youcode.gestiona;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `utilisateurs` WHERE Username= ? && MDP = ?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, mdp);

        ResultSet resultSet = preparedStatement.executeQuery();
//
//        String role = resultSet.getString("Username");
//
//        System.out.println(role);
//
//        System.out.println(username);
//        System.out.println(mdp);
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
            conn.close();
        }else {
            loginBox.getChildren().add(new Label());
            loginBox.getChildren().add(new Label());
            loginBox.getChildren().add(new Label("Username or Password is wrong"));
        }

    }
}