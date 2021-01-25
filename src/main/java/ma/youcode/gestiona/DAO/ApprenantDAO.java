package ma.youcode.gestiona.DAO;

import javafx.collections.ObservableList;
import ma.youcode.gestiona.Modeles.Apprenant;

import java.util.Optional;

public interface ApprenantDAO<T> {

    public ObservableList<Apprenant> getByName(String nom);
    public ObservableList<T> getEtudiant();
    public void save(T t);
    public void update(T t, String[] params);
    public void delete(Apprenant apprenant);
}
