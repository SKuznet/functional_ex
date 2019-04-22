package lesson3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorReferenceExample {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Nick", "Boll"));
        users.add(new User("Tom", "Soyer"));
        users.add(new User("Jack", "Vorobei"));
        users.add(new User("Ara", "Bird1"));
        users.add(new User("Ara", "Bird3"));
        users.add(new User("Ara", "Bird2"));
        users.add(new User("Ara", "Bird4"));

        System.out.println("Sort with names");
        users.sort(Comparator.comparing(User::getName));
        users.forEach(System.out::println);

        System.out.println("Or sort with 2 params: name and surname");
        users.sort(Comparator.comparing(User::getName).thenComparing(User::getSurname));
        users.forEach(System.out::println);
    }


    static class User {
        private String name;
        private String surname;

        public User(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }
    }
}


