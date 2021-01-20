package ma.youcode.gestiona.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO <T>{
    List<T> get(String Username);
    void add (T t);
    List<T> getAll() throws SQLException;
    void save(T t);

    void update(T t, String[] params);

    void delete(T t) throws SQLException;
}
