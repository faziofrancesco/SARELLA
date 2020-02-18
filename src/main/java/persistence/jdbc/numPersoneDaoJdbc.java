package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Numpersone;
import persistence.PersistenceException;
import persistence.numPersoneDao;
public class numPersoneDaoJdbc implements numPersoneDao {
    @Override
    public void save(Numpersone object) {

    }

    @Override
    public Numpersone retrieve(Numpersone object) {
        return null;
    }

    @Override
    public List<Numpersone> retrieveAll() {
        return null;
    }

    @Override
    public void update(Numpersone object) {

    }

    @Override
    public void delete(Numpersone object) {

    }
}
