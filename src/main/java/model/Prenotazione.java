package model;

import java.sql.Timestamp;

public class Prenotazione {
    private Integer idPrenotazione;
    private Integer idOrdineFk;
    private Integer idCameraFk;
    private Timestamp dataCheckIn;
    private Timestamp dataCheckout;

    public Prenotazione(Integer idPrenotazione, Integer idOrdineFk, Integer idCameraFk, Timestamp dataCheckIn, Timestamp dataCheckout) {
        this.idPrenotazione = idPrenotazione;
        this.idOrdineFk = idOrdineFk;
        this.idCameraFk = idCameraFk;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckout = dataCheckout;
    }

    public Prenotazione() {
    }

    public Integer getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(Integer idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public Integer getIdOrdineFk() {
        return idOrdineFk;
    }

    public void setIdOrdineFk(Integer idOrdineFk) {
        this.idOrdineFk = idOrdineFk;
    }

    public Integer getIdCameraFk() {
        return idCameraFk;
    }

    public void setIdCameraFk(Integer idCameraFk) {
        this.idCameraFk = idCameraFk;
    }

    public Timestamp getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(Timestamp dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public Timestamp getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(Timestamp dataCheckout) {
        this.dataCheckout = dataCheckout;
    }
}
