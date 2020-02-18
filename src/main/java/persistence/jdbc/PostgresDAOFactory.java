package persistence.jdbc;
import persistence.*;


public class PostgresDAOFactory extends DAOFactory {


	@Override
	public clienteDao getClienteDao() {
		return new clienteDaoJdbc();
	}

	@Override
	public cameraDao getCameraDao() {
		return new cameraDaoJdbc();
	}

	@Override
	public prenotazioneDao getPrenotazioneDao() {
		return new prenotazioneDaoJdbc();
	}

	@Override
	public ordineDao getOrdineDao() {
		return new ordineDaoJdbc();
	}

	@Override
	public pagamentoDao getPagamentoDao() {
		return new pagamentoDaoJdbc();
	}

	@Override
	public commentoDao getCommentoDao() {
		return new commentoDaoJdbc();
	}

	@Override
	public metodoPagamentoDao getMetodoPagamentoDao() {
		return new metodoPagamentoDaoJdbc();
	}

	@Override
	public numPersoneDao getNumPersoneDao() {
		return new numPersoneDaoJdbc();
	}

	@Override
	public recensioneDao getRecensioneDao() {
		return new recensioneDaoJdbc();
	}

	@Override
	public tipologiaDao getTipologiaDao() {
		return new  tipologiaDaoJdbc();
	}

	@Override
	public votoDao getVotoDao() {
		return new votoDaoJdbc();
	}
}
