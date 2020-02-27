package persistence;

import model.Prenotazione;

public interface PrenotazioneDao extends Dao<Prenotazione> {
    void deleteprenotazione(Integer id,Integer c);
}
