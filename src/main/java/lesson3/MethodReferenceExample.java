package lesson3;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {

    /*
     * In a method reference, you place the object (or class) that contains the method before the :: operator
     * and the name of the method after it without arguments.
     *
     * First of all, a method reference can't be used for any method. They can only be used to replace a single-method lambda expression.
     *
     * So to use a method reference, you first need a lambda expression with one method. And to use a lambda expression,
     * you first need a functional interface, an interface with just one abstract method.
     *
     * There are four types of method references:
     *
     *    A method reference to a static method.
     *    A method reference to an instance method of an object of a particular type.
     *    A method reference to an instance method of an existing object.
     *    A method reference to a constructor.
     * */
    public static void main(String[] args) {
        System.out.println("Example with λ");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(integer -> System.out.println(integer));

        // reference can simplify code
        System.out.println("Example with reference");
        list.forEach(System.out::println);
    }
}
