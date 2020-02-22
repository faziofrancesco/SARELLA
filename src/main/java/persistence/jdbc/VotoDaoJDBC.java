package persistence.jdbc;

import model.Voto;
import persistence.PersistenceException;
import persistence.VotoDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VotoDaoJDBC implements VotoDao {

    private Voto extractTo(ResultSet set) throws SQLException {
        Voto obj = new Voto();
        obj.setIdVoto(set.getInt("id_voto"));
        obj.setVoto(set.getInt("voto"));
        return obj;
    }

    private void insertInto(Voto object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if (id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(1, object.getVoto());
    }

    @Override
    public void save(Voto object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_voto(?)")) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Voto retrieve(Voto object) {
        Voto voto = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_by_id_from_voto(?)")) {

            handler.getStatement().setInt(1, object.getIdVoto());
            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                voto = extractTo(result);
            }
            return voto;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Voto> retrieveAll() {
        List<Voto> voti = null;
        Voto voto = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_voto")) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                voti = new ArrayList<Voto>();
                while (result.next()) {
                    voto = extractTo(result);
                    voti.add(voto);
                }
            }

            return voti;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Voto object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT update_voto(?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdVoto());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Voto object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT delete_from_voto(?)")) {

            handler.getStatement().setInt(1, object.getIdVoto());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
