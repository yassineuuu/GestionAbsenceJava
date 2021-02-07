package ma.youcode.gestiona.ImpDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Apprenant;
import ma.youcode.gestiona.Modeles.ClasseAbsence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SecretaireApprenantDAO implements DAO<Apprenant> {
    @Override
    public Optional<Apprenant> get(int id) {
        return Optional.empty();
    }

    @Override
    public ObservableList<Apprenant> getAll(){


        ObservableList<Apprenant> list = FXCollections.observableArrayList();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from absences");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Apprenant("", "", "", Integer.parseInt(rs.getString("id")), rs.getString("nom"), rs.getString("classe"), rs.getString("promotion"), rs.getString("absence"), rs.getString("justifier")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ObservableList<ClasseAbsence> getAllCA(){


        ObservableList<ClasseAbsence> list = FXCollections.observableArrayList();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from absences");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new ClasseAbsence(rs.getInt("id"), rs.getString("prenom"), rs.getString("nom"), rs.getString("classe"), rs.getString("promotion"), rs.getString("absence"), rs.getString("date"), rs.getString("justifier")));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ObservableList<ClasseAbsence> getAll(String date){


        ObservableList<ClasseAbsence> list = FXCollections.observableArrayList();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from absences WHERE date = '"+date+"'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new ClasseAbsence(rs.getInt("id"), rs.getString("prenom"), rs.getString("nom"), rs.getString("classe"), rs.getString("promotion"), rs.getString("absence"), rs.getString("date"), rs.getString("justifier")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ObservableList<Apprenant> getAll(int secretaire) throws SQLException {

        Connection conn = ConnectionFactory.getConnection();
        ObservableList<Apprenant> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from absences");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Apprenant("", "", "", Integer.parseInt(rs.getString("id")), rs.getString("nom"), rs.getString("classe"), rs.getString("promotion"), rs.getString("absence"), rs.getString("justifier")));
            }
        } catch (Exception e) {
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
