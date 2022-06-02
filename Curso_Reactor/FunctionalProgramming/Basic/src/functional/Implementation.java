package functional;

public class Implementation {
    public static void main(String[] args) {
        FInterface fin = () -> System.out.println("Procesing...");
        fin.print("text");
    }
}
