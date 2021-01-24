package ma.youcode.gestiona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import ma.youcode.gestiona.ImpDAO.ApprenantDAO;
import ma.youcode.gestiona.ImpDAO.FormateurDAOImp;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FormateurController implements Initializable {
    FormateurDAOImp formateurDAOImp = new FormateurDAOImp();
    ApprenantDAO apprenantDAO = new ApprenantDAO();

    @FXML
    private Label formateur_name;

    @FXML
    private ComboBox listApprenant;
    @FXML
    private ComboBox typeAbs;

    @FXML
    private Button login;

    @FXML
    private void switchToApprenant() throws IOException {
        Main.setRoot("Apprenant");
    }
    @FXML
    private void login() throws IOException {
        Main.setRoot("login");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        formateur_name();
        lesApprenants();
        typeAbsence();
    }

    private void formateur_name() {
        try {
            formateur_name.setText("Formateur "+formateurDAOImp.get(1).getNom_formateur()+" "+formateurDAOImp.get(1).getPrenom_formateur());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void lesApprenants(){
        try {

            listApprenant.setItems(apprenantDAO.getAll(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void typeAbsence(){

        ObservableList typeAbsence = FXCollections.observableArrayList(
                "Retard","Absence"
        );

        typeAbs.setItems(typeAbsence);


    }
}
