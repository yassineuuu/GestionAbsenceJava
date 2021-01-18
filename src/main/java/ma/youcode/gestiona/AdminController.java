package ma.youcode.gestiona;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.ImpDAO.UtilisateurDAO;
import ma.youcode.gestiona.Modeles.Utilisateur;

import java.io.IOException;
import java.sql.SQLException;

public class AdminController {

    @FXML
    private VBox buttonsVBox;
    @FXML
    private HBox HBox1;
    @FXML
    private HBox HBox2;


    @FXML
    private void adminCrud(){
        HBox1.getChildren().clear();
        HBox2.getChildren().clear();


        //Image addImage = new Image(getClass().getResourceAsStream("./../../../../resources/img/add.png").toString());
        Image updateImage = new Image(getClass().getResource("../resources/img/edit.png").toString());
//        Image readImage = new Image(getClass().getResource("../../../../resources/img/add.png").toString());
//        Image deleteImage = new Image(getClass().getResource("../../../../resources/img/delete-forever.png").toString());

//        ImageView addIV = new ImageView(addImage);
//        ImageView updateIV = new ImageView(updateImage);
//        ImageView readIV = new ImageView(readImage);
//        ImageView deleteIV = new ImageView(deleteImage);

        System.out.println(updateImage);
//        HBox1.getChildren().add(addIV);
//        HBox1.getChildren().add(readIV);
//
//        HBox2.getChildren().add(updateIV);
//        HBox2.getChildren().add(deleteIV);


    }

    private TableView putTable() throws SQLException {


        TableView utilisateursTable = new TableView();
//
//        TableColumn<Utilisateur, Integer> id = new TableColumn<>();
//        id.setMinWidth(38);
////        id.setCellValueFactory(new PropertyValueFactory<>("id"));
//        id.setText("ID");
//
//        TableColumn<Utilisateur, String> Username = new TableColumn<>();
//        Username.setMinWidth(38);
//        Username.setCellValueFactory(new PropertyValueFactory<>("Username"));
//        Username.setText("Username");
//
//
//        TableColumn<Utilisateur, String> Nom = new TableColumn<>();
//        Nom.setMinWidth(38);
//        Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
//        Nom.setText("Nom");
//
//
//        UtilisateurDAO utilisateurDAO= new UtilisateurDAO();
//        utilisateursTable.setItems(utilisateurDAO.getAll());
//        utilisateursTable.getColumns().addAll(id, Username,Nom);
//
        return utilisateursTable;
    }

    @FXML
    private void addUtilisateur(){

        //Clear VBox
        buttonsVBox.getChildren().clear();

        //Instanciate field
        VBox UsernameVB = new VBox();
        Label UsernameLabel = new Label("Username:");
        TextField UsernameInput = new TextField();
        UsernameVB.getChildren().add(UsernameLabel);
        UsernameVB.getChildren().add(UsernameInput);

        VBox nomVB = new VBox();
        Label nomLabel = new Label("Nom:");
        TextField nomInput = new TextField();
        nomVB.getChildren().add(nomLabel);
        nomVB.getChildren().add(nomInput);

        VBox prenomVB = new VBox();
        Label prenomLabel = new Label("Prénom:");
        TextField prenomInput = new TextField();
        prenomVB.getChildren().add(prenomLabel);
        prenomVB.getChildren().add(prenomInput);

        VBox mdpVB = new VBox();
        Label mdpLabel = new Label("Mot de Passe:");
        TextField mdpInput = new TextField();
        mdpVB.getChildren().add(mdpLabel);
        mdpVB.getChildren().add(mdpInput);

        VBox roleVB = new VBox();
        Label roleLabel = new Label("Rôle:");
        TextField roleInput = new TextField();
        roleVB.getChildren().add(roleLabel);
        roleVB.getChildren().add(roleInput);

        Button addbtn = new Button("Ajouter");

        //The add Utulisateur Action
        addbtn.setOnAction(e1->{
            UtilisateurDAO utilisateurDAO= new UtilisateurDAO();
            Utilisateur utilisateur = new Utilisateur(UsernameInput.getText(),nomInput.getText(),prenomInput.getText(),mdpInput.getText(),roleInput.getText());

            System.out.println(UsernameInput.getText());
            System.out.println(utilisateur.getRole());

            utilisateurDAO.add(utilisateur);


        });

        //Filling the VBox
        buttonsVBox.getChildren().addAll(UsernameVB,nomVB,prenomVB,mdpVB,roleVB,addbtn);

    }

    @FXML
    private void getUtilisateurs() throws SQLException {
//        buttonsVBox.getChildren().clear();
//        buttonsVBox.getChildren().add(putTable());
    }

    @FXML
    private void updateUtilisateur(){

    }
}
