package observable;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class EjemploObservableInterval {
    public static void main(String[] args) {
        createObservableBasic();
    }

    public static void createObservableBasic(){
        Observable.interval(1L, TimeUnit.SECONDS)
            .subscribe(l -> System.out.println("Han pasado: "+l+"s."), Throwable::printStackTrace);
    }
}
