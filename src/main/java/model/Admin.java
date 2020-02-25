package model;

public class Admin {
    Integer idAdmin;
    Integer fk_cliente;

    public Admin(Integer idAdmin, Integer fk_cliente) {
        this.idAdmin = idAdmin;
        this.fk_cliente = fk_cliente;
    }

    public Admin() {
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getFk_cliente() {
        return fk_cliente;
    }

    public void setFk_cliente(Integer fk_cliente) {
        this.fk_cliente = fk_cliente;
    }
}
