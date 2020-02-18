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
    @Override
    public void save(Camera object) {

    }

    @Override
    public Camera retrieve(Camera object) {
        return null;
    }

    @Override
    public List<Camera> retrieveAll() {
        return null;
    }

    @Override
    public void update(Camera object) {

    }

    @Override
    public void delete(Camera object) {

    }
}
