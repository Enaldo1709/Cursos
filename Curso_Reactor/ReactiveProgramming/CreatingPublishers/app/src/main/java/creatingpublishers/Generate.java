package creatingpublishers;

import java.util.stream.IntStream;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Generate {
    public static void main(String[] args) {
        //get().log().subscribe(System.out::println);
        //Mono<Integer> mono = Mono.error(new RuntimeException("some msg"));

        /*mono.log().subscribe(
            (i) -> System.out.println(i),
            (e) -> System.err.println("Error: "+e.getMessage()),
            () -> System.out.println("Completed")
        );*/

        Mono<Integer> mono = Mono.empty();
        mono.log().subscribe();
    }
    

    private static Mono<Integer> get(){
        return Mono.fromRunnable(() -> {
            int a = 1 * 2;
        });    
    }

    public Flux<Integer> getEvenNumbers(){
        return Flux.create(sink ->{
            IntStream.range(0, 11)
                .filter(i -> (i % 2 ==0))
                .forEach(sink::next);
        });
    }
}
