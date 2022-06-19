package com.notificaciones.notificaciones.service;

import java.util.Map;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.notificaciones.notificaciones.model.NotificationData;
import com.notificaciones.notificaciones.model.NotificationEvent;
import com.notificaciones.notificaciones.model.ResponseModel;
import com.notificaciones.notificaciones.service.gateways.NotificationGateway;
import com.notificaciones.notificaciones.utils.Validator;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class NotificationService implements NotificationGateway{
    private final Validator validator;
    private final ApplicationEventPublisher publisher;
    private final Faker repository;

    @Override
    public Mono<ResponseModel> doInitNotificationProcess(Map<String,String> params){
        if (!validator.validateParam(params, "param")){
            return createResponse(400, "Error: Parametro 'param' invalido o nulo");
        }
        notifySell(Integer.parseInt(params.get("param")));
        return createResponse(202, "Pedidos recibido... será notificado");
    }

    private void notifySell(Integer param){
        Flux.range(0, param)
            .map(i -> NotificationData.builder()
                .id(i)
                .name(repository.name().fullName())
                .email(repository.internet().safeEmailAddress())
                .mobile(repository.phoneNumber().cellPhone())
                .build()
            ).map(NotificationEvent::new)
            .subscribe(publisher::publishEvent);
    }

    private Mono<ResponseModel> createResponse(int code, String message){
        return Mono.fromSupplier(() -> ResponseModel.builder().code(code).message(message).build());
    }
}
