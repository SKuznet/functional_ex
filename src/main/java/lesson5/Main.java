package lesson5;

import java.util.concurrent.*;


/*
CompletableFuture это расширение Future API, представленного в Java 5.
Future используется как ссылка на результат асинхронной задачи. В нём есть метод isDone() для проверки,
завершилась ли задача или нет, а также метод get() для получения результата после его завершения.
Future API был хорошим шагом на пути к асинхронному программированию,
но ему не хватало некоторых важных и полезных функций.


Ограничения Future
1. Его нельзя завершить вручную.
Допустим, вы написали функцию получения актуальной цены продукта из удалённого API.
Поскольку этот вызов API занимает много времени, вы запускаете его в отдельном потоке и возвращаете Future из функции.

Теперь предположим, что удалённый сервис перестал работать и вы хотите завершить Future вручную,
передав актуальную цену продукта из кэша.

Сможете ли вы сделать это с Future? Нет!
2. Нельзя выполнять дальнейшие действия над результатом Future без блокирования.
Future не уведомляет о своём завершении. В нём есть метод get(), который блокирует поток до тех пор,
пока результат не станет доступным.
Также в Future нельзя повесить функцию-колбэк, чтобы она срабатывала автоматически, как только станет доступен результат.

3. Невозможно выполнить множество Future один за другим.
Бывают случаи, когда требуется выполнить длительную операцию и после её завершения передать результат
другой длительной операции и так далее.
Такой алгоритм асинхронной работы невозможен при использовании Future.

4. Невозможно объединить несколько Future.
Предположим, что у вас есть 10 различных задач во Future, которые вы хотите запустить параллельно,
и как только все они завершатся, вызвать некоторую функцию. С Future вы не можете сделать и это.

5. Нет обработки исключений.
Future API не имеет механизма обработки исключений.
* */
public class Main {

    public static void main(String[] args) {

        /*
         * где future исполнится в ForkJoinPool.commonPool(), т.к. мы не указывали ему Executor.
         * Если мы хотим указать где будет исполняться future то передаем Executor вторым параметром.
         * */
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi with ForkJoinPool");

        try {
            // use get for receiving result
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Hi with newCachedThreadPool",
                Executors.newCachedThreadPool());

        try {
            System.out.println(future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // with runAsync
        // Асинхронно запускаем задачу, заданную объектом Runnable
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            // Имитация длительной работы
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Я буду работать в отдельном потоке, а не в главном.");
        });

        // Блокировка и ожидание завершения Future
        try {
            future3.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> System.out.println("Hi with runAsync tp")
                , Executors.newCachedThreadPool());

        // or we can create pool
        Executor executor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Результат асинхронной задачи";
        }, executor);


        // Разница в том, что supplyAsync() принимает Supplier, а runAsync -> Runnable.
        // Проще говоря, с помощью supplyAsync() можно вернуть результат, с runAsync() - нельзя.
    }
}
