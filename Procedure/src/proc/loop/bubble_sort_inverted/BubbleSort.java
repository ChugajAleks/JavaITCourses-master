package proc.loop.bubble_sort_inverted;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 16.01.13
 * Time: 1:09
 * To change this template use File | Settings | File Templates.
 */
public class BubbleSort {
    public static void sort(int[] arr) {
        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (arr[index] > arr[index + 1]) {
                    int tmp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = tmp;
                }
            }
        }
    }
}
