package projectreactor.flux.trading;

public class Cummulator {
    private int value;

    public Cummulator(){
        value = 0;
    }
    public Cummulator(int initialValue){
        value = initialValue;
    }

    public Integer getAndSum(Integer value){
        this.value = Integer.sum(this.get(), value);
        return this.get();
    }

    public Integer get(){
        return this.value;
    }

}
