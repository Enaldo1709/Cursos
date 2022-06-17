package com.notificaciones.notificaciones.controller.config;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notificaciones.notificaciones.model.NotificationData;
import com.notificaciones.notificaciones.model.NotificationEvent;
import com.notificaciones.notificaciones.service.NotificationPublisher;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@Configuration
public class WebSocketConfiguration {
    @Bean
    Executor executor() {
        return Executors.newSingleThreadExecutor();
    }

    @Bean
    HandlerMapping handlerMapping(WebSocketHandler handler){
        return new SimpleUrlHandlerMapping(){
            {
                setUrlMap(Collections.singletonMap("/ws/notifications", handler));
            }
        };
    }

    @Bean
    WebSocketHandlerAdapter adapter(){
        return new WebSocketHandlerAdapter();
    }

    @Bean
    WebSocketHandler handler(ObjectMapper mapper, NotificationPublisher publisher){
        Flux<NotificationEvent> publish = Flux.create(publisher).share();
        return session -> {
            Flux<WebSocketMessage> messages = publish.map(e -> {
                try {
                    NotificationData data = (NotificationData) e.getSource();
                    return mapper.writeValueAsString(Map.of("id",data.getId()));
                } catch (JsonProcessingException ex) {
                    throw new RuntimeException(ex);
                }
            }).map(session::textMessage);

            return session.send(messages);
        };
    }    
}
