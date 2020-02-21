package persistence.jdbc;

import model.Tipologia;
import persistence.PersistenceException;
import persistence.TipologiaDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipologiaDaoJDBC implements TipologiaDao {

    private Tipologia extractTo(ResultSet set) throws SQLException {
        Tipologia obj = new Tipologia();
        obj.setIdTipologia(set.getInt("id_tipologia"));
        obj.setTipologia(set.getString("tipologia"));
        return obj;
    }

    private void insertInto(Tipologia object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if(id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setString(1, object.getTipologia());
    }

    @Override
    public void save(Tipologia object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_tipologia(?)")) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Tipologia retrieve(Tipologia object) {
        Tipologia tipologia = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_by_id_from_tipologia(?)")) {
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
        List<Tipologia> tipologie = null;
        Tipologia tipologia = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_tipologia")) {

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

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT update_tipologia(?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdTipologia());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Tipologia object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT delete_from_tipologia(?)")) {

            handler.getStatement().setInt(1, object.getIdTipologia());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
