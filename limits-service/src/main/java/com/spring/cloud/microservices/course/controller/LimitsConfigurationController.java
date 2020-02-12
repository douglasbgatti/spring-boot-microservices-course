package com.spring.cloud.microservices.course.controller;

import com.spring.cloud.microservices.course.configuration.Configuration;
import com.spring.cloud.microservices.course.model.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping(path = "/limits")
    public LimitsConfiguration getLimitConfiguration() {
        return new LimitsConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }

}
