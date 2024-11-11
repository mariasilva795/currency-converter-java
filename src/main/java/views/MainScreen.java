package views;

import Records.Currency;
import Records.CurrencyHistory;
import Services.CurrencyServices;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class MainScreen {
    public void showMainScreen() {

        int target_code, base_currency;
        double amount;
        String base_currency_code, target_code_value;

        CurrencyServices record = new CurrencyServices();
        Currency codes = record.showCurrencyCodes();
        ArrayList<ArrayList<String>> listCountrys = codes.supported_codes();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the currency converter!");
        System.out.print("Countries List: " );

        for (int i = 0; i < listCountrys.size(); i++) {
            System.out.printf("%d) %s - %s\n", i, listCountrys.get(i).get(0), listCountrys.get(i).get(1));
        }

        System.out.print("FROM:::" );
        base_currency = sc.nextInt();
        base_currency_code = listCountrys.get(base_currency).get(0);
        System.out.printf("Currency FROM: %s - %s\n\n", base_currency_code, listCountrys.get(base_currency).get(1));

        System.out.print("TO:::::" );
        target_code = sc.nextInt();
        target_code_value =  listCountrys.get(target_code).get(0);

        System.out.printf("Currency TO: %s - %s\n\n", target_code_value, listCountrys.get(target_code).get(1));

        System.out.printf("Amount wish you to convert:::");
        amount = sc.nextDouble();

        Currency currency = record.currencyConversionBaseSearch(base_currency_code, target_code_value, amount);

        System.out.printf("""
                        \n**********************************************************************
                        The convertion %,.2f %s a %s resulted in %,.2f %s
                        **********************************************************************\n
                        """, amount, base_currency_code, target_code_value, currency.conversion_result(), listCountrys.get(target_code).get(0));


//        ArrayList<CurrencyHistory> listHistoryCurrency = new ArrayList();
//        LocalDateTime dateTime = null;
//        CurrencyHistory historyCurrency = new CurrencyHistory(base_currency_code, amount, target_code_value, currency.conversion_result(), dateTime.now().toString() );
//        listHistoryCurrency.add(historyCurrency);

        System.out.println("\nThank you for using the currency converter!");
    }

}
