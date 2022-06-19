package com.skillsoft.springintlzr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping
    public String index(){
        return "We've successfully used the Spring Initializer";
    }

    @GetMapping(value = "/welcome")
    public String welcome() {
        return "Welcome to Spring Boot!";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }

}
