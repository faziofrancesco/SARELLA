package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Camera implements Serializable {

    private static final long serialVersionUID = 5872710316948492959L;

    private Integer idCamera;
    private Integer tipologia;
    private Integer numPersone;
    private BigDecimal prezzo;
    private String descrizione;
    private String imagePath;

    public Camera(Integer idCamera, Integer tipologia, Integer numPersone, BigDecimal prezzo, String descrizione, String imagePath) {
        this.idCamera = idCamera;
        this.tipologia = tipologia;
        this.numPersone = numPersone;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.imagePath = imagePath;
    }

    public Camera() {
    }

    public Integer getIdCamera() {
        return idCamera;
    }

    public void setIdCamera(Integer idCamera) {
        this.idCamera = idCamera;
    }

    public Integer getTipologia() {
        return tipologia;
    }

    public void setTipologia(Integer tipologia) {
        this.tipologia = tipologia;
    }

    public Integer getNumPersone() {
        return numPersone;
    }

    public void setNumPersone(Integer numPersone) {
        this.numPersone = numPersone;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
