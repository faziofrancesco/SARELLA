package persistence.jdbc;

import persistence.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCQueryHandler implements AutoCloseable {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public JDBCQueryHandler(String query) throws SQLException {

        connection = DBManager.getInstance().getDataSource().getConnection();
        preparedStatement = connection.prepareStatement(query);
    }

    @Override
    public void close() throws SQLException {

        try {
            if (connection != null) connection.close();

        } finally {
            connection = null;
            try {
                if (preparedStatement != null) preparedStatement.close();
            } finally {
                preparedStatement = null;
                try {
                    if (resultSet != null) resultSet.close();
                } finally {
                    resultSet = null;
                }
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public PreparedStatement getStatement() {
        return preparedStatement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public boolean existsResultSet() throws SQLException {
        return resultSet != null && resultSet.isBeforeFirst();
    }

    public void execute() throws SQLException {
        if(preparedStatement.execute())
            resultSet = preparedStatement.getResultSet();
    }
}
