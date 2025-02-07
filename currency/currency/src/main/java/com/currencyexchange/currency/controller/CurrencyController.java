package com.currencyexchange.currency.controller;


import com.currencyexchange.currency.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyRateService currencyRateService;

    @GetMapping("/rates")
    public ResponseEntity<Map<String, Object>> getRates(@RequestParam(defaultValue = "USD") String base) {
        return ResponseEntity.ok(currencyRateService.getRates(base));
    }

    @PostMapping("/convert")
    public ResponseEntity<Map<String, Object>> convert(@RequestBody Map<String, Object> request) {
        String from = (String) request.get("from");
        String to = (String) request.get("to");
        double amount = ((Number) request.get("amount")).doubleValue();
        double convertedAmount = currencyRateService.convert(from, to, amount);
        return ResponseEntity.ok(Map.of(
                "from", from,
                "to", to,
                "amount", amount,
                "convertedAmount", convertedAmount
        ));
    }
}
