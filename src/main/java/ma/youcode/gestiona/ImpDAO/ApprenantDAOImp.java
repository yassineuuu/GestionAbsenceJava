package ma.youcode.gestiona.ImpDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.ApprenantDAO;
import ma.youcode.gestiona.Modeles.ApprenantApprenant;

import java.sql.*;

public class ApprenantDAOImp implements ApprenantDAO<ApprenantApprenant> {


    @Override
    public ObservableList<ApprenantApprenant> getByName(int id) {

        ObservableList<ApprenantApprenant> etudiantList = FXCollections.observableArrayList();
        //Connexion
        try{
            Connection cnx = ConnectionFactory.getConnection();
            PreparedStatement prepared;
            String query = "SELECT * FROM `absences` WHERE idApprenant = "+ id ;

            Statement st;
            ResultSet rs;

            try {
                st = cnx.createStatement();
                rs = st.executeQuery(query);
                ApprenantApprenant etudiant;
                while (rs.next()) {
                    etudiant = new ApprenantApprenant(rs.getInt("id"),rs.getDate("date"),rs.getInt("idapprenant"), rs.getString("nom"),
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

    public ObservableList<ApprenantApprenant> getByName(String mois, int id) {

        ObservableList<ApprenantApprenant> etudiantList = FXCollections.observableArrayList();
        //Connexion
        try{
            Connection cnx = ConnectionFactory.getConnection();
            PreparedStatement prepared;
            String query = "SELECT * FROM `absences` WHERE idApprenant = "+ id +" && EXTRACT(MONTH FROM date)= '"+mois+"'";

            Statement st;
            ResultSet rs;

            try {
                st = cnx.createStatement();
                rs = st.executeQuery(query);
                ApprenantApprenant etudiant;
                while (rs.next()) {
                    etudiant = new ApprenantApprenant(rs.getInt("id"),rs.getDate("date"),rs.getInt("idapprenant"), rs.getString("nom"),
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
    public ObservableList<ApprenantApprenant> getEtudiant() {
        return null;
    }


    @Override
    public void save(ApprenantApprenant apprenantApprenant) {

    }

    @Override
    public void update(ApprenantApprenant apprenantApprenant, String[] params) {

    }

    @Override
    public void delete(ApprenantApprenant apprenantApprenant) {

    }
}
