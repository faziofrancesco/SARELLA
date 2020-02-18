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
    private Pagamento extractTo(ResultSet set) throws SQLException{
        Pagamento obj = new Pagamento();
        obj.setIdPagamento(set.getInt("id_pagamento"));
        obj.setIdMetodoPagamentoFk(set.getInt("fk_metodop"));
        obj.setImporto(set.getDouble("importo"));
        obj.setDataPagamento(set.getTimestamp("data_pagamento"));
        return obj;
    }
    @Override
    public void save(Pagamento object) {
        String query = "{call save_pagamento(?,?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdMetodoPagamentoFk());
            statement.setDouble(2, object.getImporto());
            statement.setTimestamp(3, object.getDataPagamento());
            statement.execute();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Pagamento retrieve(Pagamento object) {
        String query = "SELECT * FROM pagamento where id_pagamento=?";
        Pagamento pagamento = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdPagamento());

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                pagamento=extractTo(result);
            }
            return pagamento;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Pagamento> retrieveAll() {
        String query = "SELECT * FROM pagamento";
        List<Pagamento> pagamenti = null;
        Pagamento pagamento= null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                pagamenti = new ArrayList<Pagamento>();
                while (result.next()) {
                    pagamento=extractTo(result);
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
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdPagamento());
            statement.setInt(2, object.getIdMetodoPagamentoFk());
            statement.setDouble(3, object.getImporto());
            statement.setTimestamp(4, object.getDataPagamento());
            handler.executeUpdate();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Pagamento object) {
        String delete = "{call delete_from_pagamento(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            PreparedStatement smt = handler.getStatement();
            smt.setInt(1, object.getIdPagamento());

            handler.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
