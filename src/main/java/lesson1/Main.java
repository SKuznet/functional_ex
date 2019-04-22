package lesson1;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        };

        Runnable noArguments = () -> System.out.println("HelloWorld");
        Runnable multiStatement = () -> {
            System.out.print("Hello from Multi");
            System.out.println(" World!");
        };

        new Thread(noArguments).start();
        new Thread(multiStatement).start();

        System.out.println("Welcome!");
    }
}
