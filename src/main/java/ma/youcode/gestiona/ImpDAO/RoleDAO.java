package ma.youcode.gestiona.ImpDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.gestiona.Connection.ConnectionFactory;
import ma.youcode.gestiona.DAO.DAO;
import ma.youcode.gestiona.Modeles.Admin;
import ma.youcode.gestiona.Modeles.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RoleDAO implements DAO<Role> {

    @Override
    public ObservableList<Role> get(String role) {
        return null;
    }

    @Override
    public void add(Role role) {

    }

    @Override
    public ObservableList<Role> getAll() throws SQLException {
        Connection conn = null;
        ObservableList<Role> options = FXCollections.observableArrayList();
                conn = ConnectionFactory.getConnection();

                try {
                    PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `role`");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    Role role;
                    while (resultSet.next()){
                        role = new Role(resultSet.getString("role_Nom"));
                        System.out.println(resultSet.getString("role_Nom"));
                        options.add(role);
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }


        return options;
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public void update(Role role, String[] params) {

    }

    @Override
    public void delete(Role role) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM utilisateurs WHERE id =" + role.getId());
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
