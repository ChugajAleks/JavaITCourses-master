package ex.mech.InfOrNotInf;

/**
 * User: Igor Russo
 * Date: 01.02.13
 * Time: 1:16
 */
public class TryFinally {
    public static void main(String[] args) {
        try {
            main(args);
        } finally {

            main(args);
        }
    }
}
