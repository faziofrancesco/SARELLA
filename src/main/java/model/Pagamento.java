package model;

import java.sql.Timestamp;

public class Pagamento {
    private Integer idPagamento;
    private Integer idMetodoPagamentoFk;
    private Double importo;
    private Timestamp dataPagamento;

    public Pagamento( Integer idMetodoPagamentoFk, Double importo, Timestamp dataPagamento) {
        this.idMetodoPagamentoFk = idMetodoPagamentoFk;
        this.importo = importo;
        this.dataPagamento = dataPagamento;
    }

    public Pagamento() {
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Integer getIdMetodoPagamentoFk() {
        return idMetodoPagamentoFk;
    }

    public void setIdMetodoPagamentoFk(Integer idMetodoPagamentoFk) {
        this.idMetodoPagamentoFk = idMetodoPagamentoFk;
    }

    public Double getImporto() {
        return importo;
    }

    public void setImporto(Double importo) {
        this.importo = importo;
    }

    public Timestamp getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Timestamp dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
