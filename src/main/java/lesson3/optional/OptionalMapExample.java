package lesson3.optional;

import java.util.Optional;

public class OptionalMapExample {

    public static void main(String[] args) {
        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        /*
         * If a value is present, apply the provided mapping function to it,
         * and if the result is non-null, return an {@code Optional} describing the
         * result.  Otherwise return an empty {@code Optional}.
         * */
        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOptionalGender);
        System.out.println("Optional.map     :: " + nonEmptyOptionalGender.map(gender -> gender.map(String::toUpperCase)));

        /*
         * If a value is present, apply the provided {@code Optional}-bearing
         * mapping function to it, return that result, otherwise return an empty
         * {@code Optional}.  This method is similar to {@link #map(Function)},
         * but the provided mapper is one whose result is already an {@code Optional},
         * and if invoked, {@code flatMap} does not wrap it with an additional
         * {@code Optional}.
         **/
        System.out.println("Optional.flatMap :: " + nonEmptyOptionalGender.flatMap(gender -> gender.map(String::toUpperCase)));

    }
}
