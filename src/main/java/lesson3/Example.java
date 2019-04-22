package lesson3;

public class Example implements InterfaceDefaultMethodExample1, InterfaceDefaultMethodExample2 {

    public static void main(String[] args) {
        new Example().sayHello();

        InterfaceDefaultMethodExample1.info();
    }

    @Override
    public void sayHello() {
        System.out.println("Hello default override!");
    }
}
