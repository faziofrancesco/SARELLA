package persistence;

import model.Ordine;

import java.math.BigDecimal;
import java.util.List;

public interface OrdineDao extends Dao<Ordine> {

    BigDecimal retrieveTotalPrice(Integer idOrdine);
    Integer retrieveByUser(Integer Cliente);
    List<Ordine> retrieveForStorico(Integer Cliente);

}
