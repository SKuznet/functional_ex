package lesson3;

// Это функция, связанная с выражением Lambda. Она позволяет вам ссылаться на другие
// конструкторы или методы, не выполняя их. Ссылки на методы (method references)
// и Lambda аналогичны тем, что они оба требуют один вид цели, это совместимый
// функциональный интерфейс.
// Java 8 позволяет передавать ссылку метода или конструктора с помощью ключевого
// слова ::

@FunctionalInterface
interface MyFunction {

    // Этот метод имеет 2 параметра a, b и возвращает вид int.
    int doSomething(int a, int b);

}

class MyMathUtil {
    // Этот метод имеет 2 параметра a, b и возвращает вид int.
    // Этот метод имеет другое название,
    // но структура похожа на MyFunction.doSomething(int,int).
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

}

public class ReferenceFirst {
    // Третий параметр данного метода является MyFunction (Functional Interface).
    // При использовании данного метода:
    // Вы можете передать ссылку метода для третьего параметра.
    // (Методы должны быть одного вида с MyFunction).
    public static int action(int a, int b, MyFunction func) {
        return func.doSomething(a, b);
    }

    public static void main(String[] args) {
        int a = 100;
        int b = 30;

        // Передать ссылку метода MyMathUtils.sum.
        int c = action(a, b, MyMathUtil::sum);// ==> 130.

        System.out.println("c = " + c);

        // Передать ссылку метода MyMathUtils.minus.
        int d = action(a, b, MyMathUtil::minus);// ==> 70

        System.out.println("d = " + d);

        // Передать ссылку метода Math.subtractExact.
        int e = action(a, b, Math::subtractExact);// ==> 70

        System.out.println("e = " + e);

        // Передать ссылку метода Math.min.
        int f = action(a, b, Math::min);// ==> 30

        System.out.println("f = " + f);
    }
}


