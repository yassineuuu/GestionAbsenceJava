import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

//    Variables
    private String driverClassName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/gestionabsenceyoucode?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String dbUser = "root";
    private static String dbPwd = "1995";

    private static ConnectionFactory connectionFactory;

    private ConnectionFactory(){
        try {
            Class.forName(driverClassName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection cnx;
        cnx = DriverManager.getConnection(url,dbUser,dbPwd);
        System.out.println("Connected");
        return cnx;
    }



}
