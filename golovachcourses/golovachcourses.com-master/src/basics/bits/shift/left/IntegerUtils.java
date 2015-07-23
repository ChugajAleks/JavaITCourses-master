package basics.bits.shift.left;

public class IntegerUtils {

    public static int leftShift(int arg) {
        return Integer.rotateLeft(arg, 1);
    }

}