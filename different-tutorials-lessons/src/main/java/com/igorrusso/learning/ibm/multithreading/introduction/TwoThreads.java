package com.igorrusso.learning.ibm.multithreading.introduction;

/**
 * User: Igor Russo
 * Date: 08.08.13
 * Time: 23:55
 */

public class TwoThreads {

    public static class Thread1 extends Thread {
        public void run() {
            System.out.println("A");
            System.out.println("B");
        }
    }

    public static class Thread2 extends Thread {
        public void run() {
            System.out.println("1");
            System.out.println("2");
        }
    }

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
}
