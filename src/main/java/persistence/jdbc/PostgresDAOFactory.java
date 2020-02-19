package persistence.jdbc;

import persistence.*;


public class PostgresDAOFactory extends DAOFactory {


    @Override
    public clienteDao getClienteDao() {
        return new ClienteDaoJDBC();
    }

    @Override
    public cameraDao getCameraDao() {
        return new CameraDaoJDBC();
    }

    @Override
    public prenotazioneDao getPrenotazioneDao() {
        return new PrenotazioneDaoJDBC();
    }

    @Override
    public ordineDao getOrdineDao() {
        return new OrdineDaoJDBC();
    }

    @Override
    public pagamentoDao getPagamentoDao() {
        return new PagamentoDaoJDBC();
    }

    @Override
    public commentoDao getCommentoDao() {
        return new CommentoDaoJDBC();
    }

    @Override
    public metodoPagamentoDao getMetodoPagamentoDao() {
        return new MetodoPagamentoDaoJDBC();
    }

    @Override
    public numPersoneDao getNumPersoneDao() {
        return new NumPersoneDaoJDBC();
    }

    @Override
    public recensioneDao getRecensioneDao() {
        return new RecensioneDaoJDBC();
    }

    @Override
    public tipologiaDao getTipologiaDao() {
        return new TipologiaDaoJDBC();
    }

    @Override
    public votoDao getVotoDao() {
        return new VotoDaoJDBC();
    }
}
