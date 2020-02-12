package com.spring.cloud.microservices.course.service;

import com.spring.cloud.microservices.course.controller.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

//    @GetMapping(path = "/currency/exchange/from/{from}/to/{to}")
    @GetMapping(path = "/currency-exchange-service/currency/exchange/from/{from}/to/{to}")
    public CurrencyConversion exchangeValue(
            @PathVariable("from") String from, @PathVariable("to") String to);

}