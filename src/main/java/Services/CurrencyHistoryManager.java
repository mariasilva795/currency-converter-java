package Services;

import Records.CurrencyHistory;
import Repository.CurrencyHistoryRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the history of currency conversions by adding new conversion entries and saving them to a file.
 * This class keeps a record of all conversion data and allows retrieval of the conversion history.
 *
 * @author Maria Silva
 * @version 1.0
 * @since 2024
 */
public class CurrencyHistoryManager {

    /**
     * Stores all currency conversion history entries.
     */
    private final CurrencyHistoryRepository repository = new CurrencyHistoryRepositoryImpl();

    /**
     * Adds a new currency conversion entry to the history and saves it to a file.
     *
     * @param baseCurrencyCode the currency code of the base currency from which the conversion is made
     * @param amount the amount in the base currency to be converted
     * @param targetCurrencyCode the currency code of the target currency to which the amount is converted
     * @param conversionResult the result of the conversion in the target currency
     * @param dateTime the date and time of the conversion as a String
     */

    public void addHistory(String baseCurrencyCode, double amount, String targetCurrencyCode, double conversionResult, String dateTime) {

        CurrencyHistory historyCurrency = new CurrencyHistory(
                baseCurrencyCode,
                amount,
                targetCurrencyCode,
                conversionResult,
                LocalDateTime.now().toString()
        );

        repository.save(historyCurrency);
        new CurrencyHistoryFileWriter().writeHistoryToFile(historyCurrency);
    }

    /**
     * Retrieves the list of all currency conversion history entries.
     *
     * @return a list containing all saved currency conversion history entries
     */
    public List<CurrencyHistory> getHistory(){
        return repository.findAll();
    }

    public void deleteHistory(){
        repository.deleteAll();
    }
}
