package ma.youcode.gestiona.ImpDAO;

import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Admin;

import java.util.List;
import java.util.Optional;

public class AdminDAO implements DAO<Admin> {
    @Override
    public Optional<Admin> get(int id) {
        return Optional.empty();
    }

    @Override
    public void add(Admin admin) {

    }

    @Override
    public List<Admin> getAll() {
        return null;
    }

    @Override
    public void save(Admin admin) {

    }

    @Override
    public void update(Admin admin, String[] params) {

    }

    @Override
    public void delete(Admin admin) {

    }
}
