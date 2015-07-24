package basics.arrays.maxarea_pos_rect;

/**
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
 */
public class Test_My {
    public static void main(String[] args) {
        int[][] array = {
                {0, 0, 0, 1, 1, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 1},
        };

        //long actualArea = ArrayUtils.maxArea(array);
        long actualArea = ArrayUtils_My.maxArea(array);

     /*   if (actualArea != 4) {
            throw new AssertionError(actualArea);
        }*/
			
        System.out.print("OK Area = " + actualArea);
    }
}