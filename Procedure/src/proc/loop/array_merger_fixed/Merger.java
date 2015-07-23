package proc.loop.array_merger_fixed;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 14.01.13
 * Time: 23:25
 * To change this template use File | Settings | File Templates.
 */
public class Merger {
    public static int[] merge(int[] first, int[] second) { // wrong!
        int[] result = new int[first.length + second.length];
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex + secondIndex != result.length ) {
            boolean firstIndexInBounds = firstIndex < first.length;
            boolean secondIndexInBounds = secondIndex < second.length;

            if(!firstIndexInBounds && secondIndexInBounds){
                System.arraycopy(second, secondIndex, result, firstIndex + secondIndex, second.length - secondIndex);
                break;
            }

            if(!secondIndexInBounds && firstIndexInBounds){
                System.arraycopy(first, firstIndex, result, secondIndex + firstIndex, first.length - firstIndex);
                break;
            }

            if (first[firstIndex] < second[secondIndex]) {
                result[firstIndex + secondIndex] = first[firstIndex];
                firstIndex++;
            } else if (secondIndexInBounds) {
                result[firstIndex + secondIndex] = second[secondIndex];
                secondIndex++;
            }
        }

        return result;
    }
}
