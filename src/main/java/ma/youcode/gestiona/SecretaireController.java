package ma.youcode.gestiona;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.ImpDAO.SecretaireApprenantDAO;
import ma.youcode.gestiona.Modeles.Apprenant;


public class SecretaireController implements Initializable {


        @FXML
        private TableView<Apprenant> table_users;

        @FXML
        private TableColumn<Apprenant, Integer> col_id;

        @FXML
        private TableColumn<Apprenant, String> col_username;

        @FXML
        private TableColumn<Apprenant, String> col_class;

        @FXML
        private TableColumn<Apprenant, String> col_promo;

        @FXML
        private TableColumn<Apprenant, String> col_absence;

        @FXML
        private TableColumn<Apprenant, String> col_justif;

        @FXML
        private Label txt_user;

        @FXML
        private Label txt_classe;

        @FXML
        private Label txt_promoo;

        @FXML
        private TextField txt_absence;
        @FXML
        private ComboBox JustifAbsence;


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
            txt_user.setText(col_username.getCellData(index).toString());
            txt_classe.setText(col_class.getCellData(index).toString());
            txt_promoo.setText(col_promo.getCellData(index).toString());
            JustifAbsence.setValue(col_absence.getCellData(index).toString());

        }

        public void Edit (){
            try {
                conn = ConnectionFactory.getConnection();
                String value3 = txt_classe.getText();
                String value4 = txt_promoo.getText();
                String value2 = txt_user.getText();
                String value5 = (String) JustifAbsence.getValue();
                String sql = "update absences set nom= '"+value2+"',classe= '"+
                            value3+"',promotion= '"+value4+"',justifier= '"+value5+"' where nom='"+txt_user.getText()+"'";
                pst= conn.prepareStatement(sql);
                pst.execute();
                UpdateTable();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        public void UpdateTable() throws SQLException {
            SecretaireApprenantDAO secretaireDAO = new SecretaireApprenantDAO();
            col_username.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("username"));
            col_class.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("classe"));
            col_promo.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("promo"));
            col_absence.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("absence"));
            col_justif.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("justifier"));
            table_users.setItems(secretaireDAO.getAll());
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


}