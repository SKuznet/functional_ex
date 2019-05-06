package lesson5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture4 {
    public static void main(String[] args) {
        int productId = 5;

        // CompletableFuture.thenAccept() принимает Consumer<T> и возвращает CompletableFuture<Void>.
        // Он имеет доступ к результату CompletableFuture, к которому он прикреплён.
        CompletableFuture.supplyAsync(() -> {
            return ProductService.getProductDetail(productId);
        }).thenAccept(product -> {
            System.out.println("Получена информация о продукте из удалённого сервиса: " + product.toUpperCase());
        });

        CompletableFuture.supplyAsync(() -> {
            System.out.println("Do something");
            return productId + 5;
        }).thenRun(() -> System.out.println("done"));


    }


    static class ProductService {
        static String getProductDetail(int id) {
            return "product " + id;
        }
    }

}
