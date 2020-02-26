package persistence;

import model.Camera;

import java.sql.Date;
import java.util.List;

public interface CameraDao extends Dao<Camera> {

    List<Camera> retrieveInRange(Date min, Date max);
    Integer retrieveMeanVote(Integer idCamera);
    List<Camera> retrieveByOrder(Integer idOrdine);
}
