package model;

import java.sql.Date;

public class MetodoPagamento {
    private Integer metodoPagamento;
    private String numeroCarta;
    private Integer ccv;
    private Date date;

    public MetodoPagamento(Integer metodoPagamento, String numeroCarta, Integer ccv, Date date) {
        this.metodoPagamento = metodoPagamento;
        this.numeroCarta = numeroCarta;
        this.ccv = ccv;
        this.date = date;
    }

    public MetodoPagamento() {}

    public Integer getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(Integer metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
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
