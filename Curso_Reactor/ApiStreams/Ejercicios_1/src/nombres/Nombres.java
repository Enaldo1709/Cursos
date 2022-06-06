package nombres;

import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Nombres{

    public static void main(String[] args) {
        Stream<String> nombres = Stream.of(
            "Juan Quintero",
            "James Rodriguez",
            "Radamel Falcao",
            "Carlos Bacca"
        );

        nombres.map(String::toUpperCase).map(getName).forEach(System.out::println);
    }

    static UnaryOperator<String> getName = s -> s.split(" ")[0];

}