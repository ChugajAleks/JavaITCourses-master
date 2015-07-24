package proc.loop.insertion_sort_optimized;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 18.01.13
 * Time: 1:47
 * To change this template use File | Settings | File Templates.
 */
class TestInsertionSort {
    public static void main(String[] args) {
        int[][] data = {
                {},
                {1},
                {0, 3, 2, 1},
                {6, 8, 3, 123, 3, 4, 1, 2, 0, 9, 7},
        };

        for (int[] arr : data) {
            System.out.println(Arrays.toString(arr) + " -> ");
            InsertionSortOptimized.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}

