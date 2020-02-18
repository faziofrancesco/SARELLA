package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pagamento;
import persistence.PersistenceException;
import persistence.pagamentoDao;
public class pagamentoDaoJdbc implements pagamentoDao{
    @Override
    public void save(Pagamento object) {

    }

    @Override
    public Pagamento retrieve(Pagamento object) {
        return null;
    }

    @Override
    public List<Pagamento> retrieveAll() {
        return null;
    }

    @Override
    public void update(Pagamento object) {

    }

    @Override
    public void delete(Pagamento object) {

    }
}
