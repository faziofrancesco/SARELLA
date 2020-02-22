package persistence;

import model.Cliente;

public interface ClienteDao extends Dao<Cliente> {
    Cliente retrieveByEmail(String email);

    Cliente  existusernameandpassword(String Username, String Password);
}
