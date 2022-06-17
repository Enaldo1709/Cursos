package com.notificaciones.notificaciones.model;

import org.springframework.context.ApplicationEvent;

public class NotificationEvent extends ApplicationEvent{

    public NotificationEvent(NotificationData source) {
        super(source);
    }
    
}
