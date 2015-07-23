package collections.iterator;

import static collections.iterator.IteratorUtils.interval;
import static collections.iterator.IteratorUtils.merge;


public class MergeIteratorTest {
    public static void main(String[] args) {
        for (int k : merge(interval(10, 12), interval(10, 12))) {
            System.out.print(" " + k);
        }
        System.out.println();

        for (int k : merge(interval(10, 10), interval(10, 12))) {
            System.out.print(" " + k);
        }
        System.out.println();

        for (int k : merge(interval(10, 12), interval(10, 10))) {
            System.out.print(" " + k);
        }
        System.out.println();

        for (int k : merge(interval(10, 10), interval(10, 10))) {
            System.out.print(" " + k);
        }
        System.out.println();

        for (int k : merge(interval(0, 10), interval(1000, 1002))) {
            System.out.print(" " + k);
        }
        System.out.println();

        for (int k : merge(interval(1000, 1002), interval(0, 10))) {
            System.out.print(" " + k);
        }
        System.out.println();

        for (int k : merge(interval(0, 10), interval(5, 15))) {
            System.out.print(" " + k);
        }
        System.out.println();
    }
}