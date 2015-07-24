package basics.arrays.maxarea_pos_rect;

/**
 *
 */
public class Test_My {
    public static void main(String[] args) {
        int[][] array = {
                {0, 0, 0, 1, 1, 0, 1},
                {0, 1, 1, 1, 1, 1, 1},
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