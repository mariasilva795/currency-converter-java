package Services;

import Records.Currency;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyServices {

    private static final String API_KEY = "c6b78493c77b8545bd8c3d70";

    public Currency currencyConversionBaseSearch(String fromCode, String toCode, double amount) {

        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/"
                + fromCode + "/" + toCode + "/" + amount;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Currency.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
