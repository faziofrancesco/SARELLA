package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Numpersone;
import model.Ordine;
import persistence.PersistenceException;
import persistence.ordineDao;
public class ordineDaoJdbc implements ordineDao{
        private Ordine extractTo(ResultSet set) throws SQLException{
        Ordine obj = new Ordine();
        obj.setIdOrdine(set.getInt("id_ordine"));
        obj.setIdClienteFk(set.getInt("fk_cliente"));
        obj.setIdPagamentoFk(set.getInt("fk_pagamento"));
        return obj;
    }
    @Override
    public void save(Ordine object) {
        String query = "{call save_ordine(?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdClienteFk());
            statement.setInt(2, object.getIdPagamentoFk());
            statement.execute();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Ordine retrieve(Ordine object) {
        String query = "SELECT * FROM ordine where id_ordine=?";
        Ordine ordine = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getIdOrdine());

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                ordine=extractTo(result);
            }
            return ordine;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Ordine> retrieveAll() {
        String query = "SELECT * FROM ordine";
        List<Ordine> ordini = null;
        Ordine ordine= null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                ordini = new ArrayList<Ordine>();
                while (result.next()) {
                    ordine=extractTo(result);
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
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getIdOrdine());
            statement.setInt(2, object.getIdClienteFk());
            statement.setInt(3, object.getIdPagamentoFk());
            handler.executeUpdate();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(Ordine object) {
        String delete = "{call delete_from_ordine(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            PreparedStatement smt = handler.getStatement();
            smt.setInt(1, object.getIdOrdine());

            handler.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
