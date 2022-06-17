package com.notificaciones.notificaciones.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.notificaciones.notificaciones.model.ResponseModel;
import com.notificaciones.notificaciones.utils.Validator;

import lombok.RequiredArgsConstructor;
import lombok.val;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final Validator validator;
    private final 

    public Mono<ResponseModel> doInitNotificationProcess(Map<String,String> params){
        if (!validator.validateParam(params, "param")){
            return Mono.fromSupplier(() -> ResponseModel.builder()
                .code(400)
                .message("Error: Parametro 'param' invalido o nulo")
                .build());
        }

    }
}
