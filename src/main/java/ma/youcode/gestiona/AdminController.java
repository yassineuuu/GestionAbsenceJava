package ma.youcode.gestiona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.ImpDAO.UtilisateurDAO;
import ma.youcode.gestiona.Modeles.Utilisateur;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminController {

    UtilisateurDAO utilisateurDAO;
    VBox modifVBox;


    @FXML
    private VBox buttonsVBox;
    @FXML
    private HBox HBox1;
    @FXML
    private HBox HBox2;
    @FXML
    private VBox usersVBox;
    @FXML
    private VBox navAdmin;
    @FXML
    private VBox navSecretaire;
    @FXML
    private VBox navFormateur;
    @FXML
    private VBox navApprenant;




    @FXML
    private void adminCrud() throws SQLException {

        HBox1.getChildren().clear();
        HBox2.getChildren().clear();
        usersVBox.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));

        Label label0 = new Label("Utilisateurs");
        label0.setFont(Font.font("Tw Cen MT",18));
        usersVBox.getChildren().add(label0);
        usersVBox.setOnMouseClicked(e6->{
            navSecretaire.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navFormateur.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navApprenant.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navAdmin.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            usersVBox.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));

        });

        Label label1 = new Label("Admin");
        label1.setFont(Font.font("Tw Cen MT",18));
        navAdmin.getChildren().add(label1);
        navAdmin.setOnMouseClicked(e6->{
            navSecretaire.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navFormateur.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navApprenant.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            usersVBox.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navAdmin.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));

        });




        Label label2 = new Label("Secretaire");
        label2.setFont(Font.font("Tw Cen MT",18));
        navSecretaire.getChildren().add(label2);
        navSecretaire.setOnMouseClicked(e6->{
            navAdmin.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navFormateur.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navApprenant.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            usersVBox.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navSecretaire.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));

        });


        Label label3 = new Label("Formateur");
        label3.setFont(Font.font("Tw Cen MT",18));
        navFormateur.getChildren().add(label3);
        navFormateur.setOnMouseClicked(e6->{
            navAdmin.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navSecretaire.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navApprenant.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navFormateur.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));
            usersVBox.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));

        });

        Label label4 = new Label("Apprenant");
        label4.setFont(Font.font("Tw Cen MT",18));
        navApprenant.getChildren().add(label4);
        navApprenant.setOnMouseClicked(e6->{
            navAdmin.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navFormateur.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navSecretaire.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            navApprenant.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));
            usersVBox.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));

        });


        utilisateurDAO= new UtilisateurDAO();
        HBox1.setMinHeight(200);


        /************************
         * Utilisateurs Table
         * ************************/

        TableView<Utilisateur> utilisateursTable = new TableView<Utilisateur>();
//        utilisateursTable.setMinHeight(150);

       //colomn id
        TableColumn<Utilisateur, Integer> id = new TableColumn<>();
        id.setMinWidth(38);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setText("ID");

        //colomn Username
        TableColumn<Utilisateur, String> Username = new TableColumn<>();
        Username.setMinWidth(38);
        Username.setCellValueFactory(new PropertyValueFactory<>("userName"));
        Username.setText("Username");

        //colomn Nom
        TableColumn<Utilisateur, String> Nom = new TableColumn<>();
        Nom.setMinWidth(38);
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Nom.setText("Nom");

        //colomn Prénom
        TableColumn<Utilisateur, String> Prenom = new TableColumn<>();
        Prenom.setMinWidth(38);
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Prenom.setText("Prénom");

        //colomn Role
        TableColumn<Utilisateur, String> role = new TableColumn<>();
        role.setMinWidth(38);
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        role.setText("Role");





        utilisateursTable.setItems(utilisateurDAO.getAll());
        utilisateursTable.getColumns().addAll(id, Username, Nom, Prenom, role);
        HBox1.getChildren().add(utilisateursTable);

        /************************
         * Utilisateurs Table END
         * ************************/




        /************************
         * CRUD
         * ************************/

        //Images
        Image addImage = new Image(getClass().getResource("/img/add.png").toString());
        Image updateImage = new Image(getClass().getResource("/img/edit.png").toString());
        Image readImage = new Image(getClass().getResource("/img/search.png").toString());
        Image deleteImage = new Image(getClass().getResource("/img/delete-forever.png").toString());

