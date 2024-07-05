package com.springrest.springrest.controller;
import com.springrest.springrest.config.GreetConfig;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    private final GreetConfig greetConfig;

    public GreetController(GreetConfig greetConfig) {
        this.greetConfig = greetConfig;
    }
    @Tag(name = "Greeting", description = "default value is Ankit")
    @GetMapping("/greet")
    public String greeting(@RequestParam(required = false, defaultValue = "${app.name}") String name) {
        return greetConfig.getGreeting() + " " + name;
    }
}
