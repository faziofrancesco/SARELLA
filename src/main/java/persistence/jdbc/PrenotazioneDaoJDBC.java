package persistence.jdbc;

import model.Prenotazione;
import persistence.PersistenceException;
import persistence.prenotazioneDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrenotazioneDaoJDBC implements prenotazioneDao {
    private Prenotazione extractTo(ResultSet set) throws SQLException {
        Prenotazione obj = new Prenotazione();
        obj.setIdPrenotazione(set.getInt("id_prenotazione"));
        obj.setIdOrdineFk(set.getInt("fk_ordine"));
        obj.setIdCameraFk(set.getInt("fk_camera"));
        obj.setDataCheckIn(set.getTimestamp("data_check_in"));
        obj.setDataCheckout(set.getTimestamp("data_check_out"));
        return obj;
    }

    private void insertInto(Prenotazione object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if(id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(1, object.getIdOrdineFk());
        statement.setInt(2, object.getIdCameraFk());
        statement.setTimestamp(3, object.getDataCheckIn());
        statement.setTimestamp(4, object.getDataCheckout());

    }

    @Override
    public void save(Prenotazione object) {
        String query = "{call save_prenotazione(?,?,?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Prenotazione retrieve(Prenotazione object) {
        String query = "{call retrieve_by_id_from_prenotazione(?)}";
        Prenotazione prenotazione = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdPrenotazione());
            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                prenotazione = extractTo(result);
            }
            return prenotazione;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Prenotazione> retrieveAll() {
        String query = "SELECT * FROM retrieve_all_from_prenotazione";
        List<Prenotazione> prenotazioni = null;
        Prenotazione prenotazione = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                prenotazioni = new ArrayList<Prenotazione>();
                while (result.next()) {
                    prenotazione = extractTo(result);
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
            insertInto(object, handler.getStatement(), object.getIdPrenotazione());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Prenotazione object) {
        String delete = "{call delete_from_prenotazione(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {
            handler.getStatement().setInt(1, object.getIdPrenotazione());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
