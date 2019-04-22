package lesson3.optional;

import java.util.Optional;

public class OptionalExample2 {
    /*
     * Optional.ofNullable() method returns a Non-empty Optional if a value present in the given object.
     * Otherwise returns empty Optional.
     *
     * Optional.empty() method is useful to create an empty Optional object.
     * */
    public static void main(String[] args) {
        Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional:" + gender);
        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

        // java.lang.NullPointerException
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));
    }
}
