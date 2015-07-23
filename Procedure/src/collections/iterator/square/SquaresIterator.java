package collections.iterator.square;

import java.util.Iterator;

/**
 * User: Igor Russo
 * Date: 16.03.13
 * Time: 16:40
 */
public class SquaresIterator implements Iterator<Integer> {
    private final int max;
    private final int initValue;
    private int current;
    public SquaresIterator(int left, int right) {
        this.max = right;

        this.initValue = (int) Math.ceil(Math.sqrt(left));
        this.current = initValue;
    }

    @Override
    public boolean hasNext() {
        int nextCurrentPower2 = current * current;
        return nextCurrentPower2 >= initValue && nextCurrentPower2 < max;
    }

    @Override
    public Integer next() {
        return current * current++;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
