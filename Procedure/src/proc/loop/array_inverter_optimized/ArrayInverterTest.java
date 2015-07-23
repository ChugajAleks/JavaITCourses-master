package proc.loop.array_inverter_optimized;

import java.util.Arrays;

import static proc.loop.array_inverter_optimized.ArrayInverterOptimized.invert;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 16.01.13
 * Time: 1:28
 * To change this template use File | Settings | File Templates.
 */
public class ArrayInverterTest {

    public static void main(String[] args) {
        int[] arr;

        arr = new int[]{};
        System.out.print(Arrays.toString(arr) + " -> ");
        invert(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0};
        System.out.print(Arrays.toString(arr) + " -> ");
        invert(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 1};
        System.out.print(Arrays.toString(arr) + " -> ");
        invert(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 1, 2};
        System.out.print(Arrays.toString(arr) + " -> ");
        invert(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print(Arrays.toString(arr) + " -> ");
        invert(arr);
        System.out.println(Arrays.toString(arr));
    }
}
