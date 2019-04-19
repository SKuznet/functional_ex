package lesson2.exist.func;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/*
 * UnaryOperator и BinaryOperator разновидность Function, в которых входные и выходные
 * обобщенные параметры должны совпадать. Если заглянуть в пакет java.util.function,
 * то можно заметить, что UnaryOperator расширяет Function, а BinaryOperator расширяет BiFunction.
 * @FunctionalInterface
 * public interface UnaryOperator<T> extends Function<T, T> {}
 *
 * @FunctionalInterface
 * public interface BinaryOperator<T> extends BiFunction<T,T,T> {}
 *
 * */
public class OperatorsExample {
    public static void main(String[] args) {
        UnaryOperator<StringBuilder> unaryOperator = sb -> sb.reverse();
        System.out.println(unaryOperator.apply(new StringBuilder("Functional interface java 8")));

        BinaryOperator<StringBuilder> binaryOperator = (sb1, sb2) -> sb1.append(sb2);
        System.out.println(binaryOperator.apply(new StringBuilder("Functional interface "),
                new StringBuilder("java 8")));
    }
}
