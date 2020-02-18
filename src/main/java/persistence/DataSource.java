package persistence;

import java.sql.*;

public class DataSource {
	private String dbURL; // = "jdbc:postgresql://siw-db-1920.postgres.database.azure.com";
	private String userName; // = "CaligiuriFazio@siw-db-1920";
	private String password; // = "*Francesco1.,";

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
