package persistence.jdbc;

import model.Voto;
import persistence.PersistenceException;
import persistence.votoDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VotoDaoJDBC implements votoDao {

    private Voto extractTo(ResultSet set) throws SQLException {
        Voto obj = new Voto();
        obj.setIdVoto(set.getInt("id_voto"));
        obj.setVoto(set.getInt("voto"));
        return obj;
    }

    private void insertInto(Voto object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if(id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(1, object.getVoto());
    }

    @Override
    public void save(Voto object) {
        String query = "{call save_voto(?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Voto retrieve(Voto object) {
        String query = "{call retrieve_by_id_from_voto(?)}";
        Voto voto = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

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
        String query = "SELECT * FROM retrieve_all_from_voto";
        List<Voto> voti = null;
        Voto voto = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

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
        String query = "{call update_voto(?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), object.getIdVoto());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Voto object) {
        String delete = "{call delete_from_voto(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            handler.getStatement().setInt(1, object.getIdVoto());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
