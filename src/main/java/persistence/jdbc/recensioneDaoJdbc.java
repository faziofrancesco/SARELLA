package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Recensione;
import persistence.PersistenceException;
import persistence.recensioneDao;
public class recensioneDaoJdbc implements recensioneDao{
    @Override
    public void save(Recensione object) {

    }

    @Override
    public Recensione retrieve(Recensione object) {
        return null;
    }

    @Override
    public List<Recensione> retrieveAll() {
        return null;
    }

    @Override
    public void update(Recensione object) {

    }

    @Override
    public void delete(Recensione object) {

    }
}
