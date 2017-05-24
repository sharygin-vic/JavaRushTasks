package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by dell on 23-May-17.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
            for (int i = 1; i <= 9; i++) {
                ShareItem item = new ShareItem("ShareItem-" + i, i);
                System.out.format("Элемент 'ShareItem-%d' добавлен%n", i);
                queue.offer(item);
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    break;
                }
                if (queue.hasWaitingConsumer()) {
                    System.out.format("Consumer в ожидании!%n");
                }
            }
    }
}
