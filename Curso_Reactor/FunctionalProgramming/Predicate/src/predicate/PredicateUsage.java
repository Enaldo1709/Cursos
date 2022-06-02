package predicate;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateUsage {
    public static void main(String[] args) {
        String notNull = "Hola";
        String nulled = null;
        
        System.out.println("Usando clases: ");

        Predicate<Object> nullTest = new PIsNull();
        
        System.out.println("Este objeto es nulo: " + nullTest.test(notNull));
        System.out.println("Este objeto es nulo: " + nullTest.test(nulled));
        

        System.out.println("\nUsando lambda: ");

        Predicate<Object> nullTest2 = (t) -> Objects.isNull(t);

        System.out.println("Este objeto es nulo: " + nullTest2.test(notNull));
        System.out.println("Este objeto es nulo: " + nullTest2.test(nulled));
                
    }
}
