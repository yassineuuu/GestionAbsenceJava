package ma.youcode.gestiona.ImpDAO;

import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Apprenant;

import java.util.List;
import java.util.Optional;

public class ApprenantDAO implements DAO<Apprenant> {
    @Override
    public Optional<Apprenant> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Apprenant> getAll() {
        return null;
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
