package com.notificaciones.notificaciones.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

@Configuration
public class ServiceConfig {
    @Bean
    Faker getRepository() {
        return Faker.instance();
    }
}
