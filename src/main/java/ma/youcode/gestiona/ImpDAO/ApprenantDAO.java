package ma.youcode.gestiona.ImpDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Apprenant;
import ma.youcode.gestiona.Modeles.ApprenantApprenant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ApprenantDAO implements DAO<Apprenant> {
    @Override
    public Optional<Apprenant> get(int id) {
        return Optional.empty();

    }

    @Override
    public ObservableList<Apprenant> getAll() throws SQLException {
        ObservableList list = FXCollections.observableArrayList();
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `apprenants`");
        ResultSet resultSet = preparedStatement.executeQuery();
        ApprenantApprenant apprenant;
        while (resultSet.next()){
            apprenant = new ApprenantApprenant(resultSet.getInt("id_apprenant"), resultSet.getInt("id_utilisateur"), resultSet.getString("nom_apprenant"), resultSet.getString("prenom_apprenant"),
                    resultSet.getInt("id_formateur"),resultSet.getString("classe"), resultSet.getString("promotion"));
            list.add(apprenant);
        }
        return list;

    }

    public ObservableList<ApprenantApprenant> getAll(int id) throws SQLException {
        ObservableList list = FXCollections.observableArrayList();

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `apprenants` WHERE id_utilisateur="+id);
        ResultSet resultSet = preparedStatement.executeQuery();
        ApprenantApprenant apprenant;
        while (resultSet.next()){
            apprenant = new ApprenantApprenant(resultSet.getInt("id_apprenant"), resultSet.getInt("id_utilisateur"), resultSet.getString("nom_apprenant"), resultSet.getString("prenom_apprenant"),
                    resultSet.getInt("id_formateur"),resultSet.getString("classe"), resultSet.getString("promotion"));
            list.add(apprenant);
        }
        return list;

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
