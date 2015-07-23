package proc.loop.selection_sort_optimized;

import java.util.Arrays;

public class SelectionSorter {
    public static void sort(int[] arr) {
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            for (int index = barrier + 1; index < arr.length; index++) {
                if (arr[barrier] > arr[index]) {
                    int tmp = arr[index];
                    arr[index] = arr[barrier];
                    arr[barrier] = tmp;
                }
            }
        }
    }
    
    public static void sort2(int[] arr) {
    	
    	int a, b = 0; // local variable for the array value, instead of accessing to arr[barrier]
    	
    	
        for (int barrier = 0; barrier < arr.length-1; barrier++) {
        	
        	int m = arr[barrier];
        	
        	int mIndex = -1;	// set index -1 for the min element. It means, that there is not founded value yet.
        	
        	for (int index = barrier + 1; index < arr.length; index++) {
        		
            	if (arr[index] < m) {
            		m = arr[index];
            		mIndex = index;
            	}

            }
        	
    		//System.out.println("Found min m value = " + m);
    		//System.out.println("Found index of min m value = " + mIndex);
        	
        	// changing two element without tmp variable.
    		
    		// if min value was not found
    		if (mIndex != -1) {

    			a = arr[barrier];
    			b = arr[mIndex];
    			
    			arr[barrier] = a = a + b;        // 6 -> 6+1 = 7
    			arr[mIndex]  = b = a - b;  		 // 1 -> 7-1 = 6
    			arr[barrier] = a = a - b; 	     // 1 -> 7-6 = 1
    			
    			//System.out.println(Arrays.toString(arr));
    			
    		} else {
    			
    			//System.out.println("min index not found!");
    			
    		}
        }
    }    
}














/*
Переписать алгоритм сортировки выборками:

1. Убрать обмен элементами arr[barrier] c arr[index] каждый раз, когда находится очередной меньший элемент. 
   Найти наименьший элемент во всем массиве - и обменять с ним.
2. Убрать обращение во внутреннем цикле к элементу массива arr[barrier].
   Вычитать(вычислять????) значение ячейки массива в локальную переменную и использовать ее.

   В моих экспериментах пункт #1 ускорил сортировку в 2 раза. Пункт #2 ускорил сортировку еще на 10%-20%.
   ??? - измерялка скорости тут.

*/