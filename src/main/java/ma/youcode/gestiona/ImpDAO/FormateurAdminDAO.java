package ma.youcode.gestiona.ImpDAO;

import javafx.collections.ObservableList;
import ma.youcode.gestiona.DAO.AdminDAO;
import ma.youcode.gestiona.Modeles.Formateur;

import java.util.List;

public class FormateurAdminDAO implements AdminDAO<Formateur> {
    @Override
    public ObservableList<Formateur> get(String name) {
//        try {
//            Connection conn = ConnectionFactory.getConnection();
//            PreparedStatement preparedStatement1 = conn.prepareStatement("SELECT * FROM `formateur` WHERE id_formateur = ?");
//            PreparedStatement preparedStatement2 = conn.prepareStatement("SELECT * FROM `utilisateurs` WHERE Username = ?");
//
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
        return null;
    }

    @Override
    public void add(Formateur formateur) {

    }

    @Override
    public List<Formateur> getAll() {
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
