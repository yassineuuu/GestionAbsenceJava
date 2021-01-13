import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Maven yaaaaay");
        Connection conn = ConnectionFactory.getConnection();

        String query = "SELECT * FROM `utilisateurs` WHERE id = 1";

        Statement st =conn.createStatement();
        ResultSet rs = st.executeQuery(query);



        while (rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("Username"));
            System.out.println(rs.getString("MDP"));
            System.out.println(rs.getString("Type"));
        }

    }
}
