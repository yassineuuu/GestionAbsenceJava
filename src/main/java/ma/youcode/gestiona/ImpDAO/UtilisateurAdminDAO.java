package ma.youcode.gestiona.ImpDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.AdminDAO;
import ma.youcode.gestiona.Modeles.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurAdminDAO implements AdminDAO<Utilisateur> {
    @Override
    public ObservableList<Utilisateur> get(String Username) {
        Connection conn = null;
        ObservableList<Utilisateur> utilisateursList = FXCollections.observableArrayList();

        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `utilisateurs` WHERE Username ='" + Username +"'");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Utilisateur utilisateur = new Utilisateur(resultSet.getInt("id"), resultSet.getString("Username"), resultSet.getString("Nom"),
                        resultSet.getString("Prenom"), resultSet.getString("MDP"), resultSet.getString("Role"));
                utilisateursList.add(utilisateur);
            }
            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return utilisateursList;
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
                       Utilisateur utilisateur = new Utilisateur(resultSet.getInt("id"), resultSet.getString("Username"), resultSet.getString("Nom"),
                               resultSet.getString("Prenom"), resultSet.getString("MDP"), resultSet.getString("Role"));
                       utilisateursList.add(utilisateur);
//                       System.out.println(utilisateur.getUserName());

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

        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE `utilisateurs` SET `Username`=?,`Nom`=?,`Prenom`=?,`MDP`=?,`Role`=? WHERE id="+utilisateur.getId());

            preparedStatement.setString(1,params[0]);
            preparedStatement.setString(2,params[1]);
            preparedStatement.setString(3,params[2]);
            preparedStatement.setString(4,params[3]);
            preparedStatement.setString(5,params[4]);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }



    }

    @Override
    public void delete(Utilisateur utilisateur) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM utilisateurs WHERE id =" + utilisateur.getId());
        try {
            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
