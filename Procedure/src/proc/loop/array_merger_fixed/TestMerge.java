package proc.loop.array_merger_fixed;
    import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 14.01.13
 * Time: 23:26
 * To change this template use File | Settings | File Templates.
 */
public class TestMerge {
    public static void main(String[] args) {
        int[][][] data = {
                {{}, {}},
                {{1}, {}},
                {{}, {1}},
                {{1}, {2}},
                {{0, 2}, {1, 3}},
                {{0, 2, 7, 9, 123, 189, 287}, {1, 2, 4, 5, 6}},
        };

        for (int[][] origin : data) {
            int[] left = origin[0];
            int[] right = origin[1];
            int[] merged = MergerFast.merge(left, right);

            System.out.println(
                    Arrays.toString(left) +
                            " + " +
                            Arrays.toString(right) +
                            " -> " +
                            Arrays.toString(merged));
            System.out.println();
        }

    }
}
