package ma.youcode.gestiona;

import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import ma.youcode.gestiona.ImpDAO.*;
import ma.youcode.gestiona.Modeles.Admin;
import ma.youcode.gestiona.Modeles.Formateur;
import ma.youcode.gestiona.Modeles.FormateurApprenants;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class AdminController implements Initializable {
    Preferences preferences = Preferences.userNodeForPackage(getClass());

    //Implimentation instanciation

    AdminAdminDAO utilisateurDAO;
    UtilisateurAdminDAO utilisateurAdminDAO;
    FormateurApprenantDAO formateurApprenantDAO;
    FormateurDAOImp formateurDAOImp;
    AdminAdminDAO adminDAO;
    SecretaireAdminDAO secretaireDAO;
    FormateurAdminDAO formateurDAO;

    VBox modifVBox;

    Popup popup = new Popup();



    @FXML
    private HBox HBox1;
    @FXML
    private HBox behindBG;
    @FXML
    private HBox acceuilBtn;
    @FXML
    private HBox tablesBtn;
    @FXML
    private HBox classesBtn;
    @FXML
    private HBox promotionBtn;
    @FXML
    private HBox HBox2;
    @FXML
    private HBox navbar;
    @FXML
    private VBox adminCenterBox;
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
    private Label greeting;




    @FXML
    private void adminCrud() throws SQLException {

        behindBG.setBackground(new Background(new BackgroundFill(Color.rgb(5, 141, 254), CornerRadii.EMPTY,Insets.EMPTY)));
        navbar.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));

        acceuilBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
        classesBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
        promotionBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
        tablesBtn.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));
        acceuilBtn.setOnMouseClicked(e->{
            try {
                Main.setRoot("admin");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        adminCenterBox.setBackground(new Background(new BackgroundFill(Color.rgb(5, 141, 254), CornerRadii.EMPTY,Insets.EMPTY)));
//        buttonsVBox.setBackground(new Background(new BackgroundFill(Color.rgb(5, 141, 254), CornerRadii.EMPTY,Insets.EMPTY)));
        navbar.setPadding(new Insets(25,0,25,0));
        HBox1.getChildren().clear();
        HBox2.getChildren().clear();
        usersVBox.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));

        Label label0 = new Label("Utilisateurs");
        label0.setFont(Font.font("Tw Cen MT",18));
        if (usersVBox.getChildren().isEmpty()){
            usersVBox.getChildren().add(label0);

        }


        Label label1 = new Label("Admin");
        label1.setFont(Font.font("Tw Cen MT",18));
        if (navAdmin.getChildren().isEmpty()){
            navAdmin.getChildren().add(label1);
        }





        Label label2 = new Label("Secretaire");
        label2.setFont(Font.font("Tw Cen MT",18));
        if (navSecretaire.getChildren().isEmpty()){
            navSecretaire.getChildren().add(label2);

        }



        Label label3 = new Label("Formateur");
        label3.setFont(Font.font("Tw Cen MT",18));
        if (navFormateur.getChildren().isEmpty()){
            navFormateur.getChildren().add(label3);

        }


        Label label4 = new Label("Apprenant");
        label4.setFont(Font.font("Tw Cen MT",18));
        if (navApprenant.getChildren().isEmpty()){
            navApprenant.getChildren().add(label4);
        }



        utilisateurDAO= new AdminAdminDAO();
        HBox1.setMinHeight(400);


        /************************
         * Utilisateurs Table
         * ************************/

        TableView<Admin> utilisateursTable = new TableView<Admin>();
        utilisateursTable.setMinHeight(250);
        utilisateursTable.setMaxWidth(690);


       //colomn id
        TableColumn<Admin, Integer> id = new TableColumn<>();
        id.setMinWidth(40);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setText("ID");

        //colomn Username
        TableColumn<Admin, String> Username = new TableColumn<>();
        Username.setMinWidth(150);
        Username.setCellValueFactory(new PropertyValueFactory<>("userName"));
        Username.setText("Username");

        //colomn Nom
        TableColumn<Admin, String> Nom = new TableColumn<>();
        Nom.setMinWidth(200);
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Nom.setText("Nom");

        //colomn Prénom
        TableColumn<Admin, String> Prenom = new TableColumn<>();
        Prenom.setMinWidth(150);
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Prenom.setText("Prénom");

        //colomn Role
        TableColumn<Admin, String> role = new TableColumn<>();
        role.setMinWidth(150);
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        role.setText("Role");



        utilisateursTable.setItems(utilisateurDAO.getAll());
        usersVBox.setOnMouseClicked(e6->{
            try {
                utilisateursTable.setItems(utilisateurDAO.getAll());
                navSecretaire.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navFormateur.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navApprenant.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navAdmin.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                usersVBox.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));
            } catch (SQLException exception) {
                exception.printStackTrace();
            }



        });

        navSecretaire.setOnMouseClicked(e->{
            try {
                utilisateursTable.setItems(utilisateurDAO.getAll("Secretaire"));
                navAdmin.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navFormateur.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navApprenant.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                usersVBox.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navSecretaire.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));
            } catch (SQLException exception) {
                exception.printStackTrace();
            }

        });
        navFormateur.setOnMouseClicked(e->{
            try {
                utilisateursTable.setItems(utilisateurDAO.getAll("Formateur"));
                navAdmin.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navSecretaire.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navApprenant.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navFormateur.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));
                usersVBox.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
        navAdmin.setOnMouseClicked(e->{
            try {
                utilisateursTable.setItems(utilisateurDAO.getAll("Admin"));
                navSecretaire.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navFormateur.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navApprenant.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                usersVBox.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navAdmin.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
        navApprenant.setOnMouseClicked(e->{
            try {
                utilisateursTable.setItems(utilisateurDAO.getAll("Apprenant"));
                navAdmin.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navFormateur.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navSecretaire.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
                navApprenant.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));
                usersVBox.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });








        utilisateursTable.getColumns().addAll(id, Username, Nom, Prenom, role);
        HBox1.getChildren().add(utilisateursTable);

        /************************
         * Utilisateurs Table END
         * ************************/




        /**********************************************************************************
         ********************************* CRUD *******************************************
         * ********************************************************************************/

        //Images
        Image addImage = new Image(getClass().getResource("/img/add.png").toString());
        Image updateImage = new Image(getClass().getResource("/img/edit.png").toString());
        Image readImage = new Image(getClass().getResource("/img/search.png").toString());
        Image deleteImage = new Image(getClass().getResource("/img/delete-forever.png").toString());

//        Images View 1 + configuration
        ImageView addIV = new ImageView(addImage);
        Tooltip.install(addIV, new Tooltip("Ajouter"));
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
            final Stage dialog = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("adminPopup.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            dialog.setScene(new Scene(root,500,400));
            dialog.setTitle("Ajouté Apprenant");
            Image icon = new Image(getClass().getResource("/img/add.png").toString());
            dialog.getIcons().add(icon);
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(addIV.getScene().getWindow());
            dialog.showAndWait();

//            addUtilisateur();

        });

//        Images View 2 + configuration
        ImageView updateIV = new ImageView(updateImage);
        Tooltip.install(updateIV, new Tooltip("Modifier (Séléctioné Un Utilisateur Dans Le Tableau)"));
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
            if (!(utilisateursTable.getSelectionModel().getSelectedIndex() <= -1)) {
                //Table values
                int updateId = utilisateursTable.getSelectionModel().getSelectedItem().getId();
                String updateUsername = utilisateursTable.getSelectionModel().getSelectedItem().getUserName();
                String updateNom = utilisateursTable.getSelectionModel().getSelectedItem().getNom();
                String updatePrenom = utilisateursTable.getSelectionModel().getSelectedItem().getPrenom();
                String updatePwd = utilisateursTable.getSelectionModel().getSelectedItem().getPwd();
                String updateRole = utilisateursTable.getSelectionModel().getSelectedItem().getRole();

                Admin utilisateur = new Admin(updateId, updateUsername, updateNom, updatePrenom, updatePwd, updateRole);

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
                                "Admin", "Secretaire", "Formateur", "Apprenant"
                        );
                ComboBox roleInput = new ComboBox(options);
                roleVB.getChildren().add(roleLabel);
                roleVB.getChildren().add(roleInput);
                roleInput.setValue(updateRole);
                roleVB.setPadding(new Insets(0, 0, 20, 0));

                Button modifbtn = new Button("Modifier");
                modifbtn.setCursor(Cursor.HAND);

                modifbtn.setOnAction(e4 -> {

                    try {
                        utilisateurDAO.update(utilisateur, new String[]{UsernameInput.getText(), nomInput.getText(), prenomInput.getText(), mdpInput.getText(), (String) roleInput.getValue()});
                        adminCrud();
                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    }
                });


                modifVBox = new VBox();

                modifVBox.getChildren().addAll(UsernameVB, nomVB, prenomVB, mdpVB, roleVB, modifbtn);
                modifVBox.setPadding(new Insets(0, 0, 0, 30));
                HBox1.getChildren().clear();

                if (HBox1.getChildren().isEmpty()) {
                    try {
                        adminCrud();
                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    }
                    HBox1.getChildren().add(modifVBox);
                } else {
                    System.out.println("cannot");
                }


            }else {
                Label msg = new Label("Séléctioné un utilisateur");
                msg.setStyle(" -fx-background-color: white;");

                popup.getContent().add(msg);
                popup.setY(760);
                popup.setX(1000);
                PauseTransition delay = new PauseTransition(Duration.seconds(2));
                delay.setOnFinished(e -> popup.hide());

                popup.show(updateIV.getScene().getWindow());

                delay.play();

            }




        });


        /************************
         * Event read
         * ************************/

