package ma.youcode.gestiona.ImpDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.ApprenantDAO;
import ma.youcode.gestiona.Modeles.Apprenant;

import java.sql.*;
import java.util.Optional;

public class ApprenantDAOImp implements ApprenantDAO<Apprenant> {


    @Override
    public ObservableList<Apprenant> getByName(String nom) {
        ObservableList<Apprenant> etudiantList = FXCollections.observableArrayList();
        //Connexion
        try{
            Connection cnx = ConnectionFactory.getConnection();
            PreparedStatement prepared;
            String query = "SELECT * FROM `etudiants` WHERE EXTRACT(MONTH FROM date)= '"+nom+"'";

            Statement st;
            ResultSet rs;

            try {
                st = cnx.createStatement();
                rs = st.executeQuery(query);
                Apprenant etudiant;
                while (rs.next()) {
                    etudiant = new Apprenant(rs.getInt("id"),rs.getDate("date"),rs.getInt("idapprenant"), rs.getString("nom"),
                            rs.getString("prenom"), rs.getString("classe"),rs.getString("promotion"),
                            rs.getString("absence"), rs.getString("justifier"));
                    etudiantList.add(etudiant);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return etudiantList;
    }

    @Override
    public ObservableList<Apprenant> getEtudiant() {
        return null;
    }


    @Override
    public void save(Apprenant apprenant) {

    }

    @Override
    public void update(Apprenant apprenant, String[] params) {

    }

    @Override
    public void delete(Apprenant apprenant) {

    }
}
