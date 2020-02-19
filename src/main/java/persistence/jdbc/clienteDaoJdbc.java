package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import persistence.PersistenceException;
import persistence.clienteDao;

public class clienteDaoJdbc implements clienteDao {

    private Cliente extractTo(ResultSet set) throws SQLException{

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

    @Override
    public void save(Cliente object) {
        String query = "{call save_cliente(?,?,?,?,?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setString(1, object.getNome());
            statement.setString(2, object.getCognome());
            statement.setDate(3, object.getDataDiNascita());
            statement.setString(4, object.getEmail());
            statement.setString(5, object.getUsername());
            statement.setString(6, object.getPassword());
            statement.execute();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Cliente retrieve(Cliente object) {
        String query = "SELECT * FROM cliente where id_cliente=?";
        Cliente utente = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdCliente());
            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                utente=extractTo(result);
            }

            return utente;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Cliente> retrieveAll() {
        String query = "SELECT * FROM cliente";
        List<Cliente> utenti = null;
        Cliente utente = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                utenti = new ArrayList<Cliente>();
                while (result.next()) {
                    utente=extractTo(result);
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
        String update = "call update_cliente(?,?,?,?,?,?,?)";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(update)) {

            PreparedStatement smt = handler.getStatement();
            smt.setString(2, object.getNome());
            smt.setString(3,object.getCognome());
            smt.setDate(4, object.getDataDiNascita());
            smt.setString(5, object.getEmail());
            smt.setString(6, object.getUsername());
            smt.setString(7, object.getPassword());
            smt.setInt(1, object.getIdCliente());

            handler.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Cliente object) {
        String update = "{call delete_from_cliente(?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(update)) {

            PreparedStatement smt = handler.getStatement();
            smt.setInt(1, object.getIdCliente());

            handler.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Cliente retrieveByEmail(String email) {
        String query = "SELECT * FROM cliente where e_mail=?";
        Cliente utente = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setString(1, email);
            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                utente=extractTo(result);
            }

            return utente;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
