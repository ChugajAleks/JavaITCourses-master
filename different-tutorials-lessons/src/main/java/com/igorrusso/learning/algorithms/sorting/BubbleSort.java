package com.igorrusso.learning.algorithms.sorting;

import java.util.Arrays;

/**
 * User: Igor Russo
 * Date: 08.08.13
 * Time: 0:01
 */
public class BubbleSort {
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean sorted = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    sorted = false;
                }
            }

            if (sorted) break;

        }


        return arr;
    }

    private static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }
}
