package ex.mech.examples;

/**
 * User: Igor Russo
 * Date: 28.01.13
 * Time: 23:49
 */
public class ExceptionTest_TC_0 {
    public static void main(String[] args) {
        try {
            System.out.println(0);
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println(1);
        }
        System.out.println(2);
    }
}
