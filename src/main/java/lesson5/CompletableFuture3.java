package lesson5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture3 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");

        // thenApplyAsync - in ForkJoinPool.commonPool
        // thenApply -  in the same thread
        future.thenApply(result -> {
            System.out.println(result + " :)");
            return result;
        });


        future.thenApply(result -> {
            System.out.println(result + " <3");
            return result;
        });

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
