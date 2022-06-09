package multicasting;

import io.reactivex.Observable;

public class MulticastingDuplicate {

    public static void main(String[] args) {
        multicasting();
    }

    public static void multicasting() {
        Observable<String> observable = Observable.just("Prueba")
            .publish()
            .autoConnect(2)
            .map(s -> {
                System.out.println("Expensive Operation running...");
                Thread.sleep(1000);
                System.out.println("Done...");
                return s.toUpperCase();
            });
        
        observable.subscribe(s -> System.out.println("Sub1 Result: "+s));
        observable.subscribe(s -> System.out.println("Sub2 Result: "+s));
        
    }
}
