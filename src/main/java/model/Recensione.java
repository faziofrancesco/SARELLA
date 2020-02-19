package model;

import java.sql.Timestamp;

public class Recensione {
    private Integer idRecensione;
    private Integer idClienteFk;
    private Integer idOrdineFk;
    private Integer idVotoFk;
    private String descrizione;
    private Timestamp dataRecensione;

    public Recensione(Integer idRecensione, Integer idClienteFk, Integer idOrdineFk, Integer idVotoFk, String descrizione, Timestamp dataRecensione) {
        this.idRecensione = idRecensione;
        this.idClienteFk = idClienteFk;
        this.idOrdineFk = idOrdineFk;
        this.idVotoFk = idVotoFk;
        this.descrizione = descrizione;
        this.dataRecensione = dataRecensione;
    }

    public Recensione() {
    }

    public Integer getIdRecensione() {
        return idRecensione;
    }

    public void setIdRecensione(Integer idRecensione) {
        this.idRecensione = idRecensione;
    }

    public Integer getIdClienteFk() {
        return idClienteFk;
    }

    public void setIdClienteFk(Integer idClienteFk) {
        this.idClienteFk = idClienteFk;
    }

    public Integer getIdOrdineFk() {
        return idOrdineFk;
    }

    public void setIdOrdineFk(Integer idOrdineFk) {
        this.idOrdineFk = idOrdineFk;
    }

    public Integer getIdVotoFk() {
        return idVotoFk;
    }

    public void setIdVotoFk(Integer idVotoFk) {
        this.idVotoFk = idVotoFk;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Timestamp getDataRecensione() {
        return dataRecensione;
    }

    public void setDataRecensione(Timestamp dataRecensione) {
        this.dataRecensione = dataRecensione;
    }
}
