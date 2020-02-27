package persistence;

import model.Admin;

public interface AdminDao extends Dao<Admin> {
    Admin retrieveByUser(Integer id);
}

