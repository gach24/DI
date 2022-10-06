package examples.unit01.optionals;

import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Optionals {
    public static void main(String[] args) {
        example01();
    }

    /**
     * Show different ways to access to optional value
     */
    public static void example01() {
        System.out.println("************* Example one *****************");
        /*
         * Apple filter
         */
        Optional<String> fruit = Stream.of("Naranja", "Manzana", "Plátano", "Limón")
                .filter(f -> f.equals("peras")) // Not found
                .findFirst();
        /*
         * Throw exception because not value in optional
         */
        // System.out.println(fruit.get());

        System.out.println("************* Example one *****************");
        /*
         * If optional not present show another message
         */
        System.out.println(fruit.orElse("No hay peras"));

        System.out.println("************* Example two *****************");
        /*
         * Equals to orElse but with lambda expression
         */
        System.out.println(fruit.orElseGet(() -> "No hay peras"));

        System.out.println("************* Example three *****************");
        /*
         * Equals to orElse but if not present throw exception
         */
        try {
            System.out.println(fruit.orElseThrow());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("************* Example four *****************");
        /*
         * Check if value is present
         */
        if (fruit.isPresent())
            System.out.println(fruit.get());
        else
            System.out.println("No hay peras");
    }


}
