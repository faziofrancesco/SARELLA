package model;

public class GoogleUser {
    Integer idGoogle;
    Integer fk_cliente;

    public GoogleUser(Integer idGoogle, Integer fk_cliente) {
        this.idGoogle = idGoogle;
        this.fk_cliente = fk_cliente;
    }

    public GoogleUser() {
    }

    public Integer getIdGoogle() {
        return idGoogle;
    }

    public void setIdGoogle(Integer idGoogle) {
        this.idGoogle = idGoogle;
    }

    public Integer getFk_cliente() {
        return fk_cliente;
    }

    public void setFk_cliente(Integer fk_cliente) {
        this.fk_cliente = fk_cliente;
    }
}
