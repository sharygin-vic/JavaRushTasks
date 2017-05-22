package com.javarush.task.task28.task2805;

/**
 * Created by dell on 07-May-17.
 */
public class MyThread extends Thread {
    private static int nextPrior = Thread.MIN_PRIORITY;

    {
        this.setPriority(nextPrior);
        nextPrior++;
        if (nextPrior > Thread.MAX_PRIORITY) {
            nextPrior = Thread.MIN_PRIORITY;
        }
    }

    public MyThread() {
        super();
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (getPriority() > group.getMaxPriority()) {
            setPriority(group.getMaxPriority());
        }
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (getPriority() > group.getMaxPriority()) {
            setPriority(group.getMaxPriority());
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (getPriority() > group.getMaxPriority()) {
            setPriority(group.getMaxPriority());
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (getPriority() > group.getMaxPriority()) {
            setPriority(group.getMaxPriority());
        }
    }
}
