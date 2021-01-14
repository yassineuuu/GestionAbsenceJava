package ma.youcode.gestiona.ImpDAO;

import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Utilisateur;

import java.util.List;
import java.util.Optional;

public class UtilisateurDAO implements DAO<Utilisateur> {
    @Override
    public Optional<Utilisateur> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Utilisateur> getAll() {
        return null;
    }

    @Override
    public void save(Utilisateur utilisateur) {

    }

    @Override
    public void update(Utilisateur utilisateur, String[] params) {

    }

    @Override
    public void delete(Utilisateur utilisateur) {

    }
}
