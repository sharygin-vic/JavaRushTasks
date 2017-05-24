package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by dell on 23-May-17.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
        }
        catch (InterruptedException e) {
            return;
        }
        while (true) {
            try {
                ShareItem item = queue.take();
                System.out.format("Processing %s%n", item.toString());
            }
            catch (InterruptedException e) {
                break;
            }
        }
    }
}
