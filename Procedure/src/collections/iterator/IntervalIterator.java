package collections.iterator;

import java.util.Iterator;

/**
 * User: Igor Russo
 * Date: 13.03.13
 * Time: 23:51
 */

public class IntervalIterator implements Iterator<Integer> {
    private final int max;
    private int current;

    public IntervalIterator(int left, int right) {
        this.max = right;
        this.current = left;
    }

    @Override
    public boolean hasNext() {
        return current < max;
    }

    @Override
    public Integer next() {
        return current++;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
