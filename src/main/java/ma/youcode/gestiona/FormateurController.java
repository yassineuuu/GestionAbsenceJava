package ma.youcode.gestiona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.youcode.gestiona.ImpDAO.AbsenceDAOImp;
import ma.youcode.gestiona.ImpDAO.ApprenantDAO;
import ma.youcode.gestiona.ImpDAO.FormateurDAOImp;
import ma.youcode.gestiona.Modeles.Absence;
import ma.youcode.gestiona.Modeles.Apprenant;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class FormateurController implements Initializable {

    FormateurDAOImp formateurDAOImp = new FormateurDAOImp();
    ApprenantDAO apprenantDAO = new ApprenantDAO();

    @FXML
    private Label formateur_name;

    @FXML
    private ComboBox listApprenant;

    @FXML
    private DatePicker dateInput;

    @FXML
    private ComboBox typeAbs;

    @FXML
    private Button login;

    @FXML
    private Button buttonAjouter;

    @FXML
    private Button buttonSupprimer;

    @FXML
    private Button buttonModifier;

    @FXML
    private TableView<Apprenant> table;

    @FXML
    private TableColumn colunmnNom;

    @FXML
    private TableColumn colunmnPrenom;

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
        remplireTable();
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

            for (int i = 0; i<apprenantDAO.getAll(1).size(); i++){
                listApprenant.getItems().add(apprenantDAO.getAll(1).get(i).getPrenom_apprenant()+ " " +apprenantDAO.getAll(1).get(i).getNom_apprenant());
            }
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

    public void remplireTable() {



        colunmnNom.setCellValueFactory(new PropertyValueFactory<Apprenant, String>("nom_apprenant"));
        colunmnPrenom.setCellValueFactory(new PropertyValueFactory<Apprenant, String>("prenom_apprenant"));

        try {
            table.setItems(apprenantDAO.getAll(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @FXML
    public void AjouterAbsences(){

        AbsenceDAOImp absenceDAOImp = new AbsenceDAOImp();
        String appren = (String) listApprenant.getValue();
        String date = String.valueOf(dateInput.getValue());
        String typeabsence = (String) typeAbs.getValue();

        System.out.println(appren+date+typeabsence);

        Absence absence = new Absence(appren,typeabsence,date);
        absenceDAOImp.insert(absence);


    }
}
