package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Commento;
import persistence.PersistenceException;
import persistence.commentoDao;
public class commentoDaoJdbc implements commentoDao{
    private Commento extractTo(ResultSet set) throws SQLException{

        Commento obj = new Commento();
        obj.setIdCommento(set.getInt("id_commento"));
        obj.setIdClienteFk(set.getInt("fk_cliente"));
        obj.setIdRecensioneFk(set.getInt("fk_recensione"));
        obj.setContenuto(set.getString("contenuto"));
        obj.setDataCommento(set.getTimestamp("data_commento"));
        return obj;

    }
    @Override
    public void save(Commento object) {
        String query = "{call save_commento(?,?,?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdClienteFk());
            statement.setInt(2, object.getIdRecensioneFk());
            statement.setString(3, object.getContenuto());
            statement.setTimestamp(4, object.getDataCommento());
            statement.execute();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Commento retrieve(Commento object) {
        String query = "SELECT * FROM commento where id_commento=?";
        Commento commento = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdCommento());
            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                commento=extractTo(result);
            }
            return commento;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Commento> retrieveAll() {
        String query = "SELECT * FROM commento";
        List<Commento> commenti = null;
        Commento commento= null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                commenti = new ArrayList<Commento>();
                while (result.next()) {
                    commento=extractTo(result);
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
        String query = "{call update_commento(?,?,?,?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdCommento());
            statement.setInt(2, object.getIdClienteFk());
            statement.setInt(3, object.getIdRecensioneFk());
            statement.setString(4, object.getContenuto());
            statement.setTimestamp(5, object.getDataCommento());
            handler.executeUpdate();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Commento object) {
        String delete = "{call delete_from_commento(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            PreparedStatement smt = handler.getStatement();
            smt.setInt(1, object.getIdCommento());

            handler.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
