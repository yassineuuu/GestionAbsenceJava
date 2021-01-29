package ma.youcode.gestiona.DAO;

import javafx.collections.ObservableList;
import ma.youcode.gestiona.Modeles.ApprenantApprenant;

public interface ApprenantDAO<T> {

    public ObservableList<ApprenantApprenant> getByName(String nom);
    public ObservableList<T> getEtudiant();
    public void save(T t);
    public void update(T t, String[] params);
    public void delete(ApprenantApprenant apprenantApprenant);
}
