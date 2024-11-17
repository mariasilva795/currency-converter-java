package Repository;

import Records.CurrencyHistory;

import java.util.List;

public interface CurrencyHistoryRepository {
    void save(CurrencyHistory history);
    List<CurrencyHistory> findAll();
    void deleteAll();
}
