package basics.control_flow.AxA_plus_BxB;

/**
 *
 * Реализовать функцию, которая по целочисленному аргументу 'с' возвращает количество целочисленных решений неравенства
 * a*a + b*b <= c
 * a > 0
 * b > 0
 *
 * То есть
 * lookFor(14) == 8
 * так как подходит 8 пар чисел
 * (a=1,b=1), (a=1,b=2), (a=1,b=3), (a=2,b=1), (a=2,b=2), (a=2,b=3), (a=3,b=1), (a=3,b=2)
 *
 */

public class App {

    public static void main(String[] args) {
        System.out.println(MathUtils.lookFor(14));
    }

}
