package publisher.models;

import java.util.Iterator;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.stream.IntStream;

public class SimplePublisher implements Flow.Publisher<Integer>{

    private final Iterator<Integer> iterator;

    public SimplePublisher(int count) {
        this.iterator = IntStream.rangeClosed(1, count).iterator();
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        iterator.forEachRemaining(subscriber::onNext);
        subscriber.onComplete();
    }
    
}
