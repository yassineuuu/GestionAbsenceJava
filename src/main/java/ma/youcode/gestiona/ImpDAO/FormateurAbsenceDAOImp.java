package ma.youcode.gestiona.ImpDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.AbsenceDAO;
import ma.youcode.gestiona.Modeles.ClasseAbsence;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class FormateurAbsenceDAOImp implements AbsenceDAO {
    @Override
    public ObservableList get(int id) throws SQLException {
        return null;
    }

    @Override
    public ObservableList getAll() throws SQLException {
        return null;
    }
    public ObservableList getAll(String nom, String prenom) throws SQLException {
        ObservableList absenceList = FXCollections.observableArrayList();
        java.util.Date aujourdhui = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("MM");
        String newstring = DateFor.format(aujourdhui);

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `absences` WHERE nom = '"+nom+"' && prenom='"+prenom+"' && EXTRACT(MONTH FROM date) = "+newstring+"");
        ResultSet resultSet = preparedStatement.executeQuery();
        ClasseAbsence Absence;

        while (resultSet.next()){
            Absence = new ClasseAbsence(resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getString("absence"), resultSet.getString("date"));
            absenceList.add(Absence);
        }

        return absenceList;

    }

    @Override
    public void insert() {

    }

    public void insert(ClasseAbsence classeAbsence) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `absences`(`id`, `nom`, `prenom`, `absence`, `date`, `classe`, `promotion`, `idapprenant`, `id_formateur`) VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2, classeAbsence.getNom());
            preparedStatement.setString(3, classeAbsence.getPrenom());
            preparedStatement.setString(4, classeAbsence.getType_absence());
            preparedStatement.setString(5, (classeAbsence.getDate_absence()));
            preparedStatement.setString(6, (classeAbsence.getClasse()));
            preparedStatement.setString(7, (classeAbsence.getPromotion()));
            preparedStatement.setInt(8, (classeAbsence.getId_user()));
            preparedStatement.setInt(9, (classeAbsence.getId_formateur()));
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
    public void delete(String justifier) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM `absences` WHERE justifier ='"+justifier+"'");
        int resultSet = preparedStatement.executeUpdate();

    }
}
