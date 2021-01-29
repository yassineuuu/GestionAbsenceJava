package ma.youcode.gestiona.ImpDAO;

import javafx.collections.ObservableList;
import ma.youcode.gestiona.DAO.AdminDAO;
import ma.youcode.gestiona.Modeles.Secretaire;

import java.util.List;

public class SecretaireAdminDAO implements AdminDAO<Secretaire> {
    @Override
    public ObservableList<Secretaire> get(String Username) {
        return null;
    }

    @Override
    public void add(Secretaire secretaire) {

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
