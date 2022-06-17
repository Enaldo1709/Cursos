package projectreactor.flux.tecnicas.backpressure;

import java.time.Duration;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class EjercicioThrotling {
    public static void main(String[] args) {
        ConnectableFlux<Object> flux = Flux.create(fluxSink -> {
            while (true){
                fluxSink.next(System.currentTimeMillis());
            }
        })
        .sample(Duration.ofSeconds(2))
        .publish();
    
        flux.subscribe(s -> System.out.println("Subscriber -1: "+s));   
        flux.subscribe(s -> System.out.println("Subscriber -2: "+s));

        flux.connect();
    }
}
