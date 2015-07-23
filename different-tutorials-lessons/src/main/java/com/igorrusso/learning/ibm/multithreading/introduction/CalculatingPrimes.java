package com.igorrusso.learning.ibm.multithreading.introduction;

/**
 * User: Igor Russo
 * Date: 07.08.13
 * Time: 23:13
 */
public class CalculatingPrimes extends Thread {
    private static final int TEN_SECONDS = 5_000;
    private static final int MAX_PRIMES = 1000_000;
    public volatile boolean finished;

    public static void main(String[] args) {
        CalculatingPrimes calculator = new CalculatingPrimes();
        calculator.start();

        try {
            Thread.sleep(TEN_SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        calculator.finished = true;
    }

    @Override
    public void run() {
        int[] primes = new int[MAX_PRIMES];
        int count = 0;

        for (int i = 2; count < MAX_PRIMES; i++) {
            if (finished) {
                System.out.println("Total: " + count);
                break;
            }

            boolean prime = true;
            for (int j = 0; j < count; j++) {
                if (i % primes[j] == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                primes[count++] = i;
                System.out.println("Found prime = " + i);
            }
        }
    }
}
