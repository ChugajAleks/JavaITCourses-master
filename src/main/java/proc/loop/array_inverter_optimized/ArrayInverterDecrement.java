package proc.loop.array_inverter_optimized;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 16.01.13
 * Time: 1:28
 * To change this template use File | Settings | File Templates.
 */
public class ArrayInverterDecrement {
    public static void invert(int[] arr) {
        for (int k = arr.length / 2 -1; k >=0 ; k--) {
            int tmp = arr[k];
            arr[k] = arr[arr.length - k -1];
            arr[arr.length - k -1] = tmp;
        }
    }
}
