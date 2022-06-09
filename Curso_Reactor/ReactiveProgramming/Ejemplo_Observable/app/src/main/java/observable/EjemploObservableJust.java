package observable;

import java.io.IOException;

import io.reactivex.Observable;



public class EjemploObservableJust {
    public static void main(String[] args) {
        createObservableBasic();
    }

    public static void createObservableBasic(){
        
        Observable<Double> source = Observable.just(2d,null, 4d, 5d)
            .map(Double::valueOf);
        source.subscribe(s -> System.out.println("Numero recibido: "+s), Throwable::printStackTrace);
    }
}
