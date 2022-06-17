package projectreactor.flux;

import java.time.Duration;

import projectreactor.utils.Util;
import reactor.core.publisher.Flux;

public class Lec08FluxInterval {
    public static void main(String[] args) {
        try {
            Flux.interval(Duration.ofSeconds(1)).subscribe(Util.onNext());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
