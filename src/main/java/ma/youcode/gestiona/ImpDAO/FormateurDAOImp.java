package ma.youcode.gestiona.ImpDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.FormateurDAO;
import ma.youcode.gestiona.Modeles.Formateur;
import ma.youcode.gestiona.Modeles.FormateurApprenants;
import ma.youcode.gestiona.Modeles.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormateurDAOImp implements FormateurDAO<Formateur> {
    @Override
    public Formateur get(int id) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement prep = conn.prepareStatement("SELECT * FROM `formateurs` WHERE id_formateur ="+id);
        ResultSet result = prep.executeQuery();
        Formateur formateur = null;
        if (result.next()){
            formateur = new Formateur("username","pwd","type",result.getInt("id_formateur"),result.getString("nom_formateur"),result.getString("prenom_formateur"),result.getString("classe"),result.getString("promotion") );
        }
        return formateur;
    }
    public Formateur getId_utilisateurs(int id_utilisateurs) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement prep = conn.prepareStatement("SELECT * FROM `formateurs` WHERE id_utilisateurs ="+id_utilisateurs+"");
        ResultSet result = prep.executeQuery();
        Formateur formateur = null;
        if (result.next()){
            formateur = new Formateur("username","pwd","type",result.getInt("id_formateur"),result.getString("nom_formateur"),result.getString("prenom_formateur"),result.getString("classe"),result.getString("promotion") );
        }
        return formateur;
    }

    @Override
    public ObservableList<Formateur> getAll() throws SQLException {
        ObservableList<Formateur> formateurList = FXCollections.observableArrayList();

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement prep = conn.prepareStatement("SELECT * FROM `formateurs`");
        ResultSet result = prep.executeQuery();
        Formateur formateur = null;
        while (result.next()){
            formateur = new Formateur(result.getInt("id_formateur"),result.getString("nom_formateur"),result.getString("prenom_formateur"),result.getString("classe"),result.getString("promotion") );
            formateurList.add(formateur);
        }
        result.close();
        prep.close();
        conn.close();
        return formateurList;
    }

    @Override
    public void save(Formateur formateur) {

    }
    public void save(Formateur formateur, int id){

        try {
            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `formateurs`(`id_utilisateurs`, `nom_formateur`, `prenom_formateur`, `classe`, `promotion`) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,formateur.getNom_formateur());
            preparedStatement.setString(3,formateur.getPrenom_formateur());
            preparedStatement.setString(4,formateur.getClasse());
            preparedStatement.setString(5,formateur.getPromotion());



            int resultSet = preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }


    @Override
    public void update(Formateur formateur, String[] params) {

    }

    @Override
    public void delete(Formateur formateur) {

    }
}
