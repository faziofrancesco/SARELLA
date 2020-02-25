package persistence.jdbc;

import model.*;
import persistence.AdminDao;
import persistence.GoogleUserDao;
import persistence.PersistenceException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AdminDaoJDBC implements AdminDao {
    private Admin extractTo(ResultSet set) throws SQLException {
        Admin obj = new Admin();
        obj.setIdAdmin(set.getInt("id_admin"));
        obj.setFk_cliente(set.getInt("fk_cliente"));
        return obj;
    }
    private void insertInto(Admin object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if (id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(index + 1, object.getFk_cliente());
    }
    @Override
    public void save(Admin object) {
        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_admin_user(?)")) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Admin retrieve(Admin object) {
        Admin user = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_by_id_from_admin_user(?)")) {
            handler.getStatement().setInt(1, object.getIdAdmin());

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                user = extractTo(result);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Admin> retrieveAll() {
        List<Admin> users = new ArrayList<Admin>();
        Admin user = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_admin_user")) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                while (result.next()) {
                    user = extractTo(result);
                    users.add(user);
                }
            }

            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Admin object) {
        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT update_admin_user(?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdAdmin());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Admin object) {
        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT delete_from_admin_user(?)")) {

            handler.getStatement().setInt(1, object.getIdAdmin());

            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Admin retrieveByUser(Integer id) {
        String query = "SELECT * FROM retrieve_by_user_from_admin_user(?)";
        Admin utente = null;
        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, id);

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
