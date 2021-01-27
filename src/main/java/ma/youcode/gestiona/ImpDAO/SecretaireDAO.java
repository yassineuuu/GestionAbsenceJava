package ma.youcode.gestiona.ImpDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Apprenant;
import ma.youcode.gestiona.Modeles.Secretaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class SecretaireDAO implements DAO<Secretaire> {
    @Override
    public Optional<Secretaire> get(int id) {
        return Optional.empty();
    }

    @Override
    public ObservableList<Secretaire> getAll() {

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
