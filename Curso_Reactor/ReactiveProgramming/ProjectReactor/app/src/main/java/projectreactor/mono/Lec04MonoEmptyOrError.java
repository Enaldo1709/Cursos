package projectreactor.mono;

import projectreactor.utils.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {
        getData(1).subscribe(
            Util.onNext(),
            Util.onError(),
            Util.onComplete()
        );
    }

    public static Mono<String> getData(int id){
        if (id == 1){
            return Mono.just(Util.faker().name().firstName());
        } else if (id == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("Rango no valido"));
        }
    }
}
