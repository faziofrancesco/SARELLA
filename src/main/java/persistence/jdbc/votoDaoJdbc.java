package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Voto;
import persistence.PersistenceException;
import persistence.votoDao;
public class votoDaoJdbc implements votoDao{
    @Override
    public void save(Voto object) {

    }

    @Override
    public Voto retrieve(Voto object) {
        return null;
    }

    @Override
    public List<Voto> retrieveAll() {
        return null;
    }

    @Override
    public void update(Voto object) {

    }

    @Override
    public void delete(Voto object) {

    }
}
