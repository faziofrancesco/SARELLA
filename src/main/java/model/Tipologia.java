package model;

public class Tipologia {
    private Integer idTipologia;
    private Integer tipologia;

    public Tipologia(Integer idTipologia, Integer tipologia) {
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

    public Integer getTipologia() {
        return tipologia;
    }

    public void setTipologia(Integer tipologia) {
        this.tipologia = tipologia;
    }
}
