package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

/**
 * Created by dell on 01-May-17.
 */
public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            int i = 0;
            while (true) {
                System.out.println(queue.poll());
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
