package lesson2.exist.func;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
 * Function(функция) используется для преобразования входного параметра или в двух параметров
 * (для BiFunction)
 * в какое-либо значение, тип значение может не совпадать с типом входных параметров.
 *
 *
 *
 * @FunctionalInterface
 * public interface Function<T, R> {
 *     R apply(T t);
 * }
 *
 * @FunctionalInterface
 * public interface BiFunction<T, U, R> {
 *     R apply(T t, U u);
 * }
 *
 * */
public class FunctionExample {
    public static void main(String[] args) {
        Function<String, String> function1 = s -> s.toUpperCase();
        System.out.println(function1.apply("Functional interface java 8"));
        Function<String, Integer> function2 = s -> s.length();
        System.out.println(function2.apply("Functional interface java 8"));
        BiFunction<String, String, String> biFunction = (s1, s2) -> s1.concat(s2);
        System.out.println(biFunction.apply("Functional interface ", "java 8")); // Функциональные интерфейсы в Java 8

    }
}
