package com.example.springbootdemo.rest;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    private Counter visitCounter;

    @Value("${text.content}")
    private String textContent;

    public WebController(MeterRegistry registry) {
        visitCounter = Counter.builder("visit_counter")
                .description("Number of visits to the site")
                .register(registry);
    }

    @GetMapping("/")
    public String index() {
        visitCounter.increment();
        return textContent;
    }
}