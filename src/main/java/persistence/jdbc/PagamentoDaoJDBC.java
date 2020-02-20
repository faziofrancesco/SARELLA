package persistence.jdbc;

import model.Pagamento;
import persistence.PersistenceException;
import persistence.PagamentoDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDaoJDBC implements PagamentoDao {

    private Pagamento extractTo(ResultSet set) throws SQLException {
        Pagamento obj = new Pagamento();
        obj.setIdPagamento(set.getInt("id_pagamento"));
        obj.setIdMetodoPagamentoFk(set.getInt("fk_metodop"));
        obj.setImporto(set.getBigDecimal("importo"));
        obj.setDataPagamento(set.getTimestamp("data_pagamento"));
        return obj;
    }

    private void insertInto(Pagamento object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if(id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(index + 1, object.getIdMetodoPagamentoFk());
        statement.setBigDecimal(index + 2, object.getImporto());
        statement.setTimestamp(index + 3, object.getDataPagamento());
    }

    @Override
    public void save(Pagamento object) {
        String query = "{call save_pagamento(?,?,?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Pagamento retrieve(Pagamento object) {
        String query = "{call retrieve_by_id_from_pagamento(?)}";
        Pagamento pagamento = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdPagamento());
            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                pagamento = extractTo(result);
            }
            return pagamento;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Pagamento> retrieveAll() {
        String query = "SELECT * FROM retrieve_all_from_pagamento";
        List<Pagamento> pagamenti = null;
        Pagamento pagamento = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                pagamenti = new ArrayList<Pagamento>();
                while (result.next()) {
                    pagamento = extractTo(result);
                    pagamenti.add(pagamento);
                }
            }

            return pagamenti;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Pagamento object) {
        String query = "{call update_pagamento(?,?,?,?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), object.getIdPagamento());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Pagamento object) {
        String delete = "{call delete_from_pagamento(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {
            handler.getStatement().setInt(1, object.getIdPagamento());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
