package lesson2.two;

public class Main {
    public static void main(String[] args) {
        Cat barsik = new Cat(20, "Barsik", true, true);
        Cat murzik = new Cat(30, "Murzik", true, false);

        printSpeed(barsik, O -> O.getSpeed());
        printName(barsik, O -> O.getName());
        printSpeed(murzik, O -> O.getSpeed());
        printName(murzik, O -> O.getName());
    }

    private static void printName(Cat cat, GetName get) {
        System.out.println(get.get(cat));
    }

    private static void printSpeed(Cat cat, GetSpeed get) {
        System.out.println(get.get(cat));
    }
}
