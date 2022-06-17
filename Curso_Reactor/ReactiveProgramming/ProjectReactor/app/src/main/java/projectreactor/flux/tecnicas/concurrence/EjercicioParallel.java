package projectreactor.flux.tecnicas.concurrence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class EjercicioParallel {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> elements = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(1);

        Flux.just(1,2,3,4,5)
            .log()
            .map(i -> 2 * i)
            .subscribeOn(Schedulers.parallel())
            .subscribe( i -> elements.add(i),
                e -> System.err.println(e.getMessage()),
                () -> latch.countDown());

        latch.await();
        System.out.println(elements);
    }
}
