package model;

import java.io.Serializable;

public class Voto implements Serializable {

    private static final long serialVersionUID = -3883462829150385956L;

    private Integer idVoto;
    private Integer voto;

    public Voto(Integer idVoto, Integer voto) {
        this.idVoto = idVoto;
        this.voto = voto;
    }

    public Voto() {
    }

    public Integer getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(Integer idVoto) {
        this.idVoto = idVoto;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }
}
