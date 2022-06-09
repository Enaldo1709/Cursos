package observable;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;



public class EjemploObservableRange {
    public static void main(String[] args) {
        createObservableBasic();
    }

    public static void createObservableBasic(){
        Observable.range(1, 15)
            .subscribe(s -> System.out.println("Numero recibido: "+s), Throwable::printStackTrace);
    }
}
