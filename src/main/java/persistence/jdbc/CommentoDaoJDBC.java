package persistence.jdbc;

import model.Commento;
import persistence.CommentoDao;
import persistence.PersistenceException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentoDaoJDBC implements CommentoDao {

    private Commento extractTo(ResultSet set) throws SQLException {

        Commento obj = new Commento();
        obj.setIdCommento(set.getInt("id_commento"));
        obj.setIdClienteFk(set.getInt("fk_cliente"));
        obj.setIdRecensioneFk(set.getInt("fk_recensione"));
        obj.setContenuto(set.getString("contenuto"));
        obj.setDataCommento(set.getTimestamp("data_commento"));
        return obj;

    }

    private void insertInto(Commento object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if (id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(index + 1, object.getIdClienteFk());
        statement.setInt(index + 2, object.getIdRecensioneFk());
        statement.setString(index + 3, object.getContenuto());
        statement.setTimestamp(index + 4, object.getDataCommento());
    }

    @Override
    public void save(Commento object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_commento(?,?,?,?)")) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Commento retrieve(Commento object) {
        Commento commento = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_by_id_from_commento(?)")) {
            handler.getStatement().setInt(1, object.getIdCommento());
            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                commento = extractTo(result);
            }
            return commento;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Commento> retrieveAll() {
        List<Commento> commenti = null;
        Commento commento = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_commento")) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                commenti = new ArrayList<Commento>();
                while (result.next()) {
                    commento = extractTo(result);
                    commenti.add(commento);
                }
            }

            return commenti;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Commento object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT update_commento(?,?,?,?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdCommento());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Commento object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT delete_from_commento(?)")) {

            handler.getStatement().setInt(1, object.getIdCommento());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
