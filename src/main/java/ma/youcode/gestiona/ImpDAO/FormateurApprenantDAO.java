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
            formateurApprenants = new FormateurApprenants("Username", "pwd", "Role", result.getInt("id_apprenant"), result.getString("nom_apprenant"), result.getString("prenom_apprenant"), result.getInt("id_formateur"), result.getString("classe"), result.getString("promotion"));
            listApprenant.add(formateurApprenants);
        }
        return listApprenant;

    }


    @Override
    public void save(FormateurApprenants formateurApprenants) {


    }
    public void save(FormateurApprenants formateurApprenants,int id){

        try {
            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `apprenants`(`id_utilisateur`, `nom_apprenant`, `prenom_apprenant`, `classe`, `promotion`,`id_formateur`) VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,formateurApprenants.getNom_apprenant());
            preparedStatement.setString(3,formateurApprenants.getPrenom_apprenant());
            preparedStatement.setString(4,formateurApprenants.getClasse());
            preparedStatement.setString(5,formateurApprenants.getPromotion());
            preparedStatement.setInt(6,formateurApprenants.getId_formateur());



            int resultSet = preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void update(FormateurApprenants formateurApprenants, String[] params) {

    }

    @Override
    public void delete(FormateurApprenants formateurApprenants) {

    }
}
