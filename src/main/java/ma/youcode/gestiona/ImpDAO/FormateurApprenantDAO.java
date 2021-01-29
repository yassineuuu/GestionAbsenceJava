package ma.youcode.gestiona.ImpDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.FormateurApprenants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class FormateurApprenantDAO implements DAO<FormateurApprenants> {
    @Override
    public Optional<FormateurApprenants> get(int id) {
        return Optional.empty();
    }

    @Override
    public ObservableList<FormateurApprenants> getAll() {

        return null;
    }

    public ObservableList<FormateurApprenants> getAll(int id_formateur) throws SQLException {

        ObservableList listApprenant = FXCollections.observableArrayList();

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement prep = conn.prepareStatement("SELECT * FROM `apprenants` WHERE id_formateur ="+id_formateur);
        ResultSet result = prep.executeQuery();
        FormateurApprenants formateurApprenants;
        while (result.next()){
            formateurApprenants = new FormateurApprenants("Username", "pwd", "type", result.getInt("id_apprenant"), result.getString("nom_apprenant"), result.getString("prenom_apprenant"), result.getInt("id_formateur"));
            listApprenant.add(formateurApprenants);
        }
        return listApprenant;

    }


    @Override
    public void save(FormateurApprenants formateurApprenants) {

    }

    @Override
    public void update(FormateurApprenants formateurApprenants, String[] params) {

    }

    @Override
    public void delete(FormateurApprenants formateurApprenants) {

    }
}
