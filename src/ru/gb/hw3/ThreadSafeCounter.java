package ru.gb.hw3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCounter {
    private static final Lock lock = new ReentrantLock();
    private static long counter;

    public static void increment() {
        try {
            lock.lock();
            System.out.println(++counter);
        } finally {
            lock.unlock();
        }
    }

    private static class CountingRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                ThreadSafeCounter.increment();
            }
        }
    }

    public static void main(String[] args) {
        (new CountingRunnable()).run();
        (new CountingRunnable()).run();

    }
}
