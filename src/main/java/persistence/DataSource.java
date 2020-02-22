package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private final String dbURL; // = "jdbc:postgresql://siw-db-1920.postgres.database.azure.com";
    private final String userName; // = "CaligiuriFazio@siw-db-1920";
    private final String password; // = "*Francesco1.,";

    public DataSource(String dbURI, String userName, String password) {
        this.dbURL = dbURI;
        this.userName = userName;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, userName, password);
        return connection;
    }
}
