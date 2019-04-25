package lesson4;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HowToStreamExample_3 {
    public static void main(String[] args) {
        // Java Stream API offers two type of methods:
        // 1. Конвейерные — возвращают другой stream, то есть работают как builder,
        // 2. Терминальные — возвращают другой объект, такой как коллекция, примитивы,
        // объекты, Optional и т.д.

        // Общее правило: у stream'a может быть сколько угодно вызовов конвейерных вызовов
        // и в конце один терминальный, при этом все конвейерные методы выполняются лениво
        // и пока не будет вызван терминальный метод никаких действий на самом деле
        // не происходит, так же как создать объект Thread или Runnable, но не вызвать
        // у него start.
        //
        // В целом, этот механизм похож на конструирования SQL запросов, может быть
        // сколько угодно вложенных Select'ов и только один результат в итоге.
        // Например, в выражении collection.stream().filter((s) -> s.contains(«1»)).skip(2).findFirst(),
        // filter и skip — конвейерные, а findFirst — терминальный, он возвращает объект
        // Optional и это заканчивает работу со stream'ом.

        // description about conveyor methods works with stream

        // filter - Отфильтровывает записи, возвращает только записи, соответствующие условию
        Stream<String> stream = Arrays.stream(new String[]{"Barsik", "Murzik"});
        System.out.println(stream.filter("Barsik"::equals).count());

        // skip - Позволяет пропустить N первых элементов
        Stream<String> stream2 = Arrays.stream(new String[]{"Barsik", "Murzik"});
        System.out.println(stream2.skip(1).findFirst().orElse("Snegok"));

        // distinct - Возвращает стрим без дубликатов (для метода equals)
        Stream<String> stream3 = Arrays.stream(new String[]{"Barsik", "Murzik", "Barsik"});
        System.out.println(stream3.distinct().collect(Collectors.toList()));

        // map - Преобразует каждый элемент стрима
        Stream<String> stream4 = Arrays.stream(new String[]{"Barsik", "Murzik", "Barsik"});
        System.out.println(stream4.map((s) -> s + "_happy").collect(Collectors.toList()));

        // peek - Возвращает тот же стрим, но применяет функцию к каждому элементу стрима
        Stream<String> stream5 = Arrays.stream(new String[]{"Barsik", "Murzik", "Barsik"});
        System.out.println(stream5.map(String::toUpperCase).peek((e) -> System.out.println(", " + e))
                .collect(Collectors.toList()));

        // limit - Позволяет ограничить выборку определенным количеством первых элементов
        Stream<String> stream6 = Arrays.stream(new String[]{"Barsik", "Murzik", "Barsik"});
        System.out.println(stream6.limit(2).collect(Collectors.toList()));

        // sorted - Позволяет сортировать значения либо в натуральном порядке, либо задавая Comparator
        Stream<String> stream7 = Arrays.stream(new String[]{"Barsik", "Murzik", "Ara"});
        System.out.println(stream7.sorted().collect(Collectors.toList()));

        // mapToInt, mapToDouble, mapToLong
        Stream<String> stream8 = Arrays.stream(new String[]{"1", "2", "3"});
        System.out.println(Arrays.toString(stream8.mapToInt(Integer::parseInt).toArray()));

        // flatMap, flatMapToInt, flatMapToDouble, flatMapToLong
        // can create few elements from one
        Stream<String> stream9 = Arrays.stream(new String[]{"Barsik,Murzik,Snegok"});
        System.out.println(Arrays.toString(stream9.flatMap((p) -> Arrays.stream(p.split(",")))
                .toArray(String[]::new)));
    }
}
