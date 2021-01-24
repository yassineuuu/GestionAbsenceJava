package ma.youcode.gestiona.ImpDAO;

import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.AbsenceDAO;
import ma.youcode.gestiona.Modeles.Absence;

import java.sql.*;
import java.time.LocalDate;

public class AbsenceDAOImp implements AbsenceDAO {
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

    public void insert(Absence absence) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `absence_apprenant`(`id_absence`, `full_name`, `type_absence`, `date_absence`) VALUES (?,?,?,?)");
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,absence.getFull_name());
            preparedStatement.setString(3,absence.getType_absence());
            preparedStatement.setString(4, (absence.getDate_absence()));
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
