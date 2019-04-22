package lesson3.optional;

import java.util.Optional;

/*
* If we observe above real-time Retail Domain use-case, we should know that Java Optional construct is useful at the following places.

Method Parameter

public void setResolution(Optional<ScreenResolution> resolution) {
	this.resolution = resolution;
}
Copy

Method Return Type

public Optional<ScreenResolution> getResolution() {
	return resolution;
}
Copy

Constructor Parameter

public DisplayFeatures(String size, Optional<ScreenResolution> resolution){
	this.size = size;
	this.resolution = resolution;
}
Copy

Variable Declaration

private Optional<ScreenResolution> resolution;
Copy

Class Level

public class B

public class A<T extends Optional<B>> { }

* */
public class OptionalExample {
    public static void main(String[] args) {
//        Optional<String> optional = Optional.of("example");
//        Optional<String> optional = Optional.empty();
        Optional<String> optional = Optional.ofNullable(null);


        // Return {@code true} if there is a value present, otherwise {@code false}.
        System.out.println(optional.isPresent());
        // If a value is present in this {@code Optional}, returns the value,
        //     * otherwise throws {@code NoSuchElementException}.
//        System.out.println(optional.get());

        System.out.println(optional.orElse("miss"));
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));

        optional.ifPresent(System.out::println);


    }
}
