package persistence;

import model.Camera;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface CameraDao extends Dao<Camera> {

    List<Camera> retrieveInRange(Timestamp min, Timestamp max);
    Integer retrieveMeanVote(Integer idCamera);
    List<Camera> retrieveByOrder(Integer idOrdine);
}
