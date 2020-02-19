package persistence.jdbc;

import model.Camera;
import persistence.PersistenceException;
import persistence.CameraDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        obj.setPrezzo(set.getDouble("prezzo"));
        return obj;

    }

    private void insertInto(Camera object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if(id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(index + 1, object.getTipologia());
        statement.setInt(index + 2, object.getNumPersone());
        statement.setString(index + 3, object.getDescrizione());
        statement.setString(index + 4, object.getImagePath());
        statement.setDouble(index + 5, object.getPrezzo());
    }

    @Override
    public void save(Camera object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("call save_camera(?,?,?,?,?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdCamera());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Camera retrieve(Camera object) {
        String query = "{call retrieve_by_id_from_camera(?)}";
        Camera camera = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
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
        String query = "SELECT * FROM retrieve_all_from_camera";
        List<Camera> camere = null;
        Camera camera = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

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
        String query = "{call update_camera(?,?,?,?,?,?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), object.getIdCamera());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Camera object) {
        String delete = "{call delete_from_camera(?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            handler.getStatement().setInt(1, object.getIdCamera());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

