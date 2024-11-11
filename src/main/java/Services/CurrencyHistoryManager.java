package Services;

import Records.CurrencyHistory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CurrencyHistoryManager {

    private final ArrayList<CurrencyHistory> listHistoryCurrency = new ArrayList<>();

    public void addHistory(String baseCurrencyCode, double amount, String targetCurrencyCode, double conversionResult, String string) {

        CurrencyHistory historyCurrency = new CurrencyHistory(
                baseCurrencyCode,
                amount,
                targetCurrencyCode,
                conversionResult,
                LocalDateTime.now().toString()
        );

        new CurrencyHistoryFileWriter().writeHistoryToFile(historyCurrency);

        listHistoryCurrency.add(historyCurrency);

    }

    public List<CurrencyHistory> getHistory(){
        return listHistoryCurrency;
    }
}