package model;

import java.sql.Date;

public class MetodoPagamento {
    private Integer idMetodoPagamento;
    private String numeroCarta;
    private Integer ccv;
    private Date date;

    public MetodoPagamento(Integer idMetodoPagamento, String numeroCarta, Integer ccv, Date date) {
        this.idMetodoPagamento = idMetodoPagamento;
        this.numeroCarta = numeroCarta;
        this.ccv = ccv;
        this.date = date;
    }

    public MetodoPagamento() {
    }

    public Integer getIdMetodoPagamento() {
        return idMetodoPagamento;
    }

    public void setIdMetodoPagamento(Integer metodoPagamento) {
        this.idMetodoPagamento = metodoPagamento;
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(String numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public Integer getCcv() {
        return ccv;
    }

    public void setCcv(Integer ccv) {
        this.ccv = ccv;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
