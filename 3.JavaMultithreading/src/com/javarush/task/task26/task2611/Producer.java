package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dell on 01-May-17.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        int i = 0;
        while (!currentThread.isInterrupted()) {
            i++;
            map.put(""+i, "Some text for " + i);
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                System.out.println("[" + currentThread.getName() + "] thread was terminated");
                break;
            }
        }
    }
}
