package observable;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;



public class EjemploObservableIterable {
    public static void main(String[] args) {
        createObservableBasic();
    }

    public static void createObservableBasic(){
        
        List<String> items = Arrays.asList("Uno", "Dos","Tres");
        Observable<String> source = Observable.fromIterable(items)
            .map(String::toUpperCase);
        source.subscribe(s -> System.out.println("Numero recibido: "+s), Throwable::printStackTrace);
    }
}
