package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Prenotazione;
import model.Recensione;
import persistence.PersistenceException;
import persistence.recensioneDao;
public class recensioneDaoJdbc implements recensioneDao{
    private Recensione extractTo(ResultSet set) throws SQLException{
        Recensione obj = new Recensione();
        obj.setIdRecensione(set.getInt("id_recensione"));
        obj.setIdClienteFk(set.getInt("fk_cliente"));
        obj.setIdOrdineFk(set.getInt("fk_ordine"));
        obj.setIdVotoFk(set.getInt("fk_voto"));
        obj.setDescrizione(set.getString("descrizione"));
        obj.setDataRecensione(set.getTimestamp("data_recensione"));
        return obj;
    }
    @Override
    public void save(Recensione object) {
        String query = "{call save_recensione(?,?,?,?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdClienteFk());
            statement.setInt(2, object.getIdOrdineFk());
            statement.setInt(3, object.getIdVotoFk());
            statement.setString(4,object.getDescrizione());
            statement.setTimestamp(5, object.getDataRecensione());
            statement.execute();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Recensione retrieve(Recensione object) {
        String query = "SELECT * FROM recensione where id_recensione=?";
        Recensione recensione = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdRecensione());

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                recensione=extractTo(result);
            }
            return recensione;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Recensione> retrieveAll() {
        String query = "SELECT * FROM recensione";
        List<Recensione> recensioni = null;
        Recensione recensione= null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                recensioni = new ArrayList<Recensione>();
                while (result.next()) {
                    recensione=extractTo(result);
                    recensioni.add(recensione);
                }
            }

            return recensioni;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Recensione object) {
        String query = "{call update_recensione(?,?,?,?,?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdRecensione());
            statement.setInt(2, object.getIdClienteFk());
            statement.setInt(3, object.getIdOrdineFk());
            statement.setInt(4, object.getIdVotoFk());
            statement.setString(5,object.getDescrizione());
            statement.setTimestamp(6, object.getDataRecensione());
            handler.executeUpdate();
        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Recensione object) {
        String delete = "{call delete_from_recensione(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            PreparedStatement smt = handler.getStatement();
            smt.setInt(1, object.getIdRecensione());

            handler.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
