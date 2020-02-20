package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1517679055274660590L;

    private Integer idPagamento;
    private Integer idMetodoPagamentoFk;
    private BigDecimal importo;
    private Timestamp dataPagamento;

    public Pagamento(Integer idPagamento, Integer idMetodoPagamentoFk, BigDecimal importo, Timestamp dataPagamento) {
        this.idPagamento = idPagamento;
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

    public BigDecimal getImporto() {
        return importo;
    }

    public void setImporto(BigDecimal importo) {
        this.importo = importo;
    }

    public Timestamp getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Timestamp dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
