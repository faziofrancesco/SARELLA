package persistence.jdbc;

import model.NumPersone;
import persistence.PersistenceException;
import persistence.NumPersoneDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NumPersoneDaoJDBC implements NumPersoneDao {
    private NumPersone extractTo(ResultSet set) throws SQLException {
        NumPersone obj = new NumPersone();
        obj.setIdNumPersone(set.getInt("id_num_persone"));
        obj.setNumPersone(set.getInt("num_persone"));
        return obj;
    }

    private void insertInto(NumPersone object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if(id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(index + 1, object.getNumPersone());
    }

    @Override
    public void save(NumPersone object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_num_persone(?)")) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public NumPersone retrieve(NumPersone object) {

        NumPersone numpersone = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_by_id_from_nump(?)")) {
            handler.getStatement().setInt(1, object.getIdNumPersone());

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                numpersone = extractTo(result);
            }
            return numpersone;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<NumPersone> retrieveAll() {

        List<NumPersone> lnumpersone = null;
        NumPersone numpersone = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_nump")) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                lnumpersone = new ArrayList<NumPersone>();
                while (result.next()) {
                    numpersone = extractTo(result);
                    lnumpersone.add(numpersone);
                }
            }

            return lnumpersone;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(NumPersone object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT update_num_persone(?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdNumPersone());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(NumPersone object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT delete_from_num_persone(?)")) {

            handler.getStatement().setInt(1, object.getIdNumPersone());

            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
