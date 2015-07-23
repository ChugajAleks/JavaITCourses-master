package proc.recursion.permutation;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 22.01.13
 * Time: 1:09
 * To change this template use File | Settings | File Templates.
 */
import java.util.Arrays;

public class Permutation_q {
    private static int initSize = 0;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4};
        permutation(arr, arr.length);
    }
    private static void permutation(int[] arr, int size) {
        if (size < 2) {
            System.out.println("\t\t" + Arrays.toString(arr));
        } else {
            for (int k = 0; k < size; k++) {
                //if(size == 2) System.out.print("\t");
                //System.out.println(k + ". before = " + Arrays.toString(arr) + "; size = " + size + "; swapping arr[" + k + "] = " + arr[k] + " <-> arr[" + (size-1) + "] = " + arr[size-1] );

                swap(arr, k, size - 1);
                permutation(arr, size - 1);
                swap(arr, k, size - 1);
            }
        }
    }
    private static void swap(int[] arr, int index0, int index1) {
        int tmp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = tmp;
    }
}