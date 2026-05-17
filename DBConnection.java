import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Add serverTimezone and recommended parameters to the JDBC URL
    private static final String URL = "jdbc:mysql://localhost:3306/password_vault?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "root";
    // Read password from environment variable 'DB_PASS' if set, otherwise fallback to the literal used during development.
    private static final String PASS = System.getenv("DB_PASS") != null ? System.getenv("DB_PASS") : "Dhana@mint1234";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // explicitly load driver (harmless on modern JVMs)
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}
