package lesson4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HowToStreamExample_4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Barsik", "Murzik", "Riska");

        // findFirst - Возвращает первый элемент из стрима (возвращает Optional)
        System.out.println(list.stream().findFirst().orElse("1"));

        // findAny - Возвращает любой подходящий элемент из стрима (возвращает Optional)
        System.out.println(list.stream().findAny().orElse("1"));

        // collect - Представление результатов в виде коллекций и других структур данных
        System.out.println(list.stream().filter((s) -> s.contains("a")).collect(Collectors.toList()));

        // count - Возвращает количество элементов в стриме
        System.out.println(list.stream().filter("Barsik"::equals).count());

        // anyMatch - Возвращает true, если условие выполняется хотя бы для одного элемента
        System.out.println(list.stream().anyMatch("Barsik"::equals));
        System.out.println(list.stream().anyMatch("Snegok"::equals));

        // noneMatch - Возвращает true, если условие не выполняется ни для одного элемента
        System.out.println(list.stream().noneMatch("Snegok"::equals));

        // allMatch - Возвращает true, если условие выполняется для всех элементов
        System.out.println(list.stream().allMatch((s) -> s.contains("i") ));

        // min - Возвращает минимальный элемент, в качестве условия использует компаратор
        System.out.println(list.stream().min(String::compareTo));

        // max - Возвращает максимальный элемент, в качестве условия использует компаратор
        System.out.println(list.stream().max(String::compareTo));

        // forEach - Применяет функцию к каждому объекту стрима, порядок при параллельном выполнении не гарантируется
        list.stream().forEach(System.out::println);

        // forEachOrdered - Применяет функцию к каждому объекту стрима, сохранение порядка элементов гарантирует
        list.stream().forEachOrdered((o) -> System.out.println("Item: " + o));

        // toArray - Возвращает массив значений стрима
        System.out.println(Arrays.toString(list.stream().map(String::toUpperCase).toArray(String[]::new)));

        // reduce - Позволяет выполнять агрегатные функции на всей коллекцией и возвращать один результат
        System.out.println(list.stream().reduce((s1, s2) -> s1 + "_" + s2 ).orElse("1"));

    }
}
