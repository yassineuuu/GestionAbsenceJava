package ma.youcode.gestiona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import ma.youcode.gestiona.ImpDAO.AdminAdminDAO;
import ma.youcode.gestiona.ImpDAO.FormateurApprenantDAO;
import ma.youcode.gestiona.ImpDAO.FormateurDAOImp;
import ma.youcode.gestiona.ImpDAO.UtilisateurAdminDAO;
import ma.youcode.gestiona.Modeles.Admin;
import ma.youcode.gestiona.Modeles.Formateur;
import ma.youcode.gestiona.Modeles.FormateurApprenants;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminPopupController implements Initializable {

    AdminAdminDAO utilisateurDAO;
    UtilisateurAdminDAO utilisateurAdminDAO;
    FormateurApprenantDAO formateurApprenantDAO;
    FormateurDAOImp formateurDAOImp;

    @FXML
    private VBox buttonsVBox;

    @FXML
    private void addUtilisateur() {

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
        PasswordField mdpInput = new PasswordField();
        mdpVB.getChildren().add(mdpLabel);
        mdpVB.getChildren().add(mdpInput);

        VBox roleVB = new VBox();
        Label roleLabel = new Label("Rôle:");
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Admin", "Secretaire", "Formateur", "Apprenant"

                );
        ComboBox roleInput = new ComboBox(options);
        roleVB.getChildren().add(roleLabel);
        roleVB.getChildren().add(roleInput);

        Button addbtn = new Button("Ajouter");
        addbtn.setCursor(Cursor.HAND);

        //Filling the VBox
        buttonsVBox.getChildren().addAll(UsernameVB, nomVB, prenomVB, mdpVB, roleVB, new Label(), addbtn);

        //The add Utulisateur Action
        addbtn.setOnAction(e1 -> {
            if (UsernameInput.getText() != "" || nomInput.getText() != "" || prenomInput.getText() != "" || mdpInput.getText() != "" || roleInput.getValue() != ""){

                if (UsernameVB.getChildren().size() == 3) {
                    UsernameVB.getChildren().remove(2);
                }
                utilisateurDAO = new AdminAdminDAO();
                formateurDAOImp = new FormateurDAOImp();
                utilisateurAdminDAO = new UtilisateurAdminDAO();
                Admin utilisateur = new Admin(0, UsernameInput.getText(), nomInput.getText(), prenomInput.getText(), mdpInput.getText(), (String) roleInput.getValue());
                if (utilisateurAdminDAO.get(UsernameInput.getText()).size() == 1) {
                    Label msg = new Label("Utilisateur déja éxist");
                    msg.setFont(Font.font("Tw Cen MT", 14));
                    msg.setTextFill(Color.RED);
                    if (UsernameVB.getChildren().size() == 2) {
                        UsernameVB.getChildren().add(msg);
                    }
                } else {
                    utilisateurDAO.add(utilisateur);
                    ObservableList<String> promoList = FXCollections.observableArrayList(
                            "2020", "2021"
                    );
                    ObservableList<String> classeList = FXCollections.observableArrayList(
                            "JEE", "C#", "FEBE", "Classe1", "Classe2", "Classe3", "Classe4"
                    );

                    /***************Si le role est Apprenant*******************/

                    if (roleInput.getValue().equals("Apprenant")) {


                        VBox promoVB = new VBox();
                        Label promoLabel = new Label("Promotion:");
                        ComboBox promoInput = new ComboBox(promoList);
                        promoVB.getChildren().add(promoLabel);
                        promoVB.getChildren().add(promoInput);


                        VBox classeVB = new VBox();
                        Label classeLabel = new Label("Classe:");
                        ComboBox classeInput = new ComboBox(classeList);
                        classeVB.getChildren().add(classeLabel);
                        classeVB.getChildren().add(classeInput);

                        VBox formateurVB = new VBox();
                        Label formaeurLabel = new Label("Formateur_Id:");
                        ComboBox formateurInput = new ComboBox();

                        try {
                            for (int i = 0; i < formateurDAOImp.getAll().size(); i++) {
                                formateurInput.getItems().add(formateurDAOImp.getAll().get(i).getId_formateur());
                            }
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                        formateurVB.getChildren().add(formaeurLabel);
                        formateurVB.getChildren().add(formateurInput);
                        formateurInput.setOnAction((e) -> {
                            try {
                                if (formateurVB.getChildren().size() == 2) {
                                    formateurVB.getChildren().add(new Label(formateurDAOImp.get(Integer.parseInt(String.valueOf(formateurInput.getValue()))).getNom_formateur() + " " + formateurDAOImp.get(Integer.parseInt(String.valueOf(formateurInput.getValue()))).getPrenom_formateur() + " (" + formateurDAOImp.get(Integer.parseInt(String.valueOf(formateurInput.getValue()))).getClasse() + ")"));

                                } else {
                                    formateurVB.getChildren().remove(2);
                                    formateurVB.getChildren().add(new Label(formateurDAOImp.get(Integer.parseInt(String.valueOf(formateurInput.getValue()))).getNom_formateur() + " " + formateurDAOImp.get(Integer.parseInt(String.valueOf(formateurInput.getValue()))).getPrenom_formateur() + " (" + formateurDAOImp.get(Integer.parseInt(String.valueOf(formateurInput.getValue()))).getClasse() + ")"));
                                }
                            } catch (SQLException exception) {
                                exception.printStackTrace();
                            }
                        });


                        Button addappr = new Button("Ajouter Apprenant");
                        addappr.setCursor(Cursor.HAND);

                        buttonsVBox.getChildren().remove(addbtn);
                        buttonsVBox.getChildren().remove(roleVB);
                        buttonsVBox.getChildren().addAll(promoVB, classeVB, formateurVB, new Label(), addappr);
                        utilisateurAdminDAO = new UtilisateurAdminDAO();
                        formateurApprenantDAO = new FormateurApprenantDAO();
                        addappr.setOnAction(e -> {
                            int id_user = utilisateurAdminDAO.get(utilisateur.getUserName()).get(0).getId();
                            System.out.println(utilisateurAdminDAO.get(utilisateur.getUserName()).get(0).getId());
                            FormateurApprenants formateurApprenants = new FormateurApprenants(nomInput.getText(), prenomInput.getText(), Integer.parseInt(String.valueOf(formateurInput.getValue())), String.valueOf(classeInput.getValue()), String.valueOf(promoInput.getValue()));
                            formateurApprenantDAO.save(formateurApprenants, id_user);
                            buttonsVBox.getChildren().add(new Label("Apprenant Ajouté!!"));

                            buttonsVBox.getScene().getWindow().hide();
                            try {
                                Main.setRoot("admin");
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }

                        });


                    }

                    /***************Si le role est Formateur*******************/

                    else if (roleInput.getValue().equals("Formateur")) {

                        VBox promoVB = new VBox();
                        Label promoLabel = new Label("Promotion:");
                        ComboBox promoInput = new ComboBox(promoList);
                        promoVB.getChildren().add(promoLabel);
                        promoVB.getChildren().add(promoInput);

                        VBox classeVB = new VBox();
                        Label classeLabel = new Label("Classe:");
                        ComboBox classeInput = new ComboBox(classeList);
                        classeVB.getChildren().add(classeLabel);
                        classeVB.getChildren().add(classeInput);


                        Button addappr = new Button("Ajouter Formateur");
                        addappr.setCursor(Cursor.HAND);

                        buttonsVBox.getChildren().remove(addbtn);
                        buttonsVBox.getChildren().remove(roleVB);
                        buttonsVBox.getChildren().addAll(promoVB, classeVB, new Label(), addappr);
                        utilisateurAdminDAO = new UtilisateurAdminDAO();
                        formateurDAOImp = new FormateurDAOImp();
                        addappr.setOnAction(e -> {
                            int id_user = utilisateurAdminDAO.get(utilisateur.getUserName()).get(0).getId();
                            System.out.println(utilisateurAdminDAO.get(utilisateur.getUserName()).get(0).getId());
                            Formateur formateur = new Formateur(nomInput.getText(), prenomInput.getText(), String.valueOf(classeInput.getValue()), String.valueOf(promoInput.getValue()));
                            formateurDAOImp.save(formateur, id_user);
                            buttonsVBox.getChildren().add(new Label("Formateur Ajouté!!"));

                            buttonsVBox.getScene().getWindow().hide();
                            try {
                                Main.setRoot("admin");
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }

                        });


                    }else {
                        buttonsVBox.getScene().getWindow().hide();
                        try {
                            Main.setRoot("admin");
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    buttonsVBox.getChildren().add(new Label("Utilisateur  Ajouté!!"));
                }

            }else{
                buttonsVBox.getChildren().add(new Label("vérifie que tous les champs ne sont pas vides"));
            }
        });





    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addUtilisateur();
    }
}
