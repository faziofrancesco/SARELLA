package persistence;

import model.Cliente;

public interface ClienteDao extends Dao<Cliente> {
    Cliente retrieveByEmail(String email);

    Boolean existusernameandpassword(String Username, String Password);
}
