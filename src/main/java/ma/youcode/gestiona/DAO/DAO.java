package ma.youcode.gestiona.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO <T>{
    Optional<T> get(int id) throws SQLException;
    List<T> getAll();
    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
