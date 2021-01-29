package ma.youcode.gestiona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.youcode.gestiona.ImpDAO.FormateurAbsenceDAOImp;
import ma.youcode.gestiona.ImpDAO.FormateurApprenantDAO;
import ma.youcode.gestiona.ImpDAO.FormateurDAOImp;
import ma.youcode.gestiona.Modeles.ClasseAbsence;
import ma.youcode.gestiona.Modeles.FormateurApprenants;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FormateurController implements Initializable {

    FormateurDAOImp formateurDAOImp = new FormateurDAOImp();
    FormateurApprenantDAO formateurApprenantDAO = new FormateurApprenantDAO();

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
    private TableView<FormateurApprenants> table;

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

            for (int i = 0; i< formateurApprenantDAO.getAll(1).size(); i++){
                listApprenant.getItems().add(formateurApprenantDAO.getAll(1).get(i).getPrenom_apprenant()+ " " + formateurApprenantDAO.getAll(1).get(i).getNom_apprenant());
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



        colunmnNom.setCellValueFactory(new PropertyValueFactory<FormateurApprenants, String>("nom_apprenant"));
        colunmnPrenom.setCellValueFactory(new PropertyValueFactory<FormateurApprenants, String>("prenom_apprenant"));

        try {
            table.setItems(formateurApprenantDAO.getAll(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @FXML
    public void AjouterAbsences(){

        FormateurAbsenceDAOImp formateurAbsenceDAOImp = new FormateurAbsenceDAOImp();
        String appren = (String) listApprenant.getValue();
        String[] apprensplit = appren.split(" ", 2);
        String date = String.valueOf(dateInput.getValue());
        String typeabsence = (String) typeAbs.getValue();

        System.out.println(apprensplit[0]+date+typeabsence);

        ClasseAbsence classeAbsence = new ClasseAbsence(apprensplit[1], apprensplit[0],typeabsence,date);
        formateurAbsenceDAOImp.insert(classeAbsence);


    }
}
