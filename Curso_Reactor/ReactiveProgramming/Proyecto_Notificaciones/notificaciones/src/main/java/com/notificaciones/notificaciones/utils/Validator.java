package com.notificaciones.notificaciones.utils;

import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class Validator {
    public boolean validateParam(Map<String,String> params, String param){
        if (Objects.isNull(params) || !params.containsKey(param)) {
            return false;
        };
        try {
            Integer.parseInt(params.get(param));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
