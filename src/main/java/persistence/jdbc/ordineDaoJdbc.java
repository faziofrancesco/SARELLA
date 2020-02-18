package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ordine;
import persistence.PersistenceException;
import persistence.ordineDao;
public class ordineDaoJdbc implements ordineDao{
    @Override
    public void save(Ordine object) {

    }

    @Override
    public Ordine retrieve(Ordine object) {
        return null;
    }

    @Override
    public List<Ordine> retrieveAll() {
        return null;
    }

    @Override
    public void update(Ordine object) {

    }

    @Override
    public void delete(Ordine object) {

    }
}
