package persistence.jdbc;

import model.Camera;
import persistence.PersistenceException;
import persistence.CameraDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CameraDaoJDBC implements CameraDao {

    private Camera extractFrom(ResultSet set) throws SQLException {

        Camera obj = new Camera();
        obj.setIdCamera(set.getInt("id_camera"));
        obj.setTipologia(set.getInt("fk_tipologia"));
        obj.setNumPersone(set.getInt("fk_nump"));
        obj.setDescrizione(set.getString("descrizione"));
        obj.setImagePath(set.getString("image_path"));
        obj.setPrezzo(set.getBigDecimal("prezzo"));
        return obj;

    }

    private void insertInto(Camera object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if(id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        if(object.getTipologia() != null) {
            statement.setInt(index + 1, object.getTipologia());
        } else {
            statement.setNull(index + 1, Types.INTEGER);
        }

        if(object.getNumPersone() != null) {
            statement.setInt(index + 2, object.getNumPersone());
        } else {
            statement.setNull(index + 2, Types.INTEGER);
        }

        statement.setString(index + 3, object.getDescrizione());
        statement.setBigDecimal(index + 5, object.getPrezzo());

        if(object.getImagePath() != null) {
            statement.setString(index + 4, object.getImagePath());
        } else {
            statement.setNull(index + 4, Types.VARCHAR);
        }
    }

    @Override
    public void save(Camera object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_camera(?,?,?,?,?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdCamera());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Camera retrieve(Camera object) {
        Camera camera = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_by_id_from_camera(?)")) {
            handler.getStatement().setInt(1, object.getIdCamera());
            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                camera = extractFrom(result);
            }
            return camera;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Camera> retrieveAll() {
        List<Camera> camere = null;
        Camera camera = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_camera")) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                camere = new ArrayList<Camera>();
                while (result.next()) {
                    camera = extractFrom(result);
                    camere.add(camera);
                }
            }

            return camere;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Camera object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT update_camera(?,?,?,?,?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdCamera());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Camera object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT delete_from_camera(?)")) {

            handler.getStatement().setInt(1, object.getIdCamera());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }
}

