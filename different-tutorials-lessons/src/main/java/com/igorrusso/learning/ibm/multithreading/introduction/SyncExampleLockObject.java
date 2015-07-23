package com.igorrusso.learning.ibm.multithreading.introduction;

/**
 * User: Igor Russo
 * Date: 11.08.13
 * Time: 13:00
 */
public class SyncExampleLockObject {
    private static Object lockObject = new Object();
    private static int x;
    private static int y;

    public static void main(String[] args) {
        (new Thread1()).start();
        (new Thread2()).start();
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lockObject) {
                x = y = 1;
                System.out.println(x);
            }
        }
    }

    private static class Thread2 extends Thread {


        @Override
        public void run() {
            synchronized (lockObject) {
                x = y = 0;
                System.out.println(y);
            }
        }
    }
}
