package proc.loop.matrix_nui;

import java.util.Arrays;

public class MatrixTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int[][] m1 = {
				
	                {1, 2},
	                {7, 8},
	                {3, 4},
	                
	     };
	     
	     int[][] m2 = {
	    		 
	                {3, 4, 5, 6},
	                {9, 0, 1, 2},
	                
	     };
	     */

	        int[][] m1 = {
	                {1, 2, 3},
	                {4, 5, 6},
	                {7, 8, 9}};

	        int[][] m2 = {
	                {1, 2, 3},
	                null,
	                {7, 8, 9}};

	        
		/*
	        int[][] m1 = {{10}};
	        int[][] m2 = {{100}};
	        */

	     int[][] m = MatrixUtils.mul(m1,  m2);
	     System.out.println(Arrays.deepToString(m));

	}

}
