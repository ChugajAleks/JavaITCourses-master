package proc.loop.insertion_sort_optimized;

import java.util.Arrays;

/**
 * Created by aleks on 22.07.15.
 */
public class InsertionSortOptimized {
    public static int[] sort(int[] arr) {
        for (int barrier = 1; barrier < arr.length; barrier++) {
            int insertElement = arr[barrier];

            if(insertElement < arr[barrier -1]) {
                int insertPosition = Arrays.binarySearch(arr, 0, barrier - 1, insertElement);
                insertPosition = (insertPosition >= 0) ? insertPosition : -insertPosition - 1;

                int lengthToCopi = barrier - insertPosition;
                System.arraycopy(arr, insertPosition, arr, insertPosition +1, lengthToCopi);
                arr[insertPosition] = insertElement;
            }
        }
        return arr;
    }
}
