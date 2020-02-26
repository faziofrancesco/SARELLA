package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Prenotazione implements Serializable {

    private static final long serialVersionUID = 6002181924151099461L;

    private Integer idPrenotazione;
    private Integer idOrdineFk;
    private Integer idCameraFk;
    private Date dataCheckIn;
    private Date dataCheckout;

    public Prenotazione(Integer idPrenotazione, Integer idOrdineFk, Integer idCameraFk, Date dataCheckIn, Date dataCheckout) {
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

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(Date dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public Date getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(Date dataCheckout) {
        this.dataCheckout = dataCheckout;
    }
}
