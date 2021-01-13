import java.util.List;
import java.util.Optional;

public class UserDAO implements DAO<Utilisateur>{
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
