package com.spring.cloud.microservices.course.controller;

import com.spring.cloud.microservices.course.model.ExchangeValue;
import com.spring.cloud.microservices.course.service.ExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/currency/exchange")
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueService _exchangeValueService;

    @GetMapping(path = "/from/{from}/to/{to}")
    public ExchangeValue exchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = _exchangeValueService.getExchangeValue(from, to);

        exchangeValue.setPort(environment.getProperty("local.server.port"));

        return exchangeValue;
    }

}
