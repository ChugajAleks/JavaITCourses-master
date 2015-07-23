package proc.loop.array_merger_fixed;

/**
 * Created by aleks on 22.07.15.
 */
public class MergerFast {
    public static int[] merge(int[] leftArr, int[] rightArr) {

        int[] result = new int[leftArr.length + rightArr.length];
        int leftIndex = 0;
        int rightIndex = 0;

        try {
            for (int pos = 0; true; pos++) {

                if (leftIndex >= leftArr.length) {
                    System.arraycopy(rightArr, rightIndex, result, pos, rightArr.length - rightIndex);
                    break;
                }
                if (rightIndex >= rightArr.length) {
                    System.arraycopy(leftArr, leftIndex, result, pos, leftArr.length - leftIndex);
                    break;
                }

                if (leftArr[leftIndex] < rightArr[rightIndex]) {
                    result[pos] = leftArr[leftIndex];
                    leftIndex++;
                } else {
                    result[pos] = rightArr[rightIndex];
                    rightIndex++;
                }


            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            return result;
        }

        return result;
    }
}
