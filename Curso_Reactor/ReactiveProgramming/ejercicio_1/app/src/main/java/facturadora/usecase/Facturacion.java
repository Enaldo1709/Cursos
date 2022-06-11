package facturadora.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import javax.crypto.spec.RC2ParameterSpec;

import facturadora.models.ReporteSemanal;
import io.reactivex.Observable;

public class Facturacion<T extends ReporteSemanal> implements Subscriber<T>{
    private List<ReporteSemanal> reportes;
    public Facturacion(){}

    private void getPromedioMensualPorPyme() {
        
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        reportes = new ArrayList<>();
    }

    @Override
    public void onNext(ReporteSemanal item) {
        reportes.add(item);
    }

    @Override
    public void onError(Throwable throwable) {
        
    }

    @Override
    public void onComplete() {
        
    }


}
