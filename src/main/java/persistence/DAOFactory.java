package persistence;

import persistence.jdbc.PostgresDAOFactory;

public abstract class DAOFactory {

	/**
	 * Numeric constant '1' corresponds to explicit Hsqldb choice
	 */
	public static final int HSQLDB = 1;

	/**
	 * Numeric constant '2' corresponds to explicit Postgres choice
	 */
	public static final int POSTGRESQL = 2;

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {

		case HSQLDB:
			return null;
		case POSTGRESQL:
			return new PostgresDAOFactory();
		default:
			return null;
		}
	}

	// --- Factory specification: concrete factories implementing this spec must
	// provide this methods! ---

	public abstract clienteDao getClienteDao();
	public abstract cameraDao getCameraDao();
	public abstract prenotazioneDao getPrenotazioneDao();
	public abstract ordineDao getOrdineDao();
	public abstract pagamentoDao getPagamentoDao();
	public abstract commentoDao getCommentoDao();
	public abstract  metodoPagamentoDao getMetodoPagamentoDao();
	public abstract  numPersoneDao getNumPersoneDao();
	public abstract  recensioneDao getRecensioneDao();
	public abstract  tipologiaDao getTipologiaDao();
	public abstract  votoDao getVotoDao();

}
