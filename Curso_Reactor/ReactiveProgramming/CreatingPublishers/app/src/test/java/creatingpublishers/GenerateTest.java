package creatingpublishers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class GenerateTest {
    private Generate generator;

    @BeforeEach
    void setUp(){
        generator = new Generate();
    }

    @Test
    void testGetEvenNumbers() {
        Flux<Integer> flux = generator.getEvenNumbers();
        StepVerifier.create(flux)
        .expectSubscription()
            .assertNext(0, 2,4,6,8,10)
            .expectComplete()
            .verify();
    }
}
