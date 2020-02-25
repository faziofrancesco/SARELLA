package persistence;

import model.Recensione;

import java.util.List;

public interface RecensioneDao extends Dao<Recensione> {

    List<Recensione> retrieveByRoom(Integer idCamera);
}
