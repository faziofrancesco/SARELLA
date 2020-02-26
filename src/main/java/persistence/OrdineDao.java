package persistence;

import model.Ordine;

public interface OrdineDao extends Dao<Ordine> {

    Integer retrieveTotalPrice(Integer idOrdine);
    Integer retrieveByUser(Integer Cliente);

}
