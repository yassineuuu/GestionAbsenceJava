package ma.youcode.gestiona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import ma.youcode.gestiona.ImpDAO.FormateurAbsenceDAOImp;
import ma.youcode.gestiona.ImpDAO.FormateurApprenantDAO;
import ma.youcode.gestiona.ImpDAO.FormateurDAOImp;
import ma.youcode.gestiona.Modeles.Apprenant;
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
    Preferences preferences = Preferences.userRoot();

    FormateurDAOImp formateurDAOImp = new FormateurDAOImp();
    FormateurApprenantDAO formateurApprenantDAO = new FormateurApprenantDAO();
    FormateurAbsenceDAOImp formateurAb = new FormateurAbsenceDAOImp();

    @FXML
    private Label formateur_name;

    @FXML
    private VBox tableVBox;

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
            formateur_name.setText("Formateur "+formateurDAOImp.getId_utilisateurs(preferences.getInt("id",1)).getNom_formateur()+" "+formateurDAOImp.getId_utilisateurs(preferences.getInt("id",1)).getPrenom_formateur());
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

            for (int i = 0; i< formateurApprenantDAO.getAll(formateurDAOImp.getId_utilisateurs(preferences.getInt("id",1)).getId_formateur()).size(); i++){
                listApprenant.getItems().add(formateurApprenantDAO.getAll(formateurDAOImp.getId_utilisateurs(preferences.getInt("id",1)).getId_formateur()).get(i).getPrenom_apprenant()+ " " + formateurApprenantDAO.getAll(formateurDAOImp.getId_utilisateurs(preferences.getInt("id",1)).getId_formateur()).get(i).getNom_apprenant());
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
            table.setItems(formateurApprenantDAO.getAll(formateurDAOImp.getId_utilisateurs(Integer.parseInt(preferences.get("id","root"))).getId_formateur()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int index = table.getSelectionModel().getSelectedIndex();
        table.setOnMouseClicked(e->{
            if (index <= -1){
                try {
                    getStudentToInput();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }

            }

        });




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


    public void getStudentToInput() throws SQLException {

        String apprenantNom = table.getSelectionModel().getSelectedItem().getNom_apprenant();
        String apprenantPrenom = table.getSelectionModel().getSelectedItem().getPrenom_apprenant();

        /******************
         * Student Table
         ******************/
        TableView<Apprenant> absenceTable = new TableView();
        absenceTable.setMaxHeight(150);
        absenceTable.setMaxWidth(420);

        TableColumn<Apprenant,String> nom = new TableColumn();
        nom.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("nom"));
        nom.setText("Nom");
        nom.setMinWidth(100);

        TableColumn<Apprenant,String> prenom = new TableColumn();
        prenom.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("prenom"));
        prenom.setText("Prénom");
        prenom.setMinWidth(100);

        TableColumn<Apprenant,String> absence = new TableColumn();
        absence.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("type_absence"));
        absence.setText("Absence");
        absence.setMinWidth(100);

        TableColumn<Apprenant,String> date_absence = new TableColumn();
        date_absence.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("date_absence"));
        date_absence.setText("Date");
        date_absence.setMinWidth(120);

        absenceTable.getColumns().addAll(nom,prenom,absence,date_absence);
        absenceTable.setItems(formateurAb.getAll(apprenantNom,apprenantPrenom));






                listApprenant.setValue(apprenantPrenom +" "+ apprenantNom);
                Label titreTable = new Label("Absence de ce mois:");
                titreTable.setFont(Font.font("Tw Cen MT",22));
                titreTable.setTextFill(Color.WHITE);

                if (tableVBox.getChildren().size()==2){
                    tableVBox.getChildren().add(titreTable);
                    tableVBox.getChildren().add(absenceTable);

                }else {
                    tableVBox.getChildren().remove(3);
                    tableVBox.getChildren().add(absenceTable);

                }


    }



    @FXML
    private void logout() throws IOException {
        Main.setRoot("login");
    }
}
