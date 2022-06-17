package com.notificaciones.notificaciones.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.notificaciones.notificaciones.model.NotificationEvent;


import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.FluxSink;

@Slf4j
@Component
public class NotificationPublisher implements 
        ApplicationListener<NotificationEvent>, Consumer<FluxSink<NotificationEvent>> {

    private final Executor executor;
    private final BlockingQueue<NotificationEvent> events = new LinkedBlockingQueue<>();

    public NotificationPublisher(Executor executor){
        this.executor = executor;
    }
    
    @Override
    public void accept(FluxSink<NotificationEvent> sink) {
        this.executor.execute(()-> {
            while (true) try {
                NotificationEvent event = this.events.take();
                sink.next(event);
            } catch (Exception e) {
                log.error("Error: ",e);
                ReflectionUtils.rethrowRuntimeException(e);
            }
        });
    }

    @Override
    public void onApplicationEvent(NotificationEvent event) {
        this.events.offer(event);
        
    }
    
}
