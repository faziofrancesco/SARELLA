package persistence.jdbc;

import model.Cliente;
import persistence.ClienteDao;
import persistence.PersistenceException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC implements ClienteDao {

    private Cliente extractTo(ResultSet set) throws SQLException {

        Cliente obj = new Cliente();
        obj.setIdCliente(set.getInt("id_cliente"));
        obj.setNome(set.getString("nome"));
        obj.setCognome(set.getString("cognome"));
        obj.setDataDiNascita(set.getDate("data_di_nascita"));
        obj.setEmail(set.getString("e_mail"));
        obj.setUsername(set.getString("username"));
        obj.setPassword(set.getString("password"));
        return obj;

    }

    private void insertInto(Cliente object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if (id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        if (object.getNome() != null && !object.getNome().equals("")) {
            statement.setString(index + 1, object.getNome());
        } else {
            statement.setNull(index + 1, Types.VARCHAR);
        }

        if (object.getCognome() != null && !object.getCognome().equals("")) {
            statement.setString(index + 2, object.getCognome());
        } else {
            statement.setNull(index + 2, Types.VARCHAR);
        }

        if (object.getDataDiNascita() != null && !object.getDataDiNascita().toString().equals("")) {
            statement.setDate(index + 3, object.getDataDiNascita());
        } else {
            statement.setNull(index + 3, Types.DATE);
        }

        if (object.getEmail() != null && !object.getEmail().equals("")) {
            statement.setString(index + 4, object.getEmail());
        } else {
            statement.setNull(index + 4, Types.VARCHAR);
        }

        if (object.getUsername() != null && !object.getUsername().equals("")) {
            statement.setString(index + 5, object.getUsername());
        } else {
            statement.setNull(index + 5, Types.VARCHAR);
        }

        if (object.getPassword() != null  && !object.getPassword().equals("")) {
            statement.setString(index + 6, object.getPassword());
        } else {
            statement.setNull(index + 6, Types.VARCHAR);
        }
    }

    @Override
    public void save(Cliente object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_cliente(?,?,?,?,?,?)")) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Cliente retrieve(Cliente object) {
        Cliente utente = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_by_id_from_cliente(?)")) {
            handler.getStatement().setInt(1, object.getIdCliente());
            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                utente = extractTo(result);
            }

            return utente;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Cliente> retrieveAll() {

        List<Cliente> utenti = null;
        Cliente utente = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_cliente")) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                utenti = new ArrayList<Cliente>();
                while (result.next()) {
                    utente = extractTo(result);
                    utenti.add(utente);
                }
            }

            return utenti;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Cliente object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT update_cliente(?,?,?,?,?,?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdCliente());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Cliente object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT delete_from_cliente(?)")) {

            handler.getStatement().setInt(1, object.getIdCliente());

            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Cliente retrieveByEmail(String email) {
        Cliente utente = null;
        String query = "select * from cliente where e_mail=?";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setString(1, email);
            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                utente = extractTo(result);
            }

            return utente;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Cliente retrieveByUsernamePassword(String Username, String Password) {
        String query = "SELECT * FROM retrieve_by_username_password_from_cliente(?,?)";
        Cliente utente = null;
        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setString(1, Username);
            handler.getStatement().setString(2, Password);

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                utente = extractTo(result);

            }

            return utente;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
