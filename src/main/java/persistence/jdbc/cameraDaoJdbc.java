package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Camera;
import persistence.PersistenceException;
import persistence.cameraDao;
public class cameraDaoJdbc implements cameraDao {
    private Camera extractTo(ResultSet set) throws SQLException{

        Camera obj = new Camera();
        obj.setIdCamera(set.getInt("id_camera"));
        obj.setTipologia(set.getInt("fk_tipologia"));
        obj.setNumPersone(set.getInt("fk_nump"));
        obj.setDescrizione(set.getString("descrizione"));
        obj.setImagePath(set.getString("image_path"));
        obj.setPrezzo(set.getDouble("prezzo"));
        return obj;

    }
    @Override
    public void save(Camera object) {
        String query = "{call save_camera(?,?,?,?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getTipologia());
            statement.setInt(2, object.getNumPersone());
            statement.setString(3, object.getDescrizione());
            statement.setString(4, object.getImagePath());
            statement.setDouble(5, object.getPrezzo());
            statement.execute();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Camera retrieve(Camera object) {
        String query = "SELECT * FROM camera where id_camera=?";
        Camera camera = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdCamera());

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                camera=extractTo(result);
            }
            return camera;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Camera> retrieveAll() {
        String query = "SELECT * FROM camera";
        List<Camera> camere = null;
        Camera camera = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                camere = new ArrayList<Camera>();
                while (result.next()) {
                    camera=extractTo(result);
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
            PreparedStatement statement = handler.getStatement();
            statement.setInt(2, object.getTipologia());
            statement.setInt(3, object.getNumPersone());
            statement.setString(4, object.getDescrizione());
            statement.setString(5, object.getImagePath());
            statement.setDouble(6, object.getPrezzo());
            statement.setInt(1, object.getIdCamera());
            handler.executeUpdate();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Camera object) {
        String delete = "{call delete_from_camera(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            PreparedStatement smt = handler.getStatement();
            smt.setInt(1, object.getIdCamera());

            handler.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

