package proc.loop.selection_sort_optimized;

/**
 Есть гипотеза, что обращение к локальной переменной типа int происходит быстрее
 чем обращение к элементу локальной переменной типа int[].
 Задание состоит в том, что бы переписать алгоритм Selection Sort:
 - убрать обращение во внутреннем цикле к элементу массива arr[barrier]
 - убрать обмен элементами arr[barrier] c arr[index] каждый раз,
 когда находится очередной меньший элемент. Найти наименьший элемент - обменять с ним.
 */
public class SelectionSort {

    public static void sort(int[] arr) {
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            int barrierValue = arr[barrier];
            int lastMinIndex = barrier;
            for (int index = barrier + 1; index < arr.length; index++) {
                if (barrierValue > arr[index]){
                    barrierValue = arr[index];
                    lastMinIndex = index;
                }
            }
            swap(arr, barrier, lastMinIndex);
        }
    }

    private static void swap(int[] arr, int indexA, int indexB){
        // using tmp for clearness
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
}
