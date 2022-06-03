package empleados;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import empleados.modelos.Departamento;
import empleados.modelos.Empleado;

public class App {
    public static void main(String[] args) {

        System.out.println("\nEjercicio 2: ");
        getEmpleados.get().stream()
            .filter(findBetween25and30)
            .forEach(System.out::println);  
        
        System.out.println("\nEjercicio 3: ");
        OptionalDouble promedioSalario =  getEmpleados.get().stream()
            .mapToDouble(Empleado::getSalario)
            .average();
        System.out.printf("\tSalario promedio: %.0f\n",promedioSalario.getAsDouble());
        getEmpleados.get().stream()
            .filter(e -> e.getSalario() < promedioSalario.getAsDouble())
            .forEach(System.out::println);
            
        System.out.println("\nEjercicio 4: ");
        Optional<Empleado> empleadoUXMejorPagado =  getEmpleados.get().stream()
            .filter(e -> Departamento.UX.equals(e.getDepartamento()))
            .max(Comparator.comparing(Empleado::getSalario));

        System.out.println("El empleado del departamento UX con mejor salario es: " 
            + (empleadoUXMejorPagado.isPresent()?empleadoUXMejorPagado.get().toString():"null"));

        System.out.println("\nEjercicio 5: ");
        Map<Departamento, List<Empleado>> empleados = getEmpleados.get().stream()
            .collect(Collectors.groupingBy(Empleado::getDepartamento, Collectors.toList()));
        empleados.forEach((k,v)-> {
            System.out.printf("Departamento: %s\n",k.name());
            v.forEach(System.out::println);
        });

    }

    static Predicate<Empleado> findBetween25and30 = e -> e.getEdad() >= 25 && e.getEdad() <= 30;

    static Supplier<List<Empleado>> getEmpleados = () -> List.of(
        new Empleado(1, "Juan Lopez", 21, 2500, Departamento.DEVELOPER),
        new Empleado(2, "Luisa Jimenez", 22, 2100, Departamento.DEVELOPER),
        new Empleado(3, "Jose Carmona", 33, 2400, Departamento.TESTER),
        new Empleado(4, "John Smith", 37, 3100, Departamento.DEVOPS),
        new Empleado(5, "Julieta Moreno", 28, 2200, Departamento.UX),
        new Empleado(6, "Luis Mendieta", 26, 4200, Departamento.UX),
        new Empleado(7, "Kevin Perez", 28, 2200, Departamento.DEVOPS),
        new Empleado(8, "Olga Torres", 24, 3200, Departamento.DEVELOPER),
        new Empleado(9, "Maria Medina", 36, 2900, Departamento.DEVELOPER),
        new Empleado(10, "Karol Moreno", 31, 2600, Departamento.UX),
        new Empleado(11, "Jorge Ramos", 29, 1900, Departamento.TESTER)

    );
}
