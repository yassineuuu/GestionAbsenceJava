package ma.youcode.gestiona.DAO;

import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.Optional;

public interface AbsenceDAO {
    ObservableList get(int id) throws SQLException;
    ObservableList getAll() throws SQLException;
    void insert();

    void update();

    void delete();
}
