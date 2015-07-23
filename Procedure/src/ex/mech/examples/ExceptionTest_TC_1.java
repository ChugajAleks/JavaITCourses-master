package ex.mech.examples;

/**
 * User: Igor Russo
 * Date: 28.01.13
 * Time: 23:51
 */
public class ExceptionTest_TC_1 {
    public static void main(String[] args) {
        try {
            System.out.println(0);
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println(1);
        }
        System.out.println(2);
    }
}
