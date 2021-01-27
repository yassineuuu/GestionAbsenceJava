package ma.youcode.gestiona.ImpDAO;

import javafx.collections.ObservableList;
import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Formateur;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FormateurDAO implements DAO<Formateur> {
    @Override
    public Optional<Formateur> get(int id) {
        return Optional.empty();
    }

    @Override
    public ObservableList<Formateur> getAll() throws SQLException {
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
