import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mariadb://localhost:3306/password_vault";
    private static final String USER = "root";
    private static final String PASS = "Dhana@mint1234";

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }

        return con;
    }
}
