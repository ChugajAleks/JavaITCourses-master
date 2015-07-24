package basics.arrays.maxarea_pos_rect;

import java.util.Arrays;
import java.util.Stack;

/**
 * В заданной двухмерной матрице (возможно не прямоугольной, возможно содержащей null или массивы длины 0 вместо строк)
 * найти прямоугольный участок максимальной площади содержащий только элементы больше нуля. И вернуть площадь этого участка.
 * Если вместо массива null или массив длины 0 - выбрасывать IllegalArgumentException.
 * Если нет такого прямоугольника (пример: все элементы не больше нуля, все строки null) - возвращать -1.
 * ---
 * {{1, 1}, {1, 1}} - возвращать 4
 * {{0, 1}, {1, 1}} - возвращать 2
 * {{1, 1, 1}, {1, 1, 1}, {1, 1, 0}} - возвращать 6
 * {{0, 1, 1}, {1, 1, 1}, {1, 1, 0}} - возвращать 4
 * ---
 * null или new int[0][] - IllegalArgumentException
 * new int[][] {null, null, null} - возвращать -1
 * new int[][] {{}, {}, {}} - возвращать -1
 * new int[][] {{0, 0, 0}, {-1, -1}, {-2}} - возвращать -1
 *
 * http://n00tc0d3r.blogspot.ru/2013/04/maximum-rectangle.html
 *
 */
public class ArrayUtils {

    public static long maxArea(int[][] array) {

        /*Condition 1. Check array for null and if it's length==0, throw exception*/
        if (array == null || array.length == 0) throw new IllegalArgumentException("wrong input matrix: array=null or length=0");

        /*Condition 2. if all rows == null throw exception*/
        boolean isNull = true;
        for (int i=0; i<array.length; i++) {
            if (array[i] != null) {
                isNull = false;
                break;
            }
        }
        if (isNull) return -1;

        int rows = array.length;
        if (rows == 0) return 0;
        int columns = array[0].length;

        array = putZerosArray(array);
        columns = rows;

        /*Condition 3. if all elements <= 0 throw exception*/
        boolean isLessOqEqualsZero = true;
        for (int w=0; w<rows && isLessOqEqualsZero; ++w) {
            for (int h = 0; h < array[w].length; h++) {
                if (array[w][h] > 0 ) {
                    isLessOqEqualsZero = false;
                    break;
                }
            }
        }
        if (isLessOqEqualsZero) return -1;


        // make additional table lenTable
        int[][] lenTable = new int[rows][columns];
        // initialize the table
        for (int h=0; h<columns; ++h) {
            if (array[0][h] > 0) lenTable[0][h] = 1;
        }
        for (int w=1; w<rows; ++w) {
            for (int h=0; h<columns; ++h) {
                if (array[w][h] <= 0) continue;
                lenTable[w][h] = lenTable[w-1][h] + 1;
            }
        }

        //System.out.println("lenTable = " + Arrays.deepToString(lenTable));

        // find the max rect area
        int maxArea = 0;
        for (int i=0; i<rows; ++i) {
            maxArea = Math.max(maxArea, maxRectangle(lenTable[i]));
        }
        return maxArea;


    }

    /**
     * Put zeros in the empty spaces and to call it rectangular
     *
     *
     * 1 1 0     1 1 0
     * 1 1 1  -> 1 1 1
     * 1 1 1     1 1 1
     *
     *
     * 1 1 1     1 1 1
     * 1 1    -> 1 1 0
     * 1 1 1     1 1 1
     *
     * 1 1 1     1 1 1
     * 1 1 1  -> 1 1 1
     * 1   1     1 0 1
     *
     * @param array - matrix
     * @return - matrix with zeros
     */
    private static int[][] putZerosArray(int[][] array) {
        // init rectangle array with zeros
        int[][] arrayRect = new int[array.length][array.length];
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array.length; j++) {
                arrayRect[i][j] = 0;
            }
        }

        // copy to rectangle array all elements from income array
        for (int w=0; w<array.length; ++w) {
            for (int h = 0; h < array[w].length; h++) {
                System.out.println("array[w][h] = "+ array[w][h]);
                arrayRect[w][h] = array[w][h];
            }

        }

        //System.out.println("result: ");
        //System.out.println(Arrays.deepToString(arrayRect));

        return arrayRect;

    }

    private static int maxRectangle(int[] histogram) {
        Stack<Integer> ss = new Stack<Integer>();
        int maxArea = 0, i = 0;
        while (i < histogram.length) {
            if (ss.isEmpty() || histogram[i] >= histogram[ss.peek()]) {
                ss.push(i++);
            } else {
                maxArea = Math.max(maxArea,
                        histogram[ss.pop()]*(ss.isEmpty() ? i : (i - ss.peek() - 1)));
            }
        }
        while (!ss.isEmpty()) {
            maxArea = Math.max(maxArea,
                    histogram[ss.pop()]*(ss.isEmpty() ? i : (i - ss.peek() - 1)));
        }
        return maxArea;
    }


}



class MaxAreaTest {

    public static void main(String[] args) {

        int[][] arr = new int[][] {{}, {}, {}};

        System.out.println(ArrayUtils.maxArea(arr));

    }
}