package collections.iterator;

import collections.iterator.merge.MergeIterable;
import collections.iterator.square.SquaresIterable;

/**
 * User: Igor Russo
 * Date: 13.03.13
 * Time: 23:50
 */
public class IteratorUtils {
    public static Iterable<Integer> interval(int left, int right) {
        return new IntervalIterable(left, right);
    }

    public static Iterable<Integer> squares(int left, int right) {
        return new SquaresIterable(left, right);
    }

    public static Iterable<Integer> merge(Iterable<Integer> first, Iterable<Integer> second) {
        return new MergeIterable(first, second);
    }
}
