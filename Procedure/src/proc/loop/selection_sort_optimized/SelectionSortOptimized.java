package proc.loop.selection_sort_optimized;

/**
 * Created by aleks on 22.07.15.
 */
public class SelectionSortOptimized {
    public static void sort(int[] arr) {
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            int tmpIndex = barrier;
            int barrierValue = arr[barrier];
            for (int index = barrier + 1; index < arr.length; index++) {
                if (barrierValue > arr[index]) {
                    tmpIndex = index;
                    barrierValue = arr[index];
                }
            }
            arr[tmpIndex] = arr[barrier];
            arr[barrier] = barrierValue;
        }
    }
}
