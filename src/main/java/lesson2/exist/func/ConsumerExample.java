package lesson2.exist.func;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/*
 * Consumer(потребитель) используется в том случае, если нам нужно применить
 * какое-то действие или операцию к параметру (или к двум параметрам для BiConsumer)
 * и при этом в возвращаемом значении нет необходимости.
 *
 * @FunctionalInterface
 * public interface Consumer<T> {
 *    void accept(T t);
 * }
 *
 * @FunctionalInterface
 * public interface BiConsumer<T, U> {
 *   void accept(T t, U u);
 * }
 *
 * */
public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Functional interface Java 8");

        BiConsumer<String, String> biConsumer = ((s, s2) -> System.out.println(s + s2));
        biConsumer.accept("Functional interface Java 8 ", "with BiConsumer");

        // it can be different types at BiConsumer
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer2 = (i, s) -> map.put(i, s);
        biConsumer2.accept(1, "item one");
        biConsumer2.accept(2, "item two");
        System.out.println(map);
    }
}
