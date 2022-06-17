package projectreactor.flux.tecnicas.backpressure;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;

public class EjercicioZip {
    public EjercicioZip(){

    }

    public static void main(String[] args) {
        System.out.println(new EjercicioZip().getElements());
    }

    public List<String> getElements() {
        List<String> elements = new ArrayList<>();
        Flux.just(1,2,3,4,5,6)
            .log()
            .map(i -> i * 2)
            .zipWith(
                Flux.range(0, Integer.MAX_VALUE), 
                    (one, two) -> String.format("First Flux: %d, Second Flux: %d", one, two))
            .subscribe(elements::add);
        return elements;
    }
}
