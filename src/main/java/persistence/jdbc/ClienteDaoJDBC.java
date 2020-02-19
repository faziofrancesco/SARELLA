package persistence.jdbc;

import model.Cliente;
import persistence.PersistenceException;
import persistence.clienteDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC implements clienteDao {

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
        if(id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setString(index + 1, object.getNome());
        statement.setString(index + 2, object.getCognome());
        statement.setDate(index + 3, object.getDataDiNascita());
        statement.setString(index + 4, object.getEmail());
        statement.setString(index + 5, object.getUsername());
        statement.setString(index + 6, object.getPassword());
    }

    @Override
    public void save(Cliente object) {
        String query = "{call save_cliente(?,?,?,?,?,?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Cliente retrieve(Cliente object) {
        String query = "{call retrieve_by_id_from_cliente(?)}";
        Cliente utente = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
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
        String query = "SELECT * FROM retrieve_all_from_cliente";
        List<Cliente> utenti = null;
        Cliente utente = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

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
        String update = "{call update_cliente(?,?,?,?,?,?,?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(update)) {
            insertInto(object, handler.getStatement(), object.getIdCliente());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Cliente object) {
        String update = "{call delete_from_cliente(?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(update)) {

            handler.getStatement().setInt(1, object.getIdCliente());

            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
