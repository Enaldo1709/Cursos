package com.notificaciones.notificaciones.controller.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.notificaciones.notificaciones.controller.RouteHandler;

@Configuration
public class RouterRest {
    @Value("${server.servlet.context-path}/")
    private String basePath;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(RouteHandler handler) {
        return RouterFunctions.route()
            .path(basePath, builder -> builder.GET("{param}",
                handler::initNotification).build())
            .build();
    }
}
