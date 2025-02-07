package com.currencyexchange.currency.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class CurrencyRateService {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getRates(String base) {
        String url = API_URL + base;
        return restTemplate.getForObject(url, Map.class);
    }

    public double convert(String from, String to, double amount) {
        Map<String, Object> rates = getRates(from);
        Map<String, Double> exchangeRates = (Map<String, Double>) rates.get("rates");
        if (exchangeRates == null || !exchangeRates.containsKey(to)) {
            throw new IllegalArgumentException("Invalid currency code.");
        }
        return amount * exchangeRates.get(to);
    }
}
