package projectreactor.flux.tecnicas.backpressure;

import java.util.ArrayList;
import java.util.List;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;

public class Ejercicio {
    public static void main(String[] args) {
        List<Integer> elementos = new ArrayList<>();

        Flux.just(1,2,3,4,5,6,7,8,9,10)
            .log()
            .subscribe(new Subscriber<Integer>() {
                private Subscription s;
                int onNextAmmount = 0;

                @Override
                public void onSubscribe(Subscription s) {
                    this.s = s;
                    s.request(3);
                }

                @Override
                public void onNext(Integer t) {
                    elementos.add(t);
                    onNextAmmount++;
                    if (onNextAmmount % 3 == 0) {
                        s.request(3);
                    }
                    
                }

                @Override
                public void onError(Throwable t) {
                    
                }

                @Override
                public void onComplete() {
                    
                }
                
            });
    }
}
