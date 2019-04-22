package lesson3;

/*
* You can add default and static methods to existing interfaces
* and do not avoid some problems with current realization.
* So with that we can add new functionality to existing interfaces without problems
* and adding lyambda to previous interfaces possible with that.
* */
public interface InterfaceDefaultMethodExample1 {
    static void info() {
        System.out.println("Hello static!");
    }

    default void sayHello() {
        System.out.println("Hello from interface");
    }
}
