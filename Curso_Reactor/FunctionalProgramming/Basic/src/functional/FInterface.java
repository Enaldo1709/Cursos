package functional;

@FunctionalInterface
public interface FInterface{
    void execute();
    default void print(String text){
        System.out.printf("Before execute: %s\n",text);
        execute();
    }
}