package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tipologia;
import persistence.PersistenceException;
import persistence.tipologiaDao;
public class tipologiaDaoJdbc implements  tipologiaDao {
    @Override
    public void save(Tipologia object) {

    }

    @Override
    public Tipologia retrieve(Tipologia object) {
        return null;
    }

    @Override
    public List<Tipologia> retrieveAll() {
        return null;
    }

    @Override
    public void update(Tipologia object) {

    }

    @Override
    public void delete(Tipologia object) {

    }
}
