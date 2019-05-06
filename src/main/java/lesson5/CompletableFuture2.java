package lesson5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture2 {
    public static void main(String[] args) {
        // Обработать результат работы CompletableFuture можно через callback.
        // Если после выполенения задачи мы хотим вывести ее на екран, это будет выглядеть так
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");
        future.thenAccept(System.out::println);

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
