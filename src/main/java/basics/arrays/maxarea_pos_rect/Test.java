package basics.arrays.maxarea_pos_rect;

/**
 *
 */
public class Test {
    public static void main(String[] args) {
        int[][] array = {
                {1, 1},
                {1, 1},
        };

        //long actualArea = ArrayUtils.maxArea(array);
        long actualArea = Test4Site.maxArea(array);

        if (actualArea != 4) {
            throw new AssertionError(actualArea);
        }

        System.out.print("OK");
    }
}