package com.notificaciones.notificaciones.service.gateways;

import java.util.Map;

import com.notificaciones.notificaciones.model.ResponseModel;

import reactor.core.publisher.Mono;

public interface NotificationGateway {
    public Mono<ResponseModel> doInitNotificationProcess(Map<String,String> params);
}
