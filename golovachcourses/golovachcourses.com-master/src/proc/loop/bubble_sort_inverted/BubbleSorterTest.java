package proc.loop.bubble_sort_inverted;

import java.util.Arrays;

public class BubbleSorterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {6, 3, 8, 9, 2, 1};
		System.out.println(Arrays.toString(a));
		//BubbleSorter.sort(a);
		BubbleSorter.sort2(a);
		System.out.println(Arrays.toString(a));
	}

}