//        Images View 1 + configuration
        ImageView addIV = new ImageView(addImage);
        addIV.setCursor(Cursor.HAND);
        addIV.setFitWidth(50);
        addIV.setFitHeight(50);
        //Event animation
        addIV.setOnMousePressed(e2->{
            addIV.setScaleX(0.8);
            addIV.setScaleY(0.8);
        });
        addIV.setOnMouseReleased(e2->{
            addIV.setScaleX(1);
            addIV.setScaleY(1);
        });

        /************************
         * Event add
         * ************************/
        addIV.setOnMouseClicked(e3->{
            addUtilisateur();
        });

//        Images View 2 + configuration
        ImageView updateIV = new ImageView(updateImage);
        updateIV.setCursor(Cursor.HAND);
        updateIV.setFitWidth(50);
        updateIV.setFitHeight(50);
        //Event animation
        updateIV.setOnMousePressed(e2->{
            updateIV.setScaleX(0.8);
            updateIV.setScaleY(0.8);
        });
        updateIV.setOnMouseReleased(e2->{
            updateIV.setScaleX(1);
            updateIV.setScaleY(1);
        });


        /************************
         * Event Update
         * ************************/
        updateIV.setOnMouseClicked(e3->{
            //Table values
            int updateId = utilisateursTable.getSelectionModel().getSelectedItem().getId();
            String updateUsername = utilisateursTable.getSelectionModel().getSelectedItem().getUserName();
            String updateNom = utilisateursTable.getSelectionModel().getSelectedItem().getNom();
            String updatePrenom = utilisateursTable.getSelectionModel().getSelectedItem().getPrenom();
            String updatePwd = utilisateursTable.getSelectionModel().getSelectedItem().getPwd();
            String updateRole = utilisateursTable.getSelectionModel().getSelectedItem().getRole();

            Utilisateur utilisateur = new Utilisateur(updateId,updateUsername,updateNom,updatePrenom,updatePwd,updateRole);

            //Instanciate field
            VBox UsernameVB = new VBox();
            Label UsernameLabel = new Label("Username:");
            TextField UsernameInput = new TextField();
            UsernameVB.getChildren().add(UsernameLabel);
            UsernameVB.getChildren().add(UsernameInput);
            UsernameInput.setText(updateUsername);

            VBox nomVB = new VBox();
            Label nomLabel = new Label("Nom:");
            TextField nomInput = new TextField();
            nomVB.getChildren().add(nomLabel);
            nomVB.getChildren().add(nomInput);
            nomInput.setText(updateNom);

            VBox prenomVB = new VBox();
            Label prenomLabel = new Label("Prénom:");
            TextField prenomInput = new TextField();
            prenomVB.getChildren().add(prenomLabel);
            prenomVB.getChildren().add(prenomInput);
            prenomInput.setText(updatePrenom);

            VBox mdpVB = new VBox();
            Label mdpLabel = new Label("Mot de Passe:");
            TextField mdpInput = new TextField();
            mdpVB.getChildren().add(mdpLabel);
            mdpVB.getChildren().add(mdpInput);
            mdpInput.setText(updatePwd);


            VBox roleVB = new VBox();
            Label roleLabel = new Label("Rôle:");
            ObservableList<String> options =
                    FXCollections.observableArrayList(
                            "Admin", "Secretaire", "Formatuer", "Apprenant"

                    );
            ComboBox roleInput = new ComboBox(options);
            roleVB.getChildren().add(roleLabel);
            roleVB.getChildren().add(roleInput);
            roleInput.setValue(updateRole);
            roleVB.setPadding(new Insets(0,0,20,0));

            Button modifbtn = new Button("Modifier");

            modifbtn.setOnAction(e4->{

                try {
                    utilisateurDAO.update(utilisateur, new String[]{UsernameInput.getText(), nomInput.getText(), prenomInput.getText(), mdpInput.getText(), (String) roleInput.getValue()});
                    adminCrud();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            });


            modifVBox = new VBox();
            modifVBox.getChildren().addAll(UsernameVB,nomVB,prenomVB,mdpVB,roleVB,modifbtn);
            modifVBox.setPadding(new Insets(0,0,0,30));


            HBox1.getChildren().add(modifVBox);




        });
        

//        Images View 3 + configuration
        ImageView readIV = new ImageView(readImage);
        readIV.setCursor(Cursor.HAND);
        readIV.setFitWidth(50);
        readIV.setFitHeight(50);
        //Event animation
        readIV.setOnMousePressed(e2->{
            readIV.setScaleX(0.8);
            readIV.setScaleY(0.8);
        });
        readIV.setOnMouseReleased(e2->{
            readIV.setScaleX(1);
            readIV.setScaleY(1);
        });

        /************************
         * Event read
         * ************************/
        readIV.setOnMouseClicked(e3->{

            VBox UsernameVB = new VBox();
            Label UsernameLabel = new Label("Username:");
            TextField UsernameInput = new TextField();
            UsernameVB.getChildren().add(UsernameLabel);
            UsernameVB.getChildren().add(UsernameInput);
            UsernameVB.getChildren().add(new Label());
            UsernameVB.setPadding(new Insets(0,30,0,0));
            HBox1.getChildren().add(0, UsernameVB);

            Button searchButton = new Button("Search");
            UsernameVB.getChildren().add(searchButton);
            searchButton.setOnAction(e5->{
                utilisateursTable.setItems(utilisateurDAO.get(UsernameInput.getText()));
            });



        });

//        Images View 4 + configuration
        ImageView deleteIV = new ImageView(deleteImage);
        deleteIV.setCursor(Cursor.HAND);
        deleteIV.setFitWidth(50);
        deleteIV.setFitHeight(50);
        //Event animation
        deleteIV.setOnMousePressed(e2->{
            deleteIV.setScaleX(0.8);
            deleteIV.setScaleY(0.8);
        });
        deleteIV.setOnMouseReleased(e2->{
            deleteIV.setScaleX(1);
            deleteIV.setScaleY(1);
        });
        /************************
         * Event delete
         * ************************/
        deleteIV.setOnMouseClicked(e3->{
            int deleteId = utilisateursTable.getSelectionModel().getSelectedItem().getId();
            String deleteUsername = utilisateursTable.getSelectionModel().getSelectedItem().getUserName();
            String deleteNom = utilisateursTable.getSelectionModel().getSelectedItem().getNom();
            String deletePrenom = utilisateursTable.getSelectionModel().getSelectedItem().getPrenom();
            String deletePwd = utilisateursTable.getSelectionModel().getSelectedItem().getPwd();
            String deleteRole = utilisateursTable.getSelectionModel().getSelectedItem().getRole();


            Utilisateur utilisateur = new Utilisateur(deleteId, deleteUsername, deleteNom, deletePrenom, deletePwd,deleteRole);
            try {
                utilisateurDAO.delete(utilisateur);
                adminCrud();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }

        });
        
        
        HBox2.getChildren().add(addIV);
        HBox2.getChildren().add(new Label("     "));
        HBox2.getChildren().add(readIV);
        HBox2.getChildren().add(new Label("     "));
        HBox2.getChildren().add(updateIV);
        HBox2.getChildren().add(new Label("     "));
        HBox2.getChildren().add(deleteIV);


    }



    @FXML
    private void addUtilisateur(){

        //Clear VBox
        buttonsVBox.getChildren().clear();
        buttonsVBox.setPrefWidth(200);

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
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Admin", "Secretaire", "Formatuer", "Apprenant"

                );
        ComboBox roleInput = new ComboBox(options);
        roleVB.getChildren().add(roleLabel);
        roleVB.getChildren().add(roleInput);

        Button addbtn = new Button("Ajouter");

        //The add Utulisateur Action
        addbtn.setOnAction(e1->{
            utilisateurDAO= new UtilisateurDAO();
            Utilisateur utilisateur = new Utilisateur(0,UsernameInput.getText(),nomInput.getText(),prenomInput.getText(),mdpInput.getText(), (String) roleInput.getValue());

            System.out.println(UsernameInput.getText());
            System.out.println(utilisateur.getRole());

            utilisateurDAO.add(utilisateur);


        });

        //Filling the VBox
        buttonsVBox.getChildren().addAll(UsernameVB,nomVB,prenomVB,mdpVB,roleVB,addbtn);

    }

    @FXML
    private void getUtilisateurs() throws SQLException {
//        HBox1.getChildren().add(putTable());

    }

    @FXML
    private void updateUtilisateur(){

    }
    @FXML
    private void deleteUtilisateur(){

    }

    @FXML
    private void logout() throws IOException {
        Main.setRoot("login");
    }
}
