package proc.loop.array_inverter_optimized;
import java.util.Arrays;


public class ArrayInverter {
    
	public static void invert(int[] data) {
        for (int k = data.length / 2 - 1; k >= 0; k--) {
            int tmp = data[k];
            data[k] = data[data.length - k - 1];
            data[data.length - k - 1] = tmp;
        }
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0, 3, 1, 8, 9, 4, 7};
		System.out.println("arr = " + Arrays.toString(arr));
		ArrayInverter.invert(arr);
		System.out.println("arr = " + Arrays.toString(arr));

        int[] s;

    }




}
