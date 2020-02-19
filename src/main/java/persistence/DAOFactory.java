package persistence;

public abstract class DAOFactory {

    public abstract ClienteDao getClienteDao();

    public abstract CameraDao getCameraDao();

    public abstract PrenotazioneDao getPrenotazioneDao();

    public abstract OrdineDao getOrdineDao();

    public abstract PagamentoDao getPagamentoDao();

    public abstract CommentoDao getCommentoDao();

    public abstract MetodoPagamentoDao getMetodoPagamentoDao();

    public abstract NumPersoneDao getNumPersoneDao();

    public abstract RecensioneDao getRecensioneDao();

    public abstract TipologiaDao getTipologiaDao();

    public abstract VotoDao getVotoDao();
}
