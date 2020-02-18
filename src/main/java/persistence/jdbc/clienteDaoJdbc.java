package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import persistence.PersistenceException;
import persistence.clienteDao;

public class clienteDaoJdbc implements clienteDao {
    @Override
    public void save(Cliente object) {

    }

    @Override
    public Cliente retrieve(Cliente object) {
        return null;
    }

    @Override
    public List<Cliente> retrieveAll() {
        return null;
    }

    @Override
    public void update(Cliente object) {

    }

    @Override
    public void delete(Cliente object) {

    }
}
