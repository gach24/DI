package examples.unit01.streams;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        // example01();
        // example02();
        // example03();
        // example04();
        // example05();
        // example06();
        // example07();
        example08();
    }

    /**
     * Different ways to create a stream
     */
    public static void example01() {
        System.out.println("************* Method one *****************");
        // Create a stream
        Stream<String> fruits = Stream.of("Naranja", "Manzana", "Plátano", "Limón");

        // loop through stream
        // fruits.forEach(fruit -> System.out.println(fruit)); // Another way
        fruits.forEach(System.out::println);

        // Method two
        System.out.println("************* Method two *****************");
        String[] array = {"Naranja", "Manzana", "Plátano", "Limón"};
        fruits = Arrays.stream(array);
        fruits.forEach(System.out::println);

        // Method three
        System.out.println("************* Method tree *****************");
        fruits = Stream.<String>builder()
                .add("Naranja")
                .add("Manzana")
                .add("Plátano")
                .add("Limón")
                .build();
        fruits.forEach(System.out::println);

        // Method four
        System.out.println("************* Method four *****************");
        List<String> list = Arrays.asList("Naranja", "Manzana", "Plátano", "Limón");
        fruits = list.stream();
        fruits.forEach(System.out::println);
    }

    /**
     * Examples of map operator
     */
    public static void example02() {

        System.out.println("************* Example one *****************");
        /**
         * Create a stream and modified the stream with map operator
         * The peek operator only show the stream before map operator
         * For each element first show the element (peek) and after transform the element
         */
        Stream<String> fruits = Stream.of("Naranja", "Manzana", "Plátano", "Limón")
                .peek(System.out::println) // Only show each element
                // .map(fruit -> fruit.toUpperCase());
                .map(String::toUpperCase); // Transform each element
        fruits.forEach(System.out::println);

        System.out.println("************* Example two *****************");
        fruits = Stream.of("Naranja", "Manzana", "Plátano", "Limón");
        /**
         * Returns a list of fruits
         */
        List<String> list = fruits.collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("************* Example three *****************");
        Stream<Fruit> otherFruits = Stream.of("Naranja", "Manzana", "Plátano", "Limón")
                // .map(fruit -> new Fruit(fruit)) // another way
                .map(Fruit::new); // Change string to Fruit class
        otherFruits.forEach(System.out::println);

    }

    /**
     * Examples of filter operator
     */
    public static void example03() {

        System.out.println("************* Example one *****************");
        /**
         * Apple filter
         */
        Stream.of("Naranja", "Manzana", "Plátano", "Limón")
                .filter(fruit -> fruit.equals("Manzana"))
                .forEach(System.out::println);

        System.out.println("************* Example two *****************");
        /**
         * Apple filter of stream with two apples
         * Return an optional of String
         */
        Optional<String> fruit = Stream.of("Naranja", "Manzana", "Plátano", "Limón", "Manzana")
                .filter(f -> f.equals("Manzana"))
                .findFirst();
        System.out.println(fruit.get());

        System.out.println("************* Example three *****************");

    }


    /**
     * Examples of anyMatch operator
     * Return true of false if exist the element
     */
    public static void example04() {
        System.out.println("************* Example one *****************");
        boolean exist =  Stream.of("Naranja", "Manzana", "Plátano", "Limón")
                .anyMatch(fruit -> fruit.equals("Limón"));
        System.out.println(exist);
    }

    /**
     * Examples of count, reduce, sum y summaryStatistics operator
     */
    public static void example05() {

        System.out.println("************* Example one *****************");
        /**
         * Filter empty strings and count elements
         */
        long count = Stream.of("Naranja", "Manzana", "", "", "Plátano", "Limón")
                .filter(String::isEmpty)
                .count();
        System.out.println(count);

        System.out.println("************* Example two *****************");
        /**
         * Distinct equals elements
         */
        Stream.of("Naranja", "Manzana", "Manzana", "Plátano", "Plátano", "Limón")
                .distinct()
                .forEach(System.out::println);

        System.out.println("************* Example three *****************");
        /**
         * Sum an integer stream
         */
        int result = Stream.of(5, 10, 15, 20, 25)
                // .reduce(0, (a, b) -> a + b); // Another way
                .reduce(0, Integer::sum);
        System.out.println(result);

        System.out.println("************* Example four *****************");
        /**
         * Sum an integer stream with IntStream.range() generator
         * Include the first element
         * Not include the last element
         */
        IntStream numbers = IntStream.range(5, 20);
        // result = numbers.reduce(0, Integer::sum); // Another way
        result = numbers.sum();
        System.out.println(result);

        System.out.println("************* Example five *****************");
        /**
         * Sum an integer stream with IntStream.range() generator
         * and uses IntSumaryStatistic
         */
        numbers = IntStream.range(5, 20);
        IntSummaryStatistics stats = numbers.summaryStatistics();
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Avg: " + stats.getAverage());
        System.out.println("Count: " + stats.getCount());
    }

    /**
     * Examples of mapToInt intermediate operator
     */
    public static void example07() {

        System.out.println("************* Example one *****************");
        /**
        * Map to IntStream and show the numbers of Strings
        */
        IntStream numbers = Stream.of("Naranja", "Manzana", "Plátano", "Limón")
                .mapToInt(fruit -> fruit.length());
        numbers.forEach(System.out::println);

    }

    /**
     * How to generate an infinite stream
     */
    public static void example08() {

        System.out.println("************* Example one *****************");
        /**
         * Infinite stream
         */
        // Stream.generate(() -> "Infinite steam").forEach(System.out::println);

        System.out.println("************* Example two *****************");
        /**
         * Infinite stream with limit
         */
        Stream.generate(() -> "Infinite stream with limit")
                .limit(20)
                .forEach(System.out::println);

        System.out.println("************* Example three *****************");
        /**
         * Infinite stream of numbers with limit of 20
         */
        AtomicInteger counter = new AtomicInteger(0);
        Stream.generate(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) { }
                    return  counter.incrementAndGet();
                })
                .limit(20)
                .forEach(System.out::println);

    }




    /**
     * Private model class
     */
    private static class Fruit {
        private String name;

        public Fruit(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Fruit{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
