package persistence.jdbc;

import model.Prenotazione;
import persistence.PersistenceException;
import persistence.PrenotazioneDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrenotazioneDaoJDBC implements PrenotazioneDao {
    private Prenotazione extractTo(ResultSet set) throws SQLException {
        Prenotazione obj = new Prenotazione();
        obj.setIdPrenotazione(set.getInt("id_prenotazione"));
        obj.setIdOrdineFk(set.getInt("fk_ordine"));
        obj.setIdCameraFk(set.getInt("fk_camera"));
        obj.setDataCheckIn(set.getDate("data_check_in"));
        obj.setDataCheckout(set.getDate("data_check_out"));
        return obj;
    }

    private void insertInto(Prenotazione object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if (id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(index+1, object.getIdOrdineFk());
        statement.setInt(index+2, object.getIdCameraFk());
        statement.setDate(index+3, object.getDataCheckIn());
        statement.setDate(index+4, object.getDataCheckout());

    }

    @Override
    public void save(Prenotazione object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_prenotazione(?,?,?,?)")) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Prenotazione retrieve(Prenotazione object) {
        Prenotazione prenotazione = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_by_id_from_prenotazione(?)")) {
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
        List<Prenotazione> prenotazioni = null;
        Prenotazione prenotazione = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_prenotazione")) {

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

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT update_prenotazione(?,?,?,?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdPrenotazione());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Prenotazione object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT delete_from_prenotazione(?)")) {
            handler.getStatement().setInt(1, object.getIdPrenotazione());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
