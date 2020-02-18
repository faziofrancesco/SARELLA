package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tipologia;
import persistence.PersistenceException;
import persistence.tipologiaDao;
public class tipologiaDaoJdbc implements  tipologiaDao {
    private Tipologia extractTo(ResultSet set) throws SQLException{
        Tipologia obj = new Tipologia();
        obj.setIdTipologia(set.getInt("id_tipologia"));
        obj.setTipologia(set.getInt("tipologia"));
        return obj;
    }
    @Override
    public void save(Tipologia object) {
        String query = "{call save_tipologia(?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getTipologia());
            statement.execute();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Tipologia retrieve(Tipologia object) {
        String query = "SELECT * FROM tipologia where id_tipologia=?";
        Tipologia tipologia = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdTipologia());

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                tipologia=extractTo(result);
            }
            return tipologia;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Tipologia> retrieveAll() {
        String query = "SELECT * FROM tipologia";
        List<Tipologia> tipologie = null;
        Tipologia tipologia= null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                tipologie = new ArrayList<Tipologia>();
                while (result.next()) {
                    tipologia=extractTo(result);
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
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdTipologia());
            statement.setInt(2, object.getTipologia());

            handler.executeUpdate();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Tipologia object) {
        String delete = "{call delete_from_tipologia(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            PreparedStatement smt = handler.getStatement();
            smt.setInt(1, object.getIdTipologia());

            handler.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
