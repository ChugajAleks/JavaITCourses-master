package proc.loop.selection_sort_optimized;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 17.01.13
 * Time: 0:50
 * To change this template use File | Settings | File Templates.
 */
public class SelectionSortTest {

    public static void main(String[] args) {
        System.out.println("SelectionSortTest");
        int[][] data = {
                {},
                {1},
                {2, 1},
                {6, 4, 2},
                {0, 3, 2, 1},
                {6, 8, 3, 100, 5, 4, 1, 2, 0, 9, 7},
        };
        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + " -> ");
            SelectionSortOptimized.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
