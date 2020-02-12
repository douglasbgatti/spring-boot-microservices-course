package com.spring.cloud.microservices.course.service;

import com.spring.cloud.microservices.course.model.ExchangeValue;
import com.spring.cloud.microservices.course.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ExchangeValueService {

    @Autowired
    private ExchangeValueRepository _repository;

    public ExchangeValue getExchangeValue(String from, String to) {
        ExchangeValue exchangeValue = _repository.findByFromAndTo(from, to);

        if (exchangeValue == null) {
            throw new NoSuchElementException(String.format("Exchange values do not exist from=%s, to=%s", from, to));
        }
        return exchangeValue;
    }

}
