package projectreactor.flux.tecnicas.backpressure;

import javax.sound.midi.SysexMessage;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class EjercicioHotStream {
    public static void main(String[] args) {
        ConnectableFlux<Object> flux = Flux.create(fluxSink -> {
            while (true){
                fluxSink.next(System.currentTimeMillis());
            }
        }).publish();

        flux.subscribe(s -> System.out.println("Subscriber -1: "+s));
        flux.subscribe(s -> System.out.println("Subscriber -2: "+s));
        flux.subscribe(s -> System.out.println("Subscriber -3: "+s));
        flux.subscribe(s -> System.out.println("Subscriber -4: "+s));

        flux.connect();
    }
}
