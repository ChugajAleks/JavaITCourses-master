package proc.loop.arraY_merger_fixed;

import java.util.Arrays;

public class MergerTest {
	
	
   
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0, 2, 7, 9, 123};
		int[] b = {1, 3, 4, 5, 6};

		//int[] a = {0, 2, 7, 11, 19, 23, 55, 59, 100, 1002, 2203, 5000, 10000};
		//int[] b = {1, 3, 4, 5, 6};

		
		int[] merged = Merger.merge(a, b);
		
		System.out.println(Arrays.toString(merged));
		
		 
		
		
		
				
		
		
		

	}

}