//        Images View 3 + configuration
        ImageView readIV = new ImageView(readImage);
        Tooltip.install(readIV, new Tooltip("Rechercher"));
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



        readIV.setOnMouseClicked(e3->{

            VBox UsernameVB = new VBox();
            Label UsernameLabel = new Label("Username:");
            TextField UsernameInput = new TextField();
            UsernameVB.getChildren().add(UsernameLabel);
            UsernameVB.getChildren().add(UsernameInput);
            UsernameVB.getChildren().add(new Label());
            UsernameVB.setId("UsernameVB");
            UsernameVB.setPadding(new Insets(0,30,0,0));
            if (!(HBox1.getChildren().get(0).getId() == "UsernameVB")) {
                HBox1.getChildren().add(0, UsernameVB);
            }else {
                System.out.println("nooooooooooooo");
            }


            Button searchButton = new Button("Rechercher");
            UsernameVB.getChildren().add(searchButton);
            searchButton.setOnAction(e5->{
                if (!(UsernameInput.getText().equals(""))){
                    utilisateursTable.setItems(utilisateurDAO.get(UsernameInput.getText()));
                    UsernameInput.setText("");
                }else {
                    UsernameVB.getChildren().add(new Label("Valeur Introuvable"));
                }


            });



        });


        /************************
         * Event delete
         * ************************/
