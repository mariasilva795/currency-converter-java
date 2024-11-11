package Utils;

import Records.Currency;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CurrencyDeserializer implements JsonDeserializer<Currency> {

    @Override
    public Currency deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String baseCode = jsonObject.has("base_code") && !jsonObject.get("base_code").isJsonNull()
                ? jsonObject.get("base_code").getAsString() : null;

        String targetCode = jsonObject.has("target_code") && !jsonObject.get("target_code").isJsonNull()
                ? jsonObject.get("target_code").getAsString() : null;

        double conversionRate = jsonObject.has("conversion_rate") && !jsonObject.get("conversion_rate").isJsonNull()
                ? jsonObject.get("conversion_rate").getAsDouble() : 0.0;

        double conversionResult = jsonObject.has("conversion_result") && !jsonObject.get("conversion_result").isJsonNull()
                ? jsonObject.get("conversion_result").getAsDouble() : 0.0;

        ArrayList<ArrayList<String>> supportedCodes = jsonObject.has("supported_codes") && !jsonObject.get("supported_codes").isJsonNull()
                ? context.deserialize(jsonObject.get("supported_codes"), ArrayList.class)
                : new ArrayList<>();

        // Return a new Currency object with extracted values
        return new Currency(baseCode, targetCode, conversionRate, conversionResult, supportedCodes);
    }
}
