package com.notificaciones.notificaciones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class NotificationData {
    private long id;
    private String name;
    private String email;
    private String mobile;
}
