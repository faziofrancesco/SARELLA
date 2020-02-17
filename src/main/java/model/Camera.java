package model;

public class Camera {
    private Integer idCamera;
    private Integer tipologia;
    private Integer numPersone;
    private Double prezzo;
    private String descrizione;
    private String imagePath;

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

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
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

    public Camera(Integer idCamera, Integer tipologia, Integer numPersone, Double prezzo, String descrizione, String imagePath) {
        this.idCamera = idCamera;
        this.tipologia = tipologia;
        this.numPersone = numPersone;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.imagePath = imagePath;
    }

    public Camera() {}
}
