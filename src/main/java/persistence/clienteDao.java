package persistence;
import model.Cliente;
public interface clienteDao extends Dao<Cliente>{
    Cliente retrieveByEmail(String email);
}
