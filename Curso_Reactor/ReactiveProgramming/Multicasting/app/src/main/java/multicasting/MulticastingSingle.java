package multicasting;

import io.reactivex.Observable;

public class MulticastingSingle {

    public static void main(String[] args) {
        multicasting();
    }

    public static void multicasting() {
        Observable<String> observable = Observable.just("Prueba")
            .map(s -> {
                System.out.println("Expensive Operation running...");
                Thread.sleep(1000);
                System.out.println("Done...");
                return s.toUpperCase();
            })
            .publish()
            .autoConnect(2);

        observable.subscribe(s -> System.out.println("Sub1 Result: "+s));
        observable.subscribe(s -> System.out.println("Sub2 Result: "+s));
        
    }
}
