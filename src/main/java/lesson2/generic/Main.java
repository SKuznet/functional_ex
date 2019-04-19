package lesson2.generic;

public class Main {
    public static void main(String[] args) {
        Cat barsik = new Cat(20, "Barsik", true, true);
        Cat murzik = new Cat(30, "Murzik", true, false);

        print(barsik, O -> O.getSpeed());
        print(barsik, O -> O.getName());
        print(murzik, O -> O.getSpeed());
        print(murzik, O -> O.getName());
    }

    private static void print(Cat cat, Get get) {
        System.out.println(get.get(cat));
    }
}
