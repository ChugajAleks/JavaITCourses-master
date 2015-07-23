package proc.loop.insertion_sort_optimized;

import java.util.Arrays;

public class InsertionSorter {
    public static void sort(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int location = k - 1;

            while (location >= 0 && arr[location] > newElement) {
                arr[location + 1] = arr[location];
                location--;
            }
            arr[location + 1] = newElement;
        }
    }

    public static void sort2(int[] arr) {

        int s = arr.length;
        for (int k = 1; k < arr.length; k++) {

            int newElement = arr[k];
            int location = k - 1;

//            System.out.println("");
//            System.out.println("New element for search = " + newElement);
            // we suppose first element is already sorted 
            // binary search also allow to find position of element to paste among first 0..location elements
            //int newPosition  = Arrays.binarySearch(arr, 0, location, newElement);
            int newPosition = Arrays.binarySearch(arr, 0, k, newElement);


            if (newPosition < 0) {

                //
                // trace:
                //
                // 4 3 2 1 0
                // found 3, tmp = 3, binarySearch return new Position to paste (0), after arraycopy (right shift for 1 position) -> 4 4 2 1 0 -> get the value from tmp -> 3 4 2 1 0
                //  3 4 2 1 0
                //
                // found 2, tmp = 2, after arraycopy (right shift for 2 positions)-> 3 3 4 1 0 -> get the value from tmp -> 2 3 4 1 0
                // 2 3 4 1 0
                //
                // found 1, tmp = 1, after arraycopy (right shift for 3 positions)-> 2 2 3 4 0 -> get the value from tmp -> 1 2 3 4 0
                // 1 2 3 4 0
                //
                // found 0, tmp = 0, after arraycopy (right shift for 4 positions)-> 1 1 2 3 4 -> get the value from tmp -> 0 1 2 3 4
                // end.

                newPosition = -(newPosition + 1);


            }


//            System.out.println("after Binary search, new Position = " + newPosition);

            int tmp = newElement;

            // if we found new element which == the current value
            /*
            if (tmp == arr[newPosition]) {
            	System.out.println("Skipped. DONE" + Arrays.toString(arr));
            	continue;
            }
            */

            // shift part of an array with arraycopy method to the right
            //System.arraycopy(arr, newPosition, arr, newPosition+1, s-k);
            //System.arraycopy(arr, newPosition, arr, newPosition+1, k);
            //System.arraycopy(arr, newPosition, arr, newPosition+1, k-1);

            System.arraycopy(arr, newPosition, arr, newPosition + 1, k - newPosition);

            // paste value to position where it should be
            arr[newPosition] = tmp;

//            System.out.println("DONE" + Arrays.toString(arr));


        }
    }

}




/*

[6, 3, 8, 9, 2, 1]



Такая версия алгоритм сортировки вставками

реализована не оптимально, так как внутренний цикл while
- ищет позицию для вставки, перебирая последовательно элементы, при этом он
- поэлементно "смещает" массив.
В целях оптимизации перепишите алгоритм:
>> 1. Ищите позицию для вставки элемента бинарным поиском (Arrays.binarySearch(...)) ??? - ссылка.
 
2. Найдя позицию - смещайте всю часть массива за один вызов (System.arraycopy(...)) ??? - ссылка.
В моих экспериментах эти две оптимизации ускорили сортировку в ??? раза.
??? - измерялка скорости тут.


*/