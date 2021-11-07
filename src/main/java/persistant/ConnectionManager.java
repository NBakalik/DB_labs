package persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String user = "root";
    private static final String password = "ab1234";

    private static Connection connection;

    private ConnectionManager() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            Logger logger = Logger.getAnonymousLogger();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
        return connection;
    }
}

