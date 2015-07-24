package basics.arrays.maxarea_pos_rect;

import java.util.Arrays;

/**
 * Проверка вернула ошибку:

 Код не прошел тесты
 Код проверки выдавшей ошибку:
 public class Test {
 public static void main(String[] args) {
 int[][] array = {
 {1, 1},
 {1, 1},
 };

 long actualArea = ArrayUtils.maxArea(array);
 if (actualArea != 4) {
 throw new AssertionError(actualArea);
 }

 System.out.print("OK");
 }
 }

TODO: глюк проверки лабы на сайте...

 */
public class Test4Site {

    public static long maxArea(int[][] array) {


        // first check array for null and if it's length==0, throw exception
        if (array == null || array.length == 0) throw new IllegalArgumentException("wrong input matrix: array=null or length=0");

        // if all rows == null throw exception
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

        // put zeros in the empty spaces and to call it rectangular

        /*
        1 1 0     1 1 0
        1 1 1  -> 1 1 1
        1 1 1     1 1 1


        1 1 1     1 1 1
        1 1    -> 1 1 0
        1 1 1     1 1 1

        1 1 1     1 1 1
        1 1 1  -> 1 1 1
        1   1     1 0 1
        */

        // init rectangle array with zeros
        int[][] arrayRect = new int[rows][rows];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<rows; j++) {
                arrayRect[i][j] = 0;
            }
        }

        // copy to rectangle array all elements from income array
        for (int w=0; w<rows; ++w) {
            for (int h = 0; h < array[w].length; h++) {
                System.out.println("array[w][h] = "+ array[w][h]);
                arrayRect[w][h] = array[w][h];
            }

        }

        //System.out.println("result: ");
        //System.out.println(Arrays.deepToString(arrayRect));


        array = arrayRect;
        columns = rows;


        // if all elements <= 0 throw exception
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
        int maxArea_v = 0;
        for (int i=0; i<rows; ++i) {



            java.util.Stack<Integer> ss = new java.util.Stack<Integer>();
            maxArea_v = 0;
            int j = 0;
            while (j < lenTable[i].length) {
                if (ss.isEmpty() || lenTable[i][j] >= lenTable[i][ss.peek()]) {
                    ss.push(j++);
                } else {
                    maxArea_v = Math.max(maxArea_v,
                            lenTable[i][ss.pop()]*(ss.isEmpty() ? j : (j - ss.peek() - 1)));
                }
            }
            while (!ss.isEmpty()) {
                maxArea_v = Math.max(maxArea_v,
                        lenTable[i][ss.pop()]*(ss.isEmpty() ? j : (j - ss.peek() - 1)));
            }




            maxArea = Math.max(maxArea, maxArea_v);
        }


        return maxArea;


    }
}
