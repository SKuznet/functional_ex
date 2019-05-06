package lesson5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class BlockedFutureExample5 {
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();
        try {
            // infinity
            // future.complete("result");
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
