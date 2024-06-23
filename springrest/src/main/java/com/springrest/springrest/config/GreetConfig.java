package com.springrest.springrest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GreetConfig {

    @Value("${app.greeting}")
    private String greeting;

    public String getGreeting() {
        return greeting;
    }
}
