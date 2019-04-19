package lesson2.exist.func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;

/*
 * Supplier (поставщик) используется для создание какого-либо объекта без
 * использования входных параметров.
 * Интерфейс представлен в стандартной библиотеке Java в следующем виде:
 *
 * @FunctionalInterface
 * public interface Supplier<T> {
 *   T get();
 * }
 *
 * */
public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Functional interface java 8";
        System.out.println(supplier.get());

        Supplier<String[]> supplier1 = () -> new String[]{"Barsik", "Murzik"};
        System.out.println(Arrays.toString(supplier1.get()));
    }
}
