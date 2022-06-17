package com.notificaciones.notificaciones.service;

import java.util.Map;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.notificaciones.notificaciones.model.NotificationData;
import com.notificaciones.notificaciones.model.NotificationEvent;
import com.notificaciones.notificaciones.model.ResponseModel;
import com.notificaciones.notificaciones.service.gateways.NotificationGateway;
import com.notificaciones.notificaciones.utils.Validator;

import lombok.RequiredArgsConstructor;
import lombok.val;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class NotificationService implements NotificationGateway{
    private final Validator validator;
    private final ApplicationEventPublisher publisher;

    @Override
    public Mono<ResponseModel> doInitNotificationProcess(Map<String,String> params){
        if (!validator.validateParam(params, "param")){
            return createResponse(400, "Error: Parametro 'param' invalido o nulo");
        }
        notifySell(Integer.parseInt(params.get("param")));
        return createResponse(202, "Pedidos recibido... será notificado");
    }

    private void notifySell(Integer param){
        for (int i = 0; i < param; i++) {
            Mono.fromSupplier(() -> NotificationData.builder().id(param.longValue()).build())
                .map(NotificationEvent::new)
                .doOnSuccess(publisher::publishEvent);
        }
    }

    private Mono<ResponseModel> createResponse(int code, String message){
        return Mono.fromSupplier(() -> ResponseModel.builder().code(code).message(message).build());
    }
}
