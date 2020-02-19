package persistence.jdbc;

import model.Tipologia;
import persistence.PersistenceException;
import persistence.tipologiaDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipologiaDaoJDBC implements tipologiaDao {

    private Tipologia extractTo(ResultSet set) throws SQLException {
        Tipologia obj = new Tipologia();
        obj.setIdTipologia(set.getInt("id_tipologia"));
        obj.setTipologia(set.getInt("tipologia"));
        return obj;
    }

    private void insertInto(Tipologia object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if(id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(1, object.getTipologia());
    }

    @Override
    public void save(Tipologia object) {
        String query = "{call save_tipologia(?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Tipologia retrieve(Tipologia object) {
        String query = "{call retrieve_by_id_from_tipologia(?)}";
        Tipologia tipologia = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdTipologia());
            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                tipologia = extractTo(result);
            }
            return tipologia;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Tipologia> retrieveAll() {
        String query = "SELECT * FROM retrieve_all_from_tipologia";
        List<Tipologia> tipologie = null;
        Tipologia tipologia = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                tipologie = new ArrayList<Tipologia>();
                while (result.next()) {
                    tipologia = extractTo(result);
                    tipologie.add(tipologia);
                }
            }

            return tipologie;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Tipologia object) {
        String query = "{call update_tipologia(?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), object.getIdTipologia());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Tipologia object) {
        String delete = "{call delete_from_tipologia(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            handler.getStatement().setInt(1, object.getIdTipologia());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
