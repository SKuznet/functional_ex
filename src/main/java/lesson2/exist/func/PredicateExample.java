package lesson2.exist.func;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/*
 * Predicate(утверждение) наиболее часто применяется в фильтрах и сравнении,
 * имеет следующий вид:
 *
 * @FunctionalInterface
 * public interface Predicate<T> {
 *    boolean test(T t);
 * }
 *
 * @FunctionalInterface
 * public interface BiPredicate<T, U> {
 *     boolean test(T t, U u);
 * }
 *
 * В метод test() передается один или два параметра, в зависимости от
 * функционального интерфейса, а возвращается логическое значение true или false.
 *
 * */
public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> predicate = O -> O.isEmpty();
        System.out.println(predicate.test(""));

        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equals(s2);
        System.out.println(biPredicate.test("Functional interface java 8",
                " Functional interface java 8"));
    }
}
