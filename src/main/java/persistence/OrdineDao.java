package persistence;

import model.Ordine;

import java.math.BigDecimal;

public interface OrdineDao extends Dao<Ordine> {

    BigDecimal retrieveTotalPrice(Integer idOrdine);
    Integer retrieveByUser(Integer Cliente);

}
