package persistence.jdbc;

import model.MetodoPagamento;
import persistence.PersistenceException;
import persistence.MetodoPagamentoDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetodoPagamentoDaoJDBC implements MetodoPagamentoDao {

    private MetodoPagamento extractTo(ResultSet set) throws SQLException {

        MetodoPagamento obj = new MetodoPagamento();
        obj.setIdMetodoPagamento(set.getInt("id_metodo_pagamento"));
        obj.setNumeroCarta(set.getString("numero_carta"));
        obj.setCcv(set.getInt("ccv"));
        obj.setDate(set.getDate("data_scadenza"));
        return obj;

    }

    private void insertInto(MetodoPagamento object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if(id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setString(index + 1, object.getNumeroCarta());
        statement.setInt(index + 2, object.getCcv());
        statement.setDate(index + 3, object.getDate());
    }

    @Override
    public void save(MetodoPagamento object) {
        String query = "{call save_metodo_pagamento(?,?,?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public MetodoPagamento retrieve(MetodoPagamento object) {
        String query = "{call retrieve_by_id_from_metodop(?)}";
        MetodoPagamento metodopagamento = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdMetodoPagamento());
            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                metodopagamento = extractTo(result);
            }
            return metodopagamento;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<MetodoPagamento> retrieveAll() {
        String query = "SELECT * FROM retrieve_all_from_metodop";
        List<MetodoPagamento> metodopagamenti = null;
        MetodoPagamento metodopagamento = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                metodopagamenti = new ArrayList<MetodoPagamento>();
                while (result.next()) {
                    metodopagamento = extractTo(result);
                    metodopagamenti.add(metodopagamento);
                }
            }

            return metodopagamenti;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(MetodoPagamento object) {
        String query = "{call update_metodo_pagamento(?,?,?,?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), object.getIdMetodoPagamento());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(MetodoPagamento object) {
        String delete = "{call delete_from_metodo_pagamento(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            handler.getStatement().setInt(1, object.getIdMetodoPagamento());
            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
