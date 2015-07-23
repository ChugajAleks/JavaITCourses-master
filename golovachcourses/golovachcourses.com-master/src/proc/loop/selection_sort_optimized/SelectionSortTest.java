package proc.loop.selection_sort_optimized;

import java.util.Arrays;

public class SelectionSortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {6, 3, 8, 9, 2, 1};
		System.out.println(Arrays.toString(a));
		SelectionSorter.sort2(a);
		System.out.println(Arrays.toString(a));
	}

}


