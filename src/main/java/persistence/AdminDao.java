package persistence;

import model.Admin;
import model.Cliente;
import persistence.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AdminDao extends Dao<Admin> {
    Admin retrieveByUser(Integer id);
}

