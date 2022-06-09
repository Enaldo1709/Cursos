package observable;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;


public class EjemploObservableDefer {
    static int init = 1;
    static int fin = 5;

    public static void main(String[] args) {
        createObservableBasic();
    }

    public static void createObservableBasic(){
        Observable<Integer> source = Observable.defer(() -> Observable.range(init, fin));
        source.subscribe(i -> System.out.printf("Observer 1: %d\n",i));
        fin = 10;
        source.subscribe(i -> System.out.printf("Observer 2: %d\n",i));

    }
}
