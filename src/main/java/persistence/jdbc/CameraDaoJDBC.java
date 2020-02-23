package persistence.jdbc;

import model.Camera;
import persistence.CameraDao;
import persistence.PersistenceException;

import java.sql.*;
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

    private void insertInto(Camera object, PreparedStatement statement, Integer id, boolean keepPreviousValues) throws SQLException {

        int index = 0;
        if (id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        Camera old = null;
        if (keepPreviousValues) {
            old = retrieve(object);
        }

        if (object.getTipologia() != null) {
            statement.setInt(index + 1, object.getTipologia());
        } else if (!keepPreviousValues) {
            statement.setNull(index + 1, Types.INTEGER);
        } else {
            statement.setInt(index + 1, old.getTipologia());
        }

        if (object.getNumPersone() != null) {
            statement.setInt(index + 2, object.getNumPersone());
        } else if (!keepPreviousValues) {
            statement.setNull(index + 2, Types.INTEGER);
        } else {
            statement.setInt(index + 2, old.getNumPersone());
        }

        if (object.getNumPersone() != null) {
            statement.setString(index + 3, object.getDescrizione());
        } else if (keepPreviousValues) {
            statement.setString(index + 3, old.getDescrizione());
        }

        if (object.getPrezzo() != null) {
            statement.setBigDecimal(index + 5, object.getPrezzo());
        } else if (keepPreviousValues) {
            statement.setBigDecimal(index + 5, old.getPrezzo());
        }

        if (object.getImagePath() != null) {
            statement.setString(index + 4, object.getImagePath());
        } else {
            statement.setNull(index + 4, Types.VARCHAR);
        }
    }

    @Override
    public void save(Camera object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_camera(?,?,?,?,?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdCamera(), false);
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
        List<Camera> camere = new ArrayList<Camera>();
        Camera camera = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_camera")) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();

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
            insertInto(object, handler.getStatement(), object.getIdCamera(), true);
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

    @Override
    public List<Camera> retrieveInRange(Date min, Date max) {

        List<Camera> camere = null;
        Camera camera = null;
        try(JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_by_date_range_from_camera(?,?)")) {

            handler.getStatement().setDate(1, min);
            handler.getStatement().setDate(2, max);
            handler.execute();

            if (handler.existsResultSet()) {

                camere = new ArrayList<>();
                ResultSet result = handler.getResultSet();

                while (result.next()) {
                    camera = extractFrom(result);
                    camere.add(camera);
                }
            }

            return camere;

        } catch(SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }
}

