package persistence.jdbc;

import model.Ordine;
import persistence.OrdineDao;
import persistence.PersistenceException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class OrdineDaoJDBC implements OrdineDao {

    private Ordine extractTo(ResultSet set) throws SQLException {
        Ordine obj = new Ordine();
        obj.setIdOrdine(set.getInt("id_ordine"));
        obj.setIdClienteFk(set.getInt("fk_cliente"));
        obj.setIdPagamentoFk(set.getInt("fk_pagamento"));
        return obj;
    }

    private void insertInto(Ordine object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if (id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(index + 1, object.getIdClienteFk());
        if (object.getIdPagamentoFk() != null) {
            statement.setInt(index + 2, object.getIdPagamentoFk());
        } else {
            statement.setNull(index + 2, Types.INTEGER);
        }
    }

    @Override
    public void save(Ordine object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT save_ordine(?,?)")) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Ordine retrieve(Ordine object) {
        Ordine ordine = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_by_id_from_ordine(?)")) {
            handler.getStatement().setInt(1, object.getIdOrdine());

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                ordine = extractTo(result);
            }
            return ordine;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Ordine> retrieveAll() {
        List<Ordine> ordini = null;
        Ordine ordine = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT * FROM retrieve_all_from_ordine")) {

            handler.execute();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                ordini = new ArrayList<Ordine>();
                while (result.next()) {
                    ordine = extractTo(result);
                    ordini.add(ordine);
                }
            }

            return ordini;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Ordine object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT update_ordine(?,?,?)")) {
            insertInto(object, handler.getStatement(), object.getIdOrdine());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Ordine object) {

        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT delete_from_ordine(?)")) {

            handler.getStatement().setInt(1, object.getIdOrdine());

            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Integer retrieveTotalPrice(Integer idOrdine) {

        Integer ret = null;
        try (JDBCQueryHandler handler = new JDBCQueryHandler("SELECT retrieve_total_price_for_ordine(?)")) {

            handler.getStatement().setInt(1, idOrdine);
            handler.execute();

            if(handler.existsResultSet()) {
                handler.getResultSet().next();
                ret = handler.getResultSet().getInt("sum_prices");
            }

            return ret;

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }

    }
}
