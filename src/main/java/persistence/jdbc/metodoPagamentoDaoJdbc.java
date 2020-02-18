package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MetodoPagamento;
import persistence.PersistenceException;
import persistence.metodoPagamentoDao;
public class metodoPagamentoDaoJdbc implements metodoPagamentoDao {
    @Override
    public void save(MetodoPagamento object) {

    }

    @Override
    public MetodoPagamento retrieve(MetodoPagamento object) {
        return null;
    }

    @Override
    public List<MetodoPagamento> retrieveAll() {
        return null;
    }

    @Override
    public void update(MetodoPagamento object) {

    }

    @Override
    public void delete(MetodoPagamento object) {

    }
}
