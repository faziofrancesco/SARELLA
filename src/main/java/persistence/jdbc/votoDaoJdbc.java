package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tipologia;
import model.Voto;
import persistence.PersistenceException;
import persistence.votoDao;
public class votoDaoJdbc implements votoDao{
    private Voto extractTo(ResultSet set) throws SQLException{
        Voto obj = new Voto();
        obj.setIdVoto(set.getInt("id_voto"));
        obj.setVoto(set.getInt("voto"));
        return obj;
    }
    @Override
    public void save(Voto object) {
        String query = "{call save_voto(?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getVoto());
            statement.execute();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Voto retrieve(Voto object) {
        String query = "SELECT * FROM voto where id_voto=?";
        Voto voto = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdVoto());

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                voto=extractTo(result);
            }
            return voto;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Voto> retrieveAll() {
        String query = "SELECT * FROM voto";
        List<Voto> voti = null;
        Voto voto= null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                voti = new ArrayList<Voto>();
                while (result.next()) {
                    voto=extractTo(result);
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
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdVoto());
            statement.setInt(2, object.getVoto());

            handler.executeUpdate();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Voto object) {
        String delete = "{call delete_from_voto(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            PreparedStatement smt = handler.getStatement();
            smt.setInt(1, object.getIdVoto());

            handler.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
