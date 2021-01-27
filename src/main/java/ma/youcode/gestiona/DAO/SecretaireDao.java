package ma.youcode.gestiona.DAO;

import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.Optional;

public interface SecretaireDao<T> {

    Optional<T> get(int id) throws SQLException;
    ObservableList<T> getAll() throws SQLException;
    void save(T t);

    void update(T t, String[] params);

    void delete(T t);


}
