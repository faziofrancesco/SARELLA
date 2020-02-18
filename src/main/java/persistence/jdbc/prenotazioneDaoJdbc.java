package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pagamento;
import model.Prenotazione;
import persistence.PersistenceException;
import persistence.prenotazioneDao;
public class prenotazioneDaoJdbc implements prenotazioneDao{
    private Prenotazione extractTo(ResultSet set) throws SQLException{
        Prenotazione obj = new Prenotazione();
        obj.setIdPrenotazione(set.getInt("id_prenotazione"));
        obj.setIdOrdineFk(set.getInt("fk_ordine"));
        obj.setIdCameraFk(set.getInt("fk_camera"));
        obj.setDataCheckIn(set.getTimestamp("data_check_in"));
        obj.setDataCheckout(set.getTimestamp("data_check_out"));
        return obj;
    }
    @Override
    public void save(Prenotazione object) {
        String query = "{call save_prenotazione(?,?,?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdOrdineFk());
            statement.setInt(2, object.getIdCameraFk());
            statement.setTimestamp(3, object.getDataCheckIn());
            statement.setTimestamp(4, object.getDataCheckout());
            statement.execute();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Prenotazione retrieve(Prenotazione object) {
        String query = "SELECT * FROM prenotazione where id_prenotazione=?";
        Prenotazione prenotazione = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdPrenotazione());

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                prenotazione=extractTo(result);
            }
            return prenotazione;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Prenotazione> retrieveAll() {
        String query = "SELECT * FROM prenotazione";
        List<Prenotazione> prenotazioni = null;
        Prenotazione prenotazione= null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                prenotazioni = new ArrayList<Prenotazione>();
                while (result.next()) {
                    prenotazione=extractTo(result);
                    prenotazioni.add(prenotazione);
                }
            }

            return prenotazioni;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Prenotazione object) {
        String query = "{call update_prenotazione(?,?,?,?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdPrenotazione());
            statement.setInt(2, object.getIdOrdineFk());
            statement.setInt(3, object.getIdCameraFk());
            statement.setTimestamp(4, object.getDataCheckIn());
            statement.setTimestamp(5, object.getDataCheckout());
            handler.executeUpdate();
        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Prenotazione object) {
        String delete = "{call delete_from_prenotazione(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            PreparedStatement smt = handler.getStatement();
            smt.setInt(1, object.getIdPrenotazione());

            handler.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
