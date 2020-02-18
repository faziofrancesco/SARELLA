package model;

import java.sql.Timestamp;

public class Commento {
    private Integer idCommento;
    private Integer idClienteFk;
    private Integer idRecensioneFk;
    private String contenuto;
    private Timestamp dataCommento;

    public Commento(Integer idCommento, Integer idClienteFk, Integer idRecensioneFk, String contenuto, Timestamp dataCommento) {
        this.idCommento = idCommento;
        this.idClienteFk = idClienteFk;
        this.idRecensioneFk = idRecensioneFk;
        this.contenuto = contenuto;
        this.dataCommento = dataCommento;
    }

    public Commento() {}

    public Integer getIdCommento() {
        return idCommento;
    }

    public void setIdCommento(Integer idCommento) {
        this.idCommento = idCommento;
    }

    public Integer getIdClienteFk() {
        return idClienteFk;
    }

    public void setIdClienteFk(Integer idClienteFk) {
        this.idClienteFk = idClienteFk;
    }

    public Integer getIdRecensioneFk() {
        return idRecensioneFk;
    }

    public void setIdRecensioneFk(Integer idRecensioneFk) {
        this.idRecensioneFk = idRecensioneFk;
    }

    public String getContenuto() {
        return Contenuto;
    }

    public void setContenuto(String contenuto) {
        Contenuto = contenuto;
    }

    public Timestamp getDataCommento() {
        return dataCommento;
    }

    public void setDataCommento(Timestamp dataCommento) {
        this.dataCommento = dataCommento;
    }
}
