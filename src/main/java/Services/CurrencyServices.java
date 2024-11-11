package Services;

import Records.Currency;
import Utils.CurrencyDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyServices {

    private String apiKey = "c6b78493c77b8545bd8c3d70";

    public Currency currencyConversionBaseSearch(String base_code, String target_code, double amount) {

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"
                + base_code + "/" + target_code + "/" + amount;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Currency.class, new CurrencyDeserializer())
                    .create();

            return gson.fromJson(response.body(), Currency.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public Currency showCurrencyCodes(){
        String direction = "https://v6.exchangerate-api.com/v6/" + this.apiKey + "/codes";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direction)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Currency.class, new CurrencyDeserializer())
                    .create();

            return gson.fromJson(response.body(), Currency.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
