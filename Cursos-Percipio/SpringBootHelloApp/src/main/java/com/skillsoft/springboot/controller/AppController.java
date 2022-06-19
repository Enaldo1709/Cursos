package com.skillsoft.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class AppController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        log.info("Accediendo a la página de índice.");
        return "This is the main page";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(){
        log.info("Accediendo a la página de bienvenida.");
        return "Welcome to Spring Boot";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("Accediendo a la página de saludo.");
        return "Hello Spring Boot";
    }
}
