package basics.bits.shift.right;

public class IntegerUtils {

    public static int rightShift(int arg) {
        return Integer.rotateRight(arg, 1);
    }

}
