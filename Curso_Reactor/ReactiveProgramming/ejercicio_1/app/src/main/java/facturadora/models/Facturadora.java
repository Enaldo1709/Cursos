package facturadora.models;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class Facturadora {
    private List<ReporteSemanal> reportes;
    

    public Facturadora() {
        this.reportes = new ArrayList<>();
    }

    public Observable<ReporteSemanal> getReportes() {
        return Observable.fromIterable(reportes);
    }

    public void addReporte(ReporteSemanal reporte){
        reportes.add(reporte);
    }

}
