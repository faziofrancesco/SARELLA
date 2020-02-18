package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Prenotazione;
import persistence.PersistenceException;
import persistence.prenotazioneDao;
public class prenotazioneDaoJdbc implements prenotazioneDao{
    @Override
    public void save(Prenotazione object) {

    }

    @Override
    public Prenotazione retrieve(Prenotazione object) {
        return null;
    }

    @Override
    public List<Prenotazione> retrieveAll() {
        return null;
    }

    @Override
    public void update(Prenotazione object) {

    }

    @Override
    public void delete(Prenotazione object) {

    }
}
