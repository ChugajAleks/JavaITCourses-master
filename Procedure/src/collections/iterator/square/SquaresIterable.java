package collections.iterator.square;

import java.util.Iterator;

/**
 * User: Igor Russo
 * Date: 16.03.13
 * Time: 16:31
 */
public class SquaresIterable implements Iterable<Integer> {
    private final int left;
    private final int right;

    public SquaresIterable(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SquaresIterator(left, right);
    }
}
