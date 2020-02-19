package persistence.jdbc;

import persistence.*;


public class PostgresDAOFactory extends DAOFactory {


    @Override
    public ClienteDao getClienteDao() {
        return new ClienteDaoJDBC();
    }

    @Override
    public CameraDao getCameraDao() {
        return new CameraDaoJDBC();
    }

    @Override
    public PrenotazioneDao getPrenotazioneDao() {
        return new PrenotazioneDaoJDBC();
    }

    @Override
    public OrdineDao getOrdineDao() {
        return new OrdineDaoJDBC();
    }

    @Override
    public PagamentoDao getPagamentoDao() {
        return new PagamentoDaoJDBC();
    }

    @Override
    public CommentoDao getCommentoDao() {
        return new CommentoDaoJDBC();
    }

    @Override
    public MetodoPagamentoDao getMetodoPagamentoDao() {
        return new MetodoPagamentoDaoJDBC();
    }

    @Override
    public NumPersoneDao getNumPersoneDao() {
        return new NumPersoneDaoJDBC();
    }

    @Override
    public RecensioneDao getRecensioneDao() {
        return new RecensioneDaoJDBC();
    }

    @Override
    public TipologiaDao getTipologiaDao() {
        return new TipologiaDaoJDBC();
    }

    @Override
    public VotoDao getVotoDao() {
        return new VotoDaoJDBC();
    }
}
