package com.spring.cloud.microservices.course.repository;

import com.spring.cloud.microservices.course.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    public ExchangeValue findByFromAndTo(String from, String to);

}
