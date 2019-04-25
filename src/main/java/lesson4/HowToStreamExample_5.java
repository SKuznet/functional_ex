package lesson4;

import java.security.Key;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class HowToStreamExample_5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "5", "8", "13");

        // sum - Возвращает сумму всех чисел
        System.out.println(list.stream().mapToInt(Integer::parseInt).sum());

        // average - Возвращает среднее арифметическое всех чисел
        System.out.println(list.stream().mapToInt((s) -> Integer.parseInt(s)).average());

        // mapToObj - Преобразует числовой стрим обратно в объектный
        IntStream intStream = IntStream.range(1, 5);
        intStream.mapToObj(Long::valueOf).forEach(System.out::println);
    }
}
