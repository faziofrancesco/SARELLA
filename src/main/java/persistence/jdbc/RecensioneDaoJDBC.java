package persistence.jdbc;

import model.Recensione;
import persistence.PersistenceException;
import persistence.RecensioneDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecensioneDaoJDBC implements RecensioneDao {

    private Recensione extractTo(ResultSet set) throws SQLException {
        Recensione obj = new Recensione();
        obj.setIdRecensione(set.getInt("id_recensione"));
        obj.setIdClienteFk(set.getInt("fk_cliente"));
        obj.setIdOrdineFk(set.getInt("fk_ordine"));
        obj.setIdVotoFk(set.getInt("fk_voto"));
        obj.setDescrizione(set.getString("descrizione"));
        obj.setDataRecensione(set.getTimestamp("data_recensione"));
        return obj;
    }

    private void insertInto(Recensione object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if (id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(1, object.getIdClienteFk());
        statement.setInt(2, object.getIdOrdineFk());
        statement.setInt(3, object.getIdVotoFk());
        statement.setString(4, object.getDescrizione());
        statement.setTimestamp(5, object.getDataRecensione());
    }

    @Override
    public void save(Recensione object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_recensione(?,?,?,?,?)")) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Recensione retrieve(Recensione object) {
        Recensione recensione = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_by_id_from_recensione(?)")) {
            handler.getStatement().setInt(1, object.getIdRecensione());
            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                recensione = extractTo(result);
            }
            return recensione;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Recensione> retrieveAll() {
        List<Recensione> recensioni = null;
        Recensione recensione = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_recensione")) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                recensioni = new ArrayList<Recensione>();
                while (result.next()) {
                    recensione = extractTo(result);
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

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT update_recensione(?,?,?,?,?,?)")) {

            insertInto(object, handler.getStatement(), object.getIdRecensione());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Recensione object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT delete_from_recensione(?)")) {

            handler.getStatement().setInt(1, object.getIdRecensione());

            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Recensione> retrieveByRoom(Integer idCamera) {

        List<Recensione> rec = null;

        try(JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_by_camera_from_recensione(?)")) {

            handler.getStatement().setInt(1, idCamera);
            handler.execute();

            if(handler.existsResultSet()) {
                rec = new ArrayList<>();
                ResultSet results = handler.getResultSet();
                while(results.next())
                    rec.add(extractTo(results));
            }

            return rec;

        } catch(SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }
}
