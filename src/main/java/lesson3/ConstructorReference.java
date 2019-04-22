package lesson3;

interface UserFactory {
    User create(String name, String surname);
}

public class ConstructorReference {

    /*
    * We can use reference for constructor
    * And without realization use reference for constructor (::new)
    * */
    public static void main(String[] args) {
        UserFactory userFactory = User::new;
        User user = userFactory.create("John", "Snow");
        System.out.println(user);
    }
}

class User {
    String name;
    String surname;

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
}
