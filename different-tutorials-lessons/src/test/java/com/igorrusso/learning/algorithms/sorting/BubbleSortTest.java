package com.igorrusso.learning.algorithms.sorting;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * User: Igor Russo
 * Date: 08.08.13
 * Time: 0:36
 */
public class BubbleSortTest {
    @Test
    public void testSort() throws Exception {
        int[] source = {8, 7, 2, 4, 5, 9, 78, 1, 3, 2, 0};
        int[] expected = new int[source.length];

        System.arraycopy(source, 0, expected, 0, source.length);
        BubbleSort.sort(source);
        Arrays.sort(expected);

        assertArrayEquals("Arrays are not equal", expected, source);
    }

    @Test
    public void testEmptyArraysSort() throws Exception {
        int[] source = {};
        int[] expected = {};

        BubbleSort.sort(source);
        assertArrayEquals("Empty arrays are not equal", expected, source);
    }

    @Test(expected = NullPointerException.class)
    public void testNullArraysSort() throws Exception {
        int[] source = null;
        BubbleSort.sort(source);
    }
}
