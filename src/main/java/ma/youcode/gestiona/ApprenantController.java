package ma.youcode.gestiona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.youcode.gestiona.ImpDAO.ApprenantDAO;
import ma.youcode.gestiona.ImpDAO.ApprenantDAOImp;
import ma.youcode.gestiona.ImpDAO.FormateurDAOImp;
import ma.youcode.gestiona.Modeles.ApprenantApprenant;

import java.io.IOException;
import java.sql.SQLException;
import java.util.prefs.Preferences;


import java.net.URL;
import java.util.ResourceBundle;

public class ApprenantController implements Initializable{

    Preferences pref = Preferences.userRoot();

    ApprenantDAOImp apprenantDAO =new ApprenantDAOImp();
    ApprenantDAO apprenant = new ApprenantDAO();


    @FXML private TableView<ApprenantApprenant> table_absence;
    @FXML private TableColumn<ApprenantApprenant,String> col_nom;
    @FXML private TableColumn<ApprenantApprenant,String> col_prenom;
    @FXML private TableColumn<ApprenantApprenant,String> col_classe;
    @FXML private TableColumn<ApprenantApprenant,String> col_absence;
    @FXML private TableColumn<ApprenantApprenant,String> col_justifier;
    @FXML private TableColumn<ApprenantApprenant,String> col_date;

    @FXML private Button searchBtn;
    @FXML private ComboBox comb;

    public ObservableList<ApprenantApprenant> data = FXCollections.observableArrayList();


    @FXML
    public void getStudent(){

            col_nom.setCellValueFactory(new PropertyValueFactory<ApprenantApprenant,String>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<ApprenantApprenant,String>("prenom"));
            col_classe.setCellValueFactory(new PropertyValueFactory<ApprenantApprenant,String>("classe"));
            col_absence.setCellValueFactory(new PropertyValueFactory<ApprenantApprenant,String>("absence"));
            col_justifier.setCellValueFactory(new PropertyValueFactory<ApprenantApprenant,String>("justifier"));
            col_date.setCellValueFactory(new PropertyValueFactory<ApprenantApprenant,String>("date"));


            try {
//                System.out.println(apprenant.getAll(pref.getInt("id",1)).get(0).getIdApprenant());
                table_absence.setItems(apprenantDAO.getByName(String.valueOf(comb.getValue()), apprenant.getAll(pref.getInt("id",1)).get(0).getIdApprenant()));
            } catch (SQLException exception) {
                exception.printStackTrace();
            }


    }
    public void fillCombobox(){
        ObservableList<String> list = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");

        comb.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillCombobox();
        try {
            col_nom.setCellValueFactory(new PropertyValueFactory<ApprenantApprenant,String>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<ApprenantApprenant,String>("prenom"));
            col_classe.setCellValueFactory(new PropertyValueFactory<ApprenantApprenant,String>("classe"));
            col_absence.setCellValueFactory(new PropertyValueFactory<ApprenantApprenant,String>("absence"));
            col_justifier.setCellValueFactory(new PropertyValueFactory<ApprenantApprenant,String>("justifier"));
            col_date.setCellValueFactory(new PropertyValueFactory<ApprenantApprenant,String>("date"));
            table_absence.setItems(apprenantDAO.getByName(apprenant.getAll(pref.getInt("id",1)).get(0).getIdApprenant()));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    @FXML
    private void logout() throws IOException {
        Main.setRoot("login");
    }
}
