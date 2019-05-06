package lesson5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

// Комбинирование двух зависимых задач, с использованием thenCompose()
public class CombineCompletableFuture6 {

    public static void main(String[] args) {
        CompletableFuture<CompletableFuture<Integer>> result = getUsersDetail(5)
                .thenApply(CombineCompletableFuture6::getCreditRating);
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Правило таково: если функция-колбэк возвращает CompletableFuture, а вы хотите простой результат,
        // (а в большинстве случаев именно он вам и нужен), тогда используйте thenCompose().
        CompletableFuture<Integer> result2 = getUsersDetail(5)
                .thenCompose(CombineCompletableFuture6::getCreditRating);
        try {
            System.out.println(result2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static CompletableFuture<User> getUsersDetail(int userId) {
        return CompletableFuture.supplyAsync(() ->
                UserService.getUserDetails(userId));
    }

    static CompletableFuture<Integer> getCreditRating(User user) {
        return CompletableFuture.supplyAsync(() ->
            CreditRatingService.getCreditRating(user));
    }


}


class UserService {
    static User getUserDetails(int id) {
        return new User(id);
    }
}


class CreditRatingService {
    static Integer getCreditRating(User user) {
        CreditRating rating = new CreditRating(user.getId());
        return rating.getRating();
    }
}

class CreditRating {
    private int rating;

    public CreditRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}


class User {
    private String name;
    private int id;

    User(int id) {
        this.id = id;
        this.name = "Jack " + id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}