package proc.loop.insertion_sort_optimized;

import java.util.Arrays;

public class InsertionSorterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	      int[][] data = {
	    		    
	                {},
	                {1},
	                {0, 3, 2, 1},
	                {4, 3, 2, 1, 0},
	                {6, 8, 3, 123, 5, 4, 1, 2, 0, 9, 7},
	        };
	      
	        double time = 0.0;
	      
	        long t1 = System.nanoTime();
	        
	        for (int[] arr : data) {
	        	System.out.print(Arrays.toString(arr) + " -> ");
	            InsertionSorter.sort2(arr);
	            System.out.println(Arrays.toString(arr));
	        }
	        
            time = (System.nanoTime() - t1) / 1_000_000.0;
            System.out.println("A:" + time);


	      
	}

}
