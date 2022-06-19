package creatingpublishers;

import java.util.function.Consumer;

import reactor.core.publisher.FluxSink;

public class FluxSinkImpl implements Consumer<FluxSink<Integer>>{
    private FluxSink<Integer> fluxSink;


    @Override
    public void accept(FluxSink<Integer> t) {
        this.fluxSink = t;
    }

    public void publishElement(Integer i) {
        this.fluxSink.next((Integer) i);
    }
    
}
