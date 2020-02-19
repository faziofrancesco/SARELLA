package model;

import java.io.Serializable;

public class Tipologia implements Serializable {

    private static final long serialVersionUID = 9177833561969410176L;

    private Integer idTipologia;
    private String tipologia;

    public Tipologia(Integer idTipologia, String tipologia) {
        this.idTipologia = idTipologia;
        this.tipologia = tipologia;
    }

    public Tipologia() {
    }

    public Integer getIdTipologia() {
        return idTipologia;
    }

    public void setIdTipologia(Integer idTipologia) {
        this.idTipologia = idTipologia;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
}
