package model;

public class Numpersone {
    private Integer idNumPersone;
    private Integer numPersone;

    public Numpersone( Integer numPersone) {

        this.numPersone = numPersone;
    }

    public Numpersone() {
    }

    public Integer getIdNumPersone() {
        return idNumPersone;
    }

    public void setIdNumPersone(Integer idNumPersone) {
        this.idNumPersone = idNumPersone;
    }

    public Integer getNumPersone() {
        return numPersone;
    }

    public void setNumPersone(Integer numPersone) {
        this.numPersone = numPersone;
    }
}
