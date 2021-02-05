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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class FormateurController implements Initializable {
    Preferences preferences = Preferences.userNodeForPackage(getClass());

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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        formateur_name();
        lesApprenants();
        typeAbsence();
        remplireTable();
        putDate();
    }

    private void formateur_name() {
        try {
            formateur_name.setText("Formateur "+formateurDAOImp.get(1).getNom_formateur()+" "+formateurDAOImp.get(1).getPrenom_formateur());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void putDate(){
        Date aujourdhui = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        String newstring = DateFor.format(aujourdhui);
        System.out.println(newstring);
        //dateInput.setText(newstring);
        dateInput.setValue(LocalDate.parse(newstring));
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
                "Demi journée","Journée"
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
    public void AjouterAbsences() throws SQLException {

        FormateurAbsenceDAOImp formateurAbsenceDAOImp = new FormateurAbsenceDAOImp();
        String appren = (String) listApprenant.getValue();
        String[] apprensplit = appren.split(" ", 2);
        String date = String.valueOf(dateInput.getValue());
        String typeabsence = (String) typeAbs.getValue();
        String classe = formateurApprenantDAO.get(apprensplit[1], apprensplit[0]).getClasse();
        String promotion = formateurApprenantDAO.get(apprensplit[1], apprensplit[0]).getPromotion();


        ClasseAbsence classeAbsence = new ClasseAbsence(apprensplit[1], apprensplit[0], classe, promotion,typeabsence,date);
        formateurAbsenceDAOImp.insert(classeAbsence);


    }

    @FXML
    private void logout() throws IOException {
        Main.setRoot("login");
    }
}
