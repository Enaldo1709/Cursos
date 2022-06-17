package projectreactor.flux.backpressure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectreactor.flux.tecnicas.backpressure.EjercicioZip;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List; 

public class EjercicioZipTest {
    private EjercicioZip zip;

    @BeforeEach
    void setUp() {
        zip = new EjercicioZip();
    }


    @Test
    void testGetElements() {
        List<String> elements = zip.getElements();
        List<String> list = List.of(
            "First Flux: 2, Second Flux: 0", 
            "First Flux: 4, Second Flux: 1", 
            "First Flux: 6, Second Flux: 2", 
            "First Flux: 8, Second Flux: 3",
            "First Flux: 10, Second Flux: 4", 
            "First Flux: 12, Second Flux: 5"
        );
        
        assertEquals(list, elements);

    }
}
