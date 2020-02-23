package persistence;

import model.Camera;

import java.sql.Date;
import java.util.List;

public interface CameraDao extends Dao<Camera> {

    public List<Camera> retrieveInRange(Date min, Date max);
}
