package proc.loop.bubble_sort_inverted;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 16.01.13
 * Time: 1:10
 * To change this template use File | Settings | File Templates.
 */
public class TestBubbleSort {
    public static void main(String[] args) {
        int[][] data = {
            {},
            {1},
            {0, 3, 2, 1},
            {6, 8, 3, 5, 4, 1, 2, 0, 9, 7},
        };


        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + " -> ");
            BubbleSort_My.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
