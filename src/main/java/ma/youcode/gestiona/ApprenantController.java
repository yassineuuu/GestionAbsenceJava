package ma.youcode.gestiona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.ImpDAO.ApprenantDAOImp;
import ma.youcode.gestiona.Modeles.Apprenant;
import java.util.prefs.Preferences;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ApprenantController implements Initializable{

    @FXML private TableView<Apprenant> table_absence;
    @FXML private TableColumn<Apprenant,String> col_absence;
    @FXML private TableColumn<Apprenant,String> col_justifier;
    @FXML private TableColumn<Apprenant,String> col_date;

    @FXML private Button searchBtn;
    @FXML private ComboBox comb;

    public ObservableList<Apprenant> data = FXCollections.observableArrayList();


    @FXML
    public void getStudent(){


        searchBtn.setOnAction(e->{
            col_absence.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("absence"));
            col_justifier.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("justifier"));
            col_date.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("date"));



            ApprenantDAOImp apprenantDAO =new ApprenantDAOImp();
            table_absence.setItems(apprenantDAO.getByName(String.valueOf(comb.getValue())));
        });

    }
    public void fillCombobox(){
        ObservableList<String> list = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");

        comb.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillCombobox();
    }
}
