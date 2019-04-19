package lesson2.two;

public class Cat {
    private int speed;
    private String name;
    private boolean isHungry;
    private boolean isHerbivore;

    public Cat(int speed, String name, boolean isHungry, boolean isHerbivore) {
        this.speed = speed;
        this.name = name;
        this.isHungry = isHungry;
        this.isHerbivore = isHerbivore;
    }


    public boolean isHungry() {
        return isHungry;
    }

    public boolean isHerbivore() {
        return isHerbivore;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
