package ma.youcode.gestiona.ImpDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Admin;
import ma.youcode.gestiona.Modeles.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AdminDAO implements DAO<Admin> {
    @Override
    public ObservableList<Admin> get(String Username) {

        Connection conn = null;
        ObservableList<Admin> utilisateursList = FXCollections.observableArrayList();

        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `utilisateurs` WHERE Username ='" + Username +"'");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Utilisateur utilisateur = new Admin(resultSet.getInt("id"), resultSet.getString("Username"), resultSet.getString("Nom"),
                        resultSet.getString("Prenom"), resultSet.getString("MDP"), resultSet.getString("Role"));
                utilisateursList.add((Admin) utilisateur);
                       System.out.println(utilisateur.getUserName());

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
    public void add(Admin admin) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `utilisateurs`(`Username`, `Nom`, `Prenom`, `MDP`, `Role`) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,admin.getUserName());
            preparedStatement.setString(2,admin.getNom());
            preparedStatement.setString(3,admin.getPrenom());
            preparedStatement.setString(4,admin.getPwd());
            preparedStatement.setString(5,admin.getRole());

            int resultSet = preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public ObservableList<Admin> getAll() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `utilisateurs`");
        ResultSet resultSet = preparedStatement.executeQuery();

        ObservableList<Admin> utilisateursList = FXCollections.observableArrayList();

        try{
            while (resultSet.next()){
                Utilisateur utilisateur = new Admin(resultSet.getInt("id"), resultSet.getString("Username"), resultSet.getString("Nom"),
                        resultSet.getString("Prenom"), resultSet.getString("MDP"), resultSet.getString("Role"));
                utilisateursList.add((Admin) utilisateur);
//                       System.out.println(utilisateur.getUserName());

            }
            resultSet.close();
            preparedStatement.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }


        return utilisateursList;
    }


    public ObservableList<Admin> getAll(String role) throws SQLException {


        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `utilisateurs`WHERE Role = '"+role+"'");
        ResultSet resultSet = preparedStatement.executeQuery();

        ObservableList<Admin> utilisateursList = FXCollections.observableArrayList();

        try{
            while (resultSet.next()){
                Utilisateur utilisateur = new Admin(resultSet.getInt("id"), resultSet.getString("Username"), resultSet.getString("Nom"),
                        resultSet.getString("Prenom"), resultSet.getString("MDP"), resultSet.getString("Role"));
                utilisateursList.add((Admin) utilisateur);
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
    public void save(Admin admin) {

    }

    @Override
    public void update(Admin admin, String[] params) {

        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE `utilisateurs` SET `Username`=?,`Nom`=?,`Prenom`=?,`MDP`=?,`Role`=? WHERE id="+admin.getId());

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
    public void delete(Admin admin) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM utilisateurs WHERE id =" + admin.getId());
        try {
            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
