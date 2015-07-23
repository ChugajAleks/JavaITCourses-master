package com.igorrusso.learning.ibm.multithreading.introduction;

/**
 * User: Igor Russo
 * Date: 11.08.13
 * Time: 22:54
 */
public class UnsafeStack {
    public int top = 0;
    public int[] values = new int[1000];

    public void push(int n) {
        values[top++] = n;
    }

    public int pop() {
        return values[--top];
    }
}

class Counter {
    private int counter = 0;

    public int get() {
        return counter;
    }

    public void set(int n) {
        counter = n;
    }

    public void increment() {
        set(get() + 1);
    }
}