package com.notificaciones.notificaciones.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.notificaciones.notificaciones.service.NotificationService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RouteHandler {
    private final NotificationService service;

    public Mono<ServerResponse> initNotification(ServerRequest request){
        return service.doInitNotificationProcess(request.pathVariables())
            .flatMap(res -> ServerResponse.status(res.getCode()).bodyValue(res.getMessage()));
    } 
}
