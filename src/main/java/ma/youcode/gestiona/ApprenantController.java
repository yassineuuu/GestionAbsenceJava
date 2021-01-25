package ma.youcode.gestiona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.ImpDAO.ApprenantDAOImp;
import ma.youcode.gestiona.Modeles.Apprenant;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ApprenantController{

    @FXML private TableView<Apprenant> table_absence;
    @FXML private TableColumn<Apprenant,String> col_nom;
    @FXML private TableColumn<Apprenant,String> col_prenom;
    @FXML private TableColumn<Apprenant,String> col_classe;
    @FXML private TableColumn<Apprenant,String> col_absence;
    @FXML private TableColumn<Apprenant,String> col_justifier;
    @FXML private TextField txt_name;
    @FXML private Button searchBtn;

    public ObservableList<Apprenant> data = FXCollections.observableArrayList();


    @FXML
    public void getStudent(){

        searchBtn.setOnAction(e->{
            col_nom.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("prenom"));
            col_classe.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("classe"));
            col_absence.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("absence"));
            col_justifier.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("justifier"));

            ApprenantDAOImp apprenantDAO =new ApprenantDAOImp();
            table_absence.setItems(apprenantDAO.getByName(txt_name.getText()));
        });

    }
}
