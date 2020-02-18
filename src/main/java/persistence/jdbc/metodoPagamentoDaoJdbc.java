package persistence.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Camera;
import model.Commento;
import model.MetodoPagamento;
import persistence.PersistenceException;
import persistence.metodoPagamentoDao;
public class metodoPagamentoDaoJdbc implements metodoPagamentoDao {
    private MetodoPagamento extractTo(ResultSet set) throws SQLException{

        MetodoPagamento obj = new MetodoPagamento();
        obj.setMetodoPagamento(set.getInt("id_metodo_pagamento"));
        obj.setNumeroCarta(set.getString("numero_carta"));
        obj.setCcv(set.getInt("ccv"));
        obj.setDate(set.getDate("data_scadenza"));
        return obj;

    }
    @Override
    public void save(MetodoPagamento object) {
        String query = "{call save_metodo_pagamento(?,?,?)}";


        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            PreparedStatement statement = handler.getStatement();
            statement.setString(1, object.getNumeroCarta());
            statement.setInt(2, object.getCcv());
            statement.setDate(3, object.getDate());

            statement.execute();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public MetodoPagamento retrieve(MetodoPagamento object) {
        String query = "SELECT * FROM metodo_pagamento where id_metodo_pagamento=?";
        MetodoPagamento metodopagamento = null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
            handler.getStatement().setInt(1, object.getMetodoPagamento());

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                result.next();
                metodopagamento=extractTo(result);
            }
            return metodopagamento;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<MetodoPagamento> retrieveAll() {
        String query = "SELECT * FROM metodo_pagamento";
        List<MetodoPagamento> metodopagamenti = null;
        MetodoPagamento metodopagamento= null;

        try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

            handler.executeQuery();

            if (handler.existsResultSet()) {

                ResultSet result = handler.getResultSet();
                metodopagamenti = new ArrayList<MetodoPagamento>();
                while (result.next()) {
                    metodopagamento=extractTo(result);
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
            PreparedStatement statement = handler.getStatement();
            statement.setInt(1, object.getMetodoPagamento());
            statement.setString(2, object.getNumeroCarta());
            statement.setInt(3, object.getCcv());
            statement.setDate(4, object.getDate());
            handler.executeUpdate();

        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(MetodoPagamento object) {
        String delete = "{call delete_from_metodo_pagamento(?)}";
        try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

            PreparedStatement smt = handler.getStatement();
            smt.setInt(1, object.getMetodoPagamento());

            handler.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
