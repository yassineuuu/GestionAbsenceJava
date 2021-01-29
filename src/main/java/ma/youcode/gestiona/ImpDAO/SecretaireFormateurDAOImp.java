package ma.youcode.gestiona.ImpDAO;

import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.SecretaireFormateurDAO;
import ma.youcode.gestiona.Modeles.Formateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecretaireFormateurDAOImp implements SecretaireFormateurDAO<Formateur> {
    @Override
    public Formateur get(int id) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement prep = conn.prepareStatement("SELECT * FROM `formateur` WHERE id_formateur="+id);
        ResultSet result = prep.executeQuery();
        Formateur formateur = null;
        if (result.next()){
            formateur = new Formateur("username","pwd","type",result.getInt("id_formateur"),result.getString("nom_formateur"),result.getString("prenom_formateur"),result.getString("classe"),result.getString("promotion") );
        }
        return formateur;
    }

    @Override
    public ObservableList<Formateur> getAll() {
        return null;
    }

    @Override
    public void save(Formateur formateur) {

    }

    @Override
    public void update(Formateur formateur, String[] params) {

    }

    @Override
    public void delete(Formateur formateur) {

    }
}
