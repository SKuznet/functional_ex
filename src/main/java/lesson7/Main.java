package lesson7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // before java 8
        List<String> cats = Arrays.asList("Barsik", "Murzik", "Riska");

        for (String cat : cats) {
            System.out.println(cat);
        }

        // with foreach java 8 lyambda
        cats.forEach(cat -> System.out.println(cat));

        // with foreach java 8 Reference
        cats.forEach(System.out::println);

        // if in foreach before java 8
        for (String name : cats) {
            if (name.equalsIgnoreCase("barsik")) {
                System.out.println(name);
            }
        }

        // foreach in stream with java 8
        cats.stream()
                .filter(s->s.contains("a"))
                .forEach(System.out::println);

        // if in foreach with java 8
        cats.forEach(name -> {
            if (name.equalsIgnoreCase("barsik")) {
                System.out.println(name);
            }
        });

        // map before java 8
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(1, "Barsik");
        numbers.put(2, "Murzik");
        numbers.put(3, "Riska");

        for (Map.Entry<Integer, String> entry : numbers.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        // with foreach java 8
        numbers.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
    }
}
