package ex.strategy.spinup_chained;

/**
 * User: Igor Russo
 * Date: 02.02.13
 * Time: 22:44
 */
public class ExceptionLab_ChainedExceptions {
    public static void main(String[] args) {
        try {
            f();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static void f() {
        RuntimeException tail = new RuntimeException("0");
        for (int k = 1; k < 10; k++) {
            tail = new RuntimeException("" + k, tail);
        }
        throw tail;
    }
}