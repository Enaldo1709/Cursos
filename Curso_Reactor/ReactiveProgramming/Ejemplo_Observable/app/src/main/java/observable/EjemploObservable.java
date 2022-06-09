package observable;

import io.reactivex.Observable;

public class EjemploObservable {
    public static void main(String[] args) {
        createObservableBasic();
    }

    public static void createObservableBasic(){
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("Uno");
                emitter.onNext("Dos");
                emitter.onNext("Tres");
                emitter.onNext("Cuatro");
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });

        source.subscribe(s -> System.out.println("Numero recibido: "+s), Throwable::printStackTrace);
    }


}
