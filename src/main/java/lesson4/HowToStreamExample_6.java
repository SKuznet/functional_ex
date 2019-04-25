package lesson4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class HowToStreamExample_6 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("barsik", "murzik");

        Stream<String> stringStream = list.stream();

        // Узнать является ли стрим параллельным
        System.out.println(stringStream.isParallel());

        // Вернуть параллельный стрим, если стрим уже параллельный, то может вернуть самого себя
        stringStream.parallel();

        // Вернуть последовательный стрим, если стрим уже последовательный, то может вернуть самого себя
        stringStream.sequential();
    }
}
