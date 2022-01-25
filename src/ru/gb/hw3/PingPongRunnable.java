package ru.gb.hw3;

public class PingPongRunnable implements Runnable {
    private Object lock;
    private String message;

    public PingPongRunnable(String message, Object lock) {
        this.message = message;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                System.out.println(message);
                lock.notify();
                try {
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Thread ping = new Thread(new PingPongRunnable("Ping", lock));
        Thread pong = new Thread(new PingPongRunnable("Pong", lock));
        ping.start();
        pong.start();
    }
}