package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MetodoPagamento;
import model.Numpersone;
import persistence.PersistenceException;
import persistence.numPersoneDao;
public class numPersoneDaoJdbc implements numPersoneDao {
    private Numpersone extractTo(ResultSet set) throws SQLException{
        Numpersone obj = new Numpersone();
        obj.setIdNumPersone(set.getInt("id_num_persone"));
        obj.setNumPersone(set.getInt("num_persone"));
        return obj;
    }
    @Override
    public void save(Numpersone object) {
        String query = "{call save_num_persone(?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getNumPersone());
            statement.execute();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Numpersone retrieve(Numpersone object) {
        String query = "SELECT * FROM num_persone where id_num_persone=?";
        Numpersone numpersone = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdNumPersone());

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                numpersone=extractTo(result);
            }
            return numpersone;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Numpersone> retrieveAll() {
        String query = "SELECT * FROM num_persone";
        List<Numpersone> lnumpersone = null;
        Numpersone numpersone= null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
               lnumpersone = new ArrayList<Numpersone>();
                while (result.next()) {
                   numpersone=extractTo(result);
                    lnumpersone.add(numpersone);
                }
            }

            return lnumpersone;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Numpersone object) {
        String query = "{call update_num_persone(?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdNumPersone());
            statement.setInt(2, object.getNumPersone());

            handler.executeUpdate();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Numpersone object) {
        String delete = "{call delete_from_num_persone(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            PreparedStatement smt = handler.getStatement();
            smt.setInt(1, object.getIdNumPersone());

            handler.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
