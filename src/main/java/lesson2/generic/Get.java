package lesson2.generic;

import lesson2.generic.Cat;

@FunctionalInterface
public interface Get<T> {
    T get(Cat cat);
}
