package ma.youcode.gestiona.ImpDAO;

import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.AbsenceDAO;
import ma.youcode.gestiona.Modeles.ClasseAbsence;

import java.sql.*;

public class FormateurAbsenceDAOImp implements AbsenceDAO {
    @Override
    public ObservableList get(int id) throws SQLException {
        return null;
    }

    @Override
    public ObservableList getAll() throws SQLException {
        return null;
    }

    @Override
    public void insert() {

    }

    public void insert(ClasseAbsence classeAbsence) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `absences`(`id`, `nom`, `prenom`, `absence`, `date`) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2, classeAbsence.getNom());
            preparedStatement.setString(3, classeAbsence.getPrenom());
            preparedStatement.setString(4, classeAbsence.getType_absence());
            preparedStatement.setString(5, (classeAbsence.getDate_absence()));
            int resultSet = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
