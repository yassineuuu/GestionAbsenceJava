package ma.youcode.gestiona.ImpDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Apprenant;

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

        return null;
    }

    public ObservableList<Apprenant> getAll(int id_formateur) throws SQLException {

        ObservableList listApprenant = FXCollections.observableArrayList();

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement prep = conn.prepareStatement("SELECT * FROM `apprenant` WHERE id_formateur ="+id_formateur);
        ResultSet result = prep.executeQuery();
        Apprenant apprenant;
        while (result.next()){
            apprenant = new Apprenant("Username", "pwd", "type", result.getInt("id_apprenant"), result.getString("nom_apprenant"), result.getString("prenom_apprenant"), result.getInt("id_formateur"));
            listApprenant.add(apprenant);
        }
        return listApprenant;

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
