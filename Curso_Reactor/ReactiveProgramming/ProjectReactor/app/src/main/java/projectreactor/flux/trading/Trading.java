package projectreactor.flux.trading;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import lombok.extern.slf4j.Slf4j;
import projectreactor.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;

@Slf4j
public class Trading {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        Cummulator ammount = new Cummulator(100);
        Flux.interval(Duration.ofSeconds(1))
            .map(i -> Util.faker().random().nextInt(-5, 5))
            .map(i -> ammount.getAndSum(i)).subscribeWith(new Subscriber<Integer>() {
            Subscription subscription;

            @Override
            public void onSubscribe(Subscription s) {
                this.subscription = s;
                this.subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer t) {
                log.info("Current value: {}",t);
                if(t > 110 || t < 90){
                    this.subscription.cancel();
                    onComplete();
                }
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onComplete() {
                log.warn("Account have reachet unbounds values");
                latch.countDown();
            }
            
        });        
        latch.await();
    }
}
