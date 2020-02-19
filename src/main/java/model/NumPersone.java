package model;

import java.io.Serializable;

public class NumPersone implements Serializable {

    private static final long serialVersionUID = -109825344657206254L;

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
