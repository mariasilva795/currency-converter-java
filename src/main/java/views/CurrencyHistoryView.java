package  views;

import Records.CurrencyHistory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CurrencyHistoryView {

    public void show(List<CurrencyHistory> historyList){

        for (CurrencyHistory history : historyList){

            System.out.printf("\n**************************************************\n" +
                            "FROM: %s\n" +
                            "TO: %s\n" +
                            "RESULT: %,.2f\n" +
                            "DATE: %s\n" +
                            "**************************************************\n",
                    history.base_code(), history.target_code(), history.amountConverted(), history.dateTime());

        }

    }
}