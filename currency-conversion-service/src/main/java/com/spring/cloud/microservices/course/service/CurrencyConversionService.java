package com.spring.cloud.microservices.course.service;

import com.spring.cloud.microservices.course.controller.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class CurrencyConversionService {

    @Autowired
    private CurrencyExchangeServiceProxy _proxy;

    public CurrencyConversion convert(String from, String to, BigDecimal quantity) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        Map<String, String> uriVariables = new HashMap<>();
//
//        uriVariables.put("from", from);
//        uriVariables.put("to", to);
//
//        ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity(
//                "http://localhost:8000/currency/exchange/from/{from}/to/{to}",
//                CurrencyConversion.class,
//                uriVariables);
//
//        CurrencyConversion currencyConversion = responseEntity.getBody();

        CurrencyConversion currencyConversion = _proxy.exchangeValue(from, to);

        currencyConversion.setQuantity(quantity);

        currencyConversion.setTotalCalculatedAmount(
                quantity.multiply(currencyConversion.getConversionMultiple())
        );

        return currencyConversion;
    };


}
