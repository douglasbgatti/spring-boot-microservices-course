package com.spring.cloud.microservices.course.controller;

import com.spring.cloud.microservices.course.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/currency/converter")
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionService _currencyConversionService;

    @GetMapping(path = "/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convert(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {

        return _currencyConversionService.convert(from, to, quantity);
    }

}
