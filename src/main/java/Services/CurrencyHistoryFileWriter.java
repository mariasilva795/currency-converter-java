package Services;

import Records.CurrencyHistory;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class CurrencyHistoryFileWriter {

    public void writeHistoryToFile(CurrencyHistory listHistoryCurrency){

        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("historyCurrency.json")){
                writer.write(gson.toJson(listHistoryCurrency));
                System.out.println("History successfully written to historyCurrency.json");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
