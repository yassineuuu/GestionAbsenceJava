package ma.youcode.gestiona.ImpDAO;

import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Secretaire;

import java.util.List;
import java.util.Optional;

public class SecretaireDAO implements DAO<Secretaire> {
    @Override
    public Optional<Secretaire> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Secretaire> getAll() {
        return null;
    }

    @Override
    public void save(Secretaire secretaire) {

    }

    @Override
    public void update(Secretaire secretaire, String[] params) {

    }

    @Override
    public void delete(Secretaire secretaire) {

    }
}
