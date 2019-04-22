package lesson3;

import java.util.function.Function;

public class FunctionReferenceExample {
    public static void main(String[] args) {
        // method and L
        Function<String, Integer> toInt = string -> parse(string);
        Integer digital = toInt.apply("5");
        System.out.println("Square of " + digital * digital + " with lyambda.");

        // method and R
        Function<String, Integer> toInt2 = FunctionReferenceExample::parse;
        Integer digital2 = toInt2.apply("5");
        System.out.println("Square of " + digital2 * digital2 + " with reference.");

    }

    private static Integer parse(String word) {
        return Integer.parseInt(word);
    }
}
