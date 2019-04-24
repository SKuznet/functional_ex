package lesson4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HowToStreamExample_2 {

    public static void main(String[] args) {
        // make stream from collection
        List<Integer> list = Arrays.asList(1, 3, 6, 22, 25);
        list.stream();

        // make stream from values
        Stream<String> values = Stream.of("Barsik", "Murzik", "Snegok");

        // make stream from array
        String[] array = {"Barsik","Murzik","Snegok"};
        Stream<String> streamFromArray = Arrays.stream(array);

        // make stream from file
        // each new line from file - new element at stream
        try {
            Stream<String> streamFromFile = Files.lines(Paths.get("file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // make stream from String
        IntStream streamFromString = "123".chars();

        // make stream from stream builder
        Stream.builder().add("a1").add("a2").add("a3").build();

        // make parallel stream
        list.parallelStream();

        // make infinity stream
        // Returns an infinite sequential ordered {@code Stream} produced by iterative
        // application of a function {@code f} to an initial element {@code seed},
        // producing a {@code Stream} consisting of {@code seed}, {@code f(seed)},
        // {@code f(f(seed))}, etc.
        //
        // Stream.iterate(начальное_условие, выражение_генерации)
        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1);

        // make infinity stream with generate
        // Stream.generate(выражение_генерации)
        Stream<String> streamFromGenerate = Stream.generate(() -> "a1");

        // Последние два способа служат для генерации бесконечных стримов,
        // в iterate задается начальное условие и выражение получение следующего значения
        // из предыдущего, то есть Stream.iterate(1, n -> n + 1) будет выдавать значения
        // 1, 2, 3, 4,… N. Stream.generate служит для генерации константных
        // и случайных значений, он просто выдает значения соответствующие выражению,
        // в данном примере, он будет выдавать бесконечное количество значений «a1».
    }
}
