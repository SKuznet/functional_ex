package lesson4;

import java.util.Arrays;
import java.util.List;

public class NegativeSummary_1 {
    public static void main(String[] args) {

        // old realization
        List<Integer> list = Arrays.asList(1, 2, 5, 9, 22);
        Integer summaryOddOld = 0;
        for (Integer i : list) {
            if (i % 2 != 0) {
                summaryOddOld += i;
            }
        }

        System.out.println(summaryOddOld);

        // stream realization
        Integer summaryOdd = list.stream().filter(o -> o % 2 != 0)
                .reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println(summaryOdd);

        // stream realization with multithreading
        // it makes code parallel and you no need to set semaphore,
        // locks, synchronized, etc...
        Integer parallelSummaryOdd = list.parallelStream().filter(o -> o % 2 != 0)
                .reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println(parallelSummaryOdd);
    }
}
