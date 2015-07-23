package collections.iterator.merge;

import java.util.Iterator;

/**
 * User: Igor Russo
 * Date: 17.03.13
 * Time: 0:33
 */
public class MergeIterator implements Iterator<Integer> {
    public MergeIterator(Iterable<Integer> first, Iterable<Integer> second) {
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws java.util.NoSuchElementException
     *          if the iteration has no more elements
     */
    @Override
    public Integer next() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Removes from the underlying collection the last element returned
     * by this iterator (optional operation).  This method can be called
     * only once per call to {@link #next}.  The behavior of an iterator
     * is unspecified if the underlying collection is modified while the
     * iteration is in progress in any way other than by calling this
     * method.
     *
     * @throws UnsupportedOperationException if the {@code remove}
     *                                       operation is not supported by this iterator
     * @throws IllegalStateException         if the {@code next} method has not
     *                                       yet been called, or the {@code remove} method has already
     *                                       been called after the last call to the {@code next}
     *                                       method
     */
    @Override
    public void remove() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