//        Images View 4 + configuration
        ImageView deleteIV = new ImageView(deleteImage);
        Tooltip.install(deleteIV, new Tooltip("Supprimer"));
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

        deleteIV.setOnMouseClicked(e3->{
            if (!(utilisateursTable.getSelectionModel().getSelectedIndex() <= -1)){
                int deleteId = utilisateursTable.getSelectionModel().getSelectedItem().getId();
                String deleteUsername = utilisateursTable.getSelectionModel().getSelectedItem().getUserName();
                String deleteNom = utilisateursTable.getSelectionModel().getSelectedItem().getNom();
                String deletePrenom = utilisateursTable.getSelectionModel().getSelectedItem().getPrenom();
                String deletePwd = utilisateursTable.getSelectionModel().getSelectedItem().getPwd();
                String deleteRole = utilisateursTable.getSelectionModel().getSelectedItem().getRole();


                Admin utilisateur = new Admin(deleteId, deleteUsername, deleteNom, deletePrenom, deletePwd,deleteRole);
                try {
                    utilisateurDAO.delete(utilisateur);
                    adminCrud();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }else {

                Label msg = new Label("Séléctioné un utilisateur");
                msg.setStyle(" -fx-background-color: white;");

                popup.getContent().add(msg);
                popup.setY(760);
                popup.setX(1000);
                PauseTransition delay = new PauseTransition(Duration.seconds(2));
                delay.setOnFinished(e -> popup.hide());

                popup.show(deleteIV.getScene().getWindow());

                delay.play();

                System.out.println("Select smtn");
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
    private void logout() throws IOException {
        Main.setRoot("login");
    }
    @FXML
    private void classesCrud() throws IOException {
//        buttonsVBox.getChildren().clear();
        acceuilBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
        tablesBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
        promotionBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
        classesBtn.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));
        adminCenterBox.setBackground(new Background(new BackgroundFill(Color.rgb(5, 141, 254), CornerRadii.EMPTY,Insets.EMPTY)));
//        buttonsVBox.setBackground(new Background(new BackgroundFill(Color.rgb(5, 141, 254), CornerRadii.EMPTY,Insets.EMPTY)));


        acceuilBtn.setOnMouseClicked(e->{
            try {
                Main.setRoot("admin");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
    @FXML
    private void promotionsCrud() throws IOException {
//        buttonsVBox.getChildren().clear();
        acceuilBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
        tablesBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
        classesBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY,Insets.EMPTY)));
        promotionBtn.setBackground(new Background(new BackgroundFill(Color.rgb(244, 245, 219), CornerRadii.EMPTY,Insets.EMPTY)));
//        buttonsVBox.setBackground(new Background(new BackgroundFill(Color.rgb(5, 141, 254), CornerRadii.EMPTY,Insets.EMPTY)));

        acceuilBtn.setOnMouseClicked(e->{
            try {
                Main.setRoot("admin");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    public void greetingAnimation(){
        KeyValue fadeOutBegin = new KeyValue(greeting.opacityProperty(), 0.0);
        KeyValue fadeOutEnd = new KeyValue(greeting.opacityProperty(), 1.0);

        KeyValue positBegin = new KeyValue(greeting.translateYProperty(), 5);
        KeyValue positEnd = new KeyValue(greeting.translateYProperty(), 0);

        KeyFrame kfBegin = new KeyFrame(Duration.ZERO, fadeOutBegin,positBegin);
        KeyFrame kfEnd = new KeyFrame(Duration.millis(400), fadeOutEnd,positEnd);

        Timeline tl =new Timeline(kfBegin, kfEnd);

        tl.setDelay(Duration.seconds(0.5));
        tl.play();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        greetingAnimation();

    }
}
