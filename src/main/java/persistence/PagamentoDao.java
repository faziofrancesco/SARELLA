package persistence;

import model.Pagamento;

public interface PagamentoDao extends Dao<Pagamento> {
    Pagamento retrieveLastPaypment();
}
