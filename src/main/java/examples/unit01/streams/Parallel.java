package examples.unit01.streams;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.*;

public class Parallel {
    private final static Logger LOGGER = Logger.getLogger("examples.unit01.streams.parallel",);
    public static void main(String[] args) {
        // withOutParallel();

        withParallel();
    }

    public static void withOutParallel() {
        long t1 = System.currentTimeMillis();
        String fruit = Stream.of("Naranja", "Manzana", "Manzana", "Plátano", "Plátano", "Limón")
                .peek(f -> {
                    try {
                        SECONDS.sleep(1);
                    } catch (Exception e) {
                        LOGGER.log(Level.INFO, "Error durante sleep", e);
                    }
                    System.out.println(f + " => Thread: " + Thread.currentThread().getName());
                })
                .filter(f -> f.equals("Limón"))
                .findAny()
                .get();
        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo: " + (t2 - t1));

    }

    public static void withParallel() {
        long t1 = System.currentTimeMillis();
        String fruit = Stream.of("Naranja", "Manzana", "Manzana", "Plátano", "Plátano", "Limón")
                .parallel()
                .peek(f -> {
                    try {
                        SECONDS.sleep(1);
                    } catch (Exception e) {
                        LOGGER.log(Level.INFO, "Error durante sleep", e);
                    }
                    System.out.println(f + " => Thread: " + Thread.currentThread().getName());
                })
                .filter(f -> f.equals("Limón"))
                .findAny()
                .get();
        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo: " + (t2 - t1));

    }
}
