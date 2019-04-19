package lesson2.cats;

public class Main {

    public static void main(String[] args) {
        Cat barsik = new Cat("Barsik", true, true);
        Cat murzik = new Cat("Murzik", true, false);

        checkCat(barsik, O -> O.isHerbivore());
        checkCat(barsik, c -> c.isHungry());
        checkCat(murzik, A -> A.isHerbivore());
        checkCat(murzik, c -> c.isHungry());
        // incorrect
//        checkCat(murzik, 1 -> 1.isHungry());
    }

    private static void checkCat(Cat cat, CheckCat checkCat) {
        if (checkCat.check(cat)) {
            System.out.println(cat);
        }
    }
}
