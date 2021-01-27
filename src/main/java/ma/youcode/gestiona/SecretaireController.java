package ma.youcode.gestiona;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.ImpDAO.ApprenantDAO;
import ma.youcode.gestiona.ImpDAO.SecretaireDAO;
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
        private TextField txt_username;

        @FXML
        private TextField txt_class;

        @FXML
        private TextField txt_promo;

        @FXML
        private TextField txt_absence;

        @FXML
        private TextField txt_id;

        ObservableList<Apprenant> listM;

        int index = -1;

        Connection conn =null;
        ResultSet rs = null;
        PreparedStatement pst = null;


        public void Add_users () throws SQLException {
            conn = ConnectionFactory.getConnection();
            String sql = "insert into users (username,class,promo,absence)values(?,?,?,? )";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, txt_username.getText());
                pst.setString(2, txt_class.getText());
                pst.setString(3, txt_promo.getText());
                pst.setString(4, txt_absence.getText());
                pst.execute();

                UpdateTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //////// methode select users ///////
        @FXML
        void getSelected (MouseEvent event){
            index = table_users.getSelectionModel().getSelectedIndex();
            if (index <= -1){

                return;
            }
            txt_id.setText(col_id.getCellData(index).toString());
            txt_username.setText(col_username.getCellData(index).toString());
            txt_class.setText(col_class.getCellData(index).toString());
            txt_promo.setText(col_promo.getCellData(index).toString());
            txt_absence.setText(col_absence.getCellData(index).toString());

        }

        public void Edit (){
            try {
                conn = ConnectionFactory.getConnection();
                String value1 = txt_id.getText();
                String value2 = txt_username.getText();
                String value3 = txt_class.getText();
                String value4 = txt_promo.getText();
                String value5 = txt_absence.getText();
                String sql = "update users set user_id= '"+value1+"',username= '"+value2+"',class= '"+
                        value3+"',promo= '"+value4+"',absence= '"+value5+"' where user_id='"+value1+"' ";
                pst= conn.prepareStatement(sql);
                pst.execute();
                UpdateTable();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void Delete() throws SQLException {
            conn = ConnectionFactory.getConnection();
            String sql = "delete from users where user_id = ?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, txt_id.getText());
                pst.execute();

                UpdateTable();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        public void UpdateTable() throws SQLException {
            ApprenantDAO secretaireDAO = new ApprenantDAO();
            col_id.setCellValueFactory(new PropertyValueFactory<Apprenant,Integer>("id"));
            col_username.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("username"));
            col_class.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("classe"));
            col_promo.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("promo"));
            col_absence.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("absence"));

            table_users.setItems(secretaireDAO.getAll());
        }
        @Override
        public void initialize(URL url, ResourceBundle rb) {

            try {
                UpdateTable();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


}