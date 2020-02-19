package persistence;

public abstract class DAOFactory {

    public abstract clienteDao getClienteDao();

    public abstract cameraDao getCameraDao();

    public abstract prenotazioneDao getPrenotazioneDao();

    public abstract ordineDao getOrdineDao();

    public abstract pagamentoDao getPagamentoDao();

    public abstract commentoDao getCommentoDao();

    public abstract metodoPagamentoDao getMetodoPagamentoDao();

    public abstract numPersoneDao getNumPersoneDao();

    public abstract recensioneDao getRecensioneDao();

    public abstract tipologiaDao getTipologiaDao();

    public abstract votoDao getVotoDao();

}
