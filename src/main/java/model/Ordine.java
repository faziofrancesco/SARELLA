package model;

public class Ordine {
    private Integer idOrdine;
    private Integer idClienteFk;
    private Integer idPagamentoFk;

    public Ordine(Integer idOrdine, Integer idClienteFk, Integer idPagamentoFk) {
        this.idOrdine = idOrdine;
        this.idClienteFk = idClienteFk;
        this.idPagamentoFk = idPagamentoFk;
    }

    public Ordine() {
    }

    public Integer getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Integer idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Integer getIdClienteFk() {
        return idClienteFk;
    }

    public void setIdClienteFk(Integer idClienteFk) {
        this.idClienteFk = idClienteFk;
    }

    public Integer getIdPagamentoFk() {
        return idPagamentoFk;
    }

    public void setIdPagamentoFk(Integer idPagamentoFk) {
        this.idPagamentoFk = idPagamentoFk;
    }
}
