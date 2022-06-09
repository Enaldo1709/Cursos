package publisher.models;

import java.util.concurrent.Flow.Publisher;

import org.reactivestreams.tck.TestEnvironment;
import org.reactivestreams.tck.flow.FlowPublisherVerification;

public class SimplePublisherTest extends FlowPublisherVerification<Integer> {

    public SimplePublisherTest() {
        super(new TestEnvironment());
    }

    @Override
    public Publisher<Integer> createFlowPublisher(long elements) {
        return new SimplePublisher((int) elements);
    }

    @Override
    public Publisher<Integer> createFailedFlowPublisher() {
        return null;
    }
}
