package com.igorrusso.learning.ibm.multithreading.introduction;

/**
 * User: Igor Russo
 * Date: 08.08.13
 * Time: 23:59
 */
public class TenThreads {
    public static void main(String[] args) {
        WorkerThread[] threads = new WorkerThread[10];
        int[][] bigMatrix = getBigHairyMatrix();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 10; i++) {
            threads[i] = new WorkerThread(bigMatrix[i]);
            threads[i].start();
        }

        try {
            for (int i = 0; i < 10; i++) {
                threads[i].join();
                max = Math.max(max, threads[i].getMax());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Maximum value is max = " + max);
    }

    private static int[][] getBigHairyMatrix() {
        return new int[][]{
                {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
                {100, 91, 92, 93, 94, 95, 96, 97, 98, 99},
                {80, 81, 82, 835, 84, 85, 86, 87, 88, 89},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},

                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 50},
                {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
                {21, 22, 23, 24, 25, 26, 27, 28, 29, 40},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}
        };
    }

    private static class WorkerThread extends Thread {
        int max = Integer.MIN_VALUE;
        int[] ourArray;

        public WorkerThread(int[] ourArray) {
            this.ourArray = ourArray;
        }

        @Override
        public void run() {
            for (int anOurArray : ourArray) {
                max = Math.max(max, anOurArray);
            }
        }

        public int getMax() {
            return max;
        }
    }
}
