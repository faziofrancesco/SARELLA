package persistence.jdbc;

import model.Ordine;
import persistence.PersistenceException;
import persistence.ordineDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdineDaoJDBC implements ordineDao {

    private Ordine extractTo(ResultSet set) throws SQLException {
        Ordine obj = new Ordine();
        obj.setIdOrdine(set.getInt("id_ordine"));
        obj.setIdClienteFk(set.getInt("fk_cliente"));
        obj.setIdPagamentoFk(set.getInt("fk_pagamento"));
        return obj;
    }

    private void insertInto(Ordine object, PreparedStatement statement, Integer id) throws SQLException {

        int index = 0;
        if(id != null) {
            statement.setInt(1, id);
            index = 1;
        }

        statement.setInt(index + 1, object.getIdClienteFk());
        statement.setInt(index + 2, object.getIdPagamentoFk());
    }

    @Override
    public void save(Ordine object) {
        String query = "{call save_ordine(?,?)}";

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), null);
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Ordine retrieve(Ordine object) {
        String query = "{call retrieve_by_id_from_ordine(?)}";
        Ordine ordine = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
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
        String query = "SELECT * FROM retrieve_all_from_ordine";
        List<Ordine> ordini = null;
        Ordine ordine = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

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
        String query = "{call update_ordine(?,?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            insertInto(object, handler.getStatement(), object.getIdOrdine());
            handler.execute();

        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Ordine object) {
        String delete = "{call delete_from_ordine(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            handler.getStatement().setInt(1, object.getIdOrdine());

            handler.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
