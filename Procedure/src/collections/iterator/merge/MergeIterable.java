package collections.iterator.merge;

import java.util.Iterator;

/**
 * User: Igor Russo
 * Date: 17.03.13
 * Time: 0:31
 */
public class MergeIterable implements Iterable<Integer> {
    private final Iterable<Integer> first;
    private final Iterable<Integer> second;

    public MergeIterable(Iterable<Integer> first, Iterable<Integer> second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Returns an iterator over a set of elements of type T.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new MergeIterator(first, second);
    }
}
