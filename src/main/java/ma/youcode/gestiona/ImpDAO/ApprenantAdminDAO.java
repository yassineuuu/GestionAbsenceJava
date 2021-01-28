package ma.youcode.gestiona.ImpDAO;

import javafx.collections.ObservableList;
import ma.youcode.gestiona.DAO.AdminDAO;
import ma.youcode.gestiona.Modeles.Apprenant;

import java.util.List;

public class ApprenantAdminDAO implements AdminDAO<Apprenant> {
    @Override
    public ObservableList<Apprenant> get(String Username) {
        return null;
    }

    @Override
    public void add(Apprenant apprenant) {

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
