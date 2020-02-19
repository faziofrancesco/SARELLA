package model;

public class NumPersone {
    private Integer idNumPersone;
    private Integer numPersone;

    public NumPersone(Integer idNumPersone, Integer numPersone) {
        this.idNumPersone = idNumPersone;
        this.numPersone = numPersone;
    }

    public NumPersone() {
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
