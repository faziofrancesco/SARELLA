package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Commento;
import persistence.PersistenceException;
import persistence.commentoDao;
public class commentoDaoJdbc implements commentoDao{
    @Override
    public void save(Commento object) {

    }

    @Override
    public Commento retrieve(Commento object) {
        return null;
    }

    @Override
    public List<Commento> retrieveAll() {
        return null;
    }

    @Override
    public void update(Commento object) {

    }

    @Override
    public void delete(Commento object) {

    }
}
