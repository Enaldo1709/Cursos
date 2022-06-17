package projectreactor.flux.tecnicas.backpressure;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;

public class EjercicioMap {
    public static void main(String[] args) {
        List<Integer> elementos = new ArrayList<>();
        Flux.just(1,2,3,4,5,6,7,8,9,10)
            .log()
            .map(i -> i * 2)
            .subscribe(elementos::add);

        System.out.println(elementos);
    }
}
