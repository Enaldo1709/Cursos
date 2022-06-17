package projectreactor.utils;

import java.util.function.Consumer;

import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Util {
    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext(){
        return o -> log.info("Received: {}",o);
    }

    public static Consumer<Throwable> onError() {
        return t -> log.error("Error: {}",t.getMessage());
    }

    public static Runnable onComplete() {
        return () -> log.info("Completed...");
    }

    public static Faker faker() {
        return FAKER;
    }
}
