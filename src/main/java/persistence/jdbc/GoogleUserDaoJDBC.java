package persistence.jdbc;

import model.Commento;
import model.GoogleUser;
import model.NumPersone;
import persistence.GoogleUserDao;
import persistence.PersistenceException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GoogleUserDaoJDBC implements GoogleUserDao {
    private GoogleUser extractTo(ResultSet set) throws SQLException {
        GoogleUser obj = new GoogleUser();
        obj.setIdGoogle(set.getInt("id_google_user"));
        obj.setFk_cliente(set.getInt("fk_cliente"));
        return obj;
    }
    private void insertInto(GoogleUser object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if (id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(index + 1, object.getFk_cliente());
    }
    @Override
    public void save(GoogleUser object) {
        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_google_user(?)")) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public GoogleUser retrieve(GoogleUser object) {
        GoogleUser user = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_by_id_from_google_user(?)")) {
            handler.getStatement().setInt(1, object.getIdGoogle());

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
    public List<GoogleUser> retrieveAll() {
        List<GoogleUser> users = new ArrayList<GoogleUser>();
        GoogleUser user = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_google_user")) {

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
    public void update(GoogleUser object) {
        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT update_google_user(?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdGoogle());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(GoogleUser object) {
        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT delete_from_google_user(?)")) {

            handler.getStatement().setInt(1, object.getIdGoogle());

            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
