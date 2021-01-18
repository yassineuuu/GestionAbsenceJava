package ma.youcode.gestiona.ImpDAO;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UtilisateurDAO implements DAO<Utilisateur> {
    @Override
    public Optional<Utilisateur> get(int id) {
        return Optional.empty();
    }

    @Override
    public void add(Utilisateur utilisateur) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `utilisateurs`(`Username`, `Nom`, `Prenom`, `MDP`, `Role`) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,utilisateur.getUserName());
            preparedStatement.setString(2,utilisateur.getNom());
            preparedStatement.setString(3,utilisateur.getPrenom());
            preparedStatement.setString(4,utilisateur.getPwd());
            preparedStatement.setString(5,utilisateur.getRole());

            int resultSet = preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public ObservableList<Utilisateur> getAll() throws SQLException {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `utilisateurs`");
        ResultSet resultSet = preparedStatement.executeQuery();

        ObservableList<Utilisateur> utilisateursList = FXCollections.observableArrayList();

               try{
                   while (resultSet.next()){
                       Utilisateur utilisateur = new Utilisateur(resultSet.getString("Username"), resultSet.getString("Nom"),resultSet.getString("Prenom"), resultSet.getString("MDP"), resultSet.getString("Role"));
                       utilisateursList.add(utilisateur);
                       System.out.println(utilisateur.getUserName());

                   }
                   resultSet.close();
                   preparedStatement.close();
                   conn.close();
               }catch (SQLException e){
                        e.printStackTrace();
               }



            return utilisateursList;

    };

    @Override
    public void save(Utilisateur utilisateur) {

    }

    @Override
    public void update(Utilisateur utilisateur, String[] params) {

    }

    @Override
    public void delete(Utilisateur utilisateur) {

    }
}
