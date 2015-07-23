package collections.iterator;

/**
 * User: Igor Russo
 * Date: 13.03.13
 * Time: 23:51
 */
import java.util.Iterator;

public class IntervalIterable implements Iterable<Integer> {
    private final int left;
    private final int right;

    public IntervalIterable(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntervalIterator(left, right);
    }
}
