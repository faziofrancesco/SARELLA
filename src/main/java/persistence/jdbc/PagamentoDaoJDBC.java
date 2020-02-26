package persistence.jdbc;

import model.Pagamento;
import persistence.PagamentoDao;
import persistence.PersistenceException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
        if (id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        if (object.getIdMetodoPagamentoFk() != null) {
            statement.setInt(index + 1, object.getIdMetodoPagamentoFk());
        } else {
            statement.setNull(index + 1, Types.INTEGER);
        }

        statement.setBigDecimal(index + 2, object.getImporto());
        statement.setTimestamp(index + 3, object.getDataPagamento());
    }

    @Override
    public void save(Pagamento object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_pagamento(?,?,?)")) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Pagamento retrieve(Pagamento object) {
        Pagamento pagamento = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_by_id_from_pagamento(?)")) {
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
        List<Pagamento> pagamenti = null;
        Pagamento pagamento = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_pagamento")) {

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

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT update_pagamento(?,?,?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdPagamento());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Pagamento object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT delete_from_pagamento(?)")) {
            handler.getStatement().setInt(1, object.getIdPagamento());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Pagamento retrieveLastPaypment() {
        Pagamento pagamento = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM pagamento ORDER BY id_pagamento DESC LIMIT 1")) {

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
}
