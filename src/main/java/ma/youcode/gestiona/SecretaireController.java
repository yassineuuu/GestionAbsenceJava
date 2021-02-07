package ma.youcode.gestiona;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.ImpDAO.FormateurAbsenceDAOImp;
import ma.youcode.gestiona.ImpDAO.SecretaireApprenantDAO;
import ma.youcode.gestiona.Modeles.Apprenant;
import ma.youcode.gestiona.Modeles.ClasseAbsence;


public class SecretaireController implements Initializable {
    Preferences preferences = Preferences.userNodeForPackage(getClass());

    SecretaireApprenantDAO secretaireDAO = new SecretaireApprenantDAO();



    @FXML
        private TableView<ClasseAbsence> table_users;

        @FXML
        private TableColumn<ClasseAbsence, Integer> col_id;

        @FXML
        private TableColumn<ClasseAbsence, String> col_username;

        @FXML
        private TableColumn<ClasseAbsence, String> col_prenom;

        @FXML
        private TableColumn<ClasseAbsence, String> col_class;

        @FXML
        private TableColumn<ClasseAbsence, String> col_promo;

        @FXML
        private TableColumn<ClasseAbsence, String> col_absence;

        @FXML
        private TableColumn<ClasseAbsence, String> col_justif;

        @FXML
        private TableColumn<ClasseAbsence, String> col_Date;

        @FXML
        private Label txt_id;

        @FXML
        private Label txt_user;

        @FXML
        private Label txt_classe;

        @FXML
        private Label txt_promoo;

        @FXML
        private Button actubtn;

        @FXML
        private TextField txt_absence;
        @FXML
        private ComboBox JustifAbsence;

        @FXML
        private DatePicker datePick;


        ObservableList<Apprenant> listM;

        int index = -1;

        Connection conn =null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        //////// methode select users ///////
        @FXML
        void getSelected (MouseEvent event){
            index = table_users.getSelectionModel().getSelectedIndex();
            if (index <= -1){

                return;
            }
            txt_id.setText(col_id.getCellData(index).toString());
            txt_user.setText(col_username.getCellData(index).toString()+" "+col_prenom.getCellData(index).toString());
            txt_classe.setText(col_class.getCellData(index).toString());
            txt_promoo.setText(col_promo.getCellData(index).toString());
            JustifAbsence.setValue(col_justif.getCellData(index).toString());

        }

        public void Edit (){
            try {
                conn = ConnectionFactory.getConnection();
                String value3 = txt_classe.getText();
                String value4 = txt_promoo.getText();
                String value2 = txt_user.getText();
                String value5 = (String) JustifAbsence.getValue();
                String sql = "update absences set justifier= '"+value5+"' where id='"+txt_id.getText()+"' ";
                pst= conn.prepareStatement(sql);
                pst.execute();
                UpdateTable();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        public void UpdateTable() throws SQLException {
            col_id.setCellValueFactory(new PropertyValueFactory<ClasseAbsence,Integer>("id_absence"));
            col_username.setCellValueFactory(new PropertyValueFactory<ClasseAbsence,String>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<ClasseAbsence,String>("prenom"));
            col_class.setCellValueFactory(new PropertyValueFactory<ClasseAbsence,String>("classe"));
            col_promo.setCellValueFactory(new PropertyValueFactory<ClasseAbsence,String>("promotion"));
            col_absence.setCellValueFactory(new PropertyValueFactory<ClasseAbsence,String>("type_absence"));
            col_justif.setCellValueFactory(new PropertyValueFactory<ClasseAbsence,String>("justif"));
            col_Date.setCellValueFactory(new PropertyValueFactory<ClasseAbsence,String>("date_absence"));
            table_users.setItems(secretaireDAO.getAllCA());
        }

        public void getByDate(){
            table_users.setItems(secretaireDAO.getAll(String.valueOf(datePick.getValue())));
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {
            JustifAbsence();
            try {
                UpdateTable();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    public void JustifAbsence(){

        ObservableList typeAbsence = FXCollections.observableArrayList(
                "justifier","non justifier"
        );

        JustifAbsence.setItems(typeAbsence);


    }

    public void actualisationTable() throws SQLException, IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("secPopup.fxml"));
        stage.setScene(new Scene(root,450,200));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(actubtn.getScene().getWindow());
        stage.showAndWait();


    }

    @FXML
    private void logout() throws IOException {
        Main.setRoot("login");
    }

}