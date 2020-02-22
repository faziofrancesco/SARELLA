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

        if (object.getNome() != null) {
            statement.setString(index + 1, object.getNome());
        } else {
            statement.setNull(index + 1, Types.VARCHAR);
        }

        if (object.getCognome() != null) {
            statement.setString(index + 2, object.getCognome());
        } else {
            statement.setNull(index + 2, Types.VARCHAR);
        }

        if (object.getDataDiNascita() != null) {
            statement.setDate(index + 3, object.getDataDiNascita());
        } else {
            statement.setNull(index + 3, Types.DATE);
        }

        statement.setString(index + 4, object.getEmail());
        statement.setString(index + 5, object.getUsername());
        statement.setString(index + 6, object.getPassword());
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
                utente = new Cliente();
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
    public Cliente existusernameandpassword(String Username, String Password) {
        String query = "Select * from cliente where username=? and password=?";
        Cliente utente = null;
        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setString(1, Username);
            handler.getStatement().setString(2, Password);

            handler.execute();

            if (handler.existsResultSet()) {

                utente = new Cliente();
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
