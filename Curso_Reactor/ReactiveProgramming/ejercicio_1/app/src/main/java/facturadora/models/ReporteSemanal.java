package facturadora.models;

public class ReporteSemanal {
    private Mes mes;
    private Pyme pyme;
    private double valorVentas;
 
    public ReporteSemanal(Mes mes, Pyme pyme, double valorVentas) {
        this.mes = mes;
        this.pyme = pyme;
        this.valorVentas = valorVentas;
    }

    public Mes getMes() {
        return mes;
    }
    public void setMes(Mes mes) {
        this.mes = mes;
    }
    public Pyme getPyme() {
        return pyme;
    }
    public void setPyme(Pyme pyme) {
        this.pyme = pyme;
    }
    public double getValorVentas() {
        return valorVentas;
    }
    public void setValorVentas(double valorVentas) {
        this.valorVentas = valorVentas;
    }
}
