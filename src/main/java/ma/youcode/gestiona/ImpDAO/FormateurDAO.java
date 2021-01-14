package ma.youcode.gestiona.ImpDAO;

import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Formateur;

import java.util.List;
import java.util.Optional;

public class FormateurDAO implements DAO<Formateur> {
    @Override
    public Optional<Formateur> get(int id) {
        return Optional.empty();
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
