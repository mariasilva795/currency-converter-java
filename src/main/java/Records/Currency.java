package Queries;

import java.util.ArrayList;

public record Currency(String fromCode, String toCode, double conversionRate, double conversionResult, ArrayList<ArrayList<String>> supported_codes) {
}
