package predicate;

import java.util.Objects;
import java.util.function.Predicate;

public class PIsNull implements Predicate<Object>{

    @Override
    public boolean test(Object t) {
        return Objects.isNull(t);
    }
    
}