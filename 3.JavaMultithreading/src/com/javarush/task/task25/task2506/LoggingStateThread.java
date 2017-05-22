package com.javarush.task.task25.task2506;

/**
 * Created by dell on 27-Apr-17.
 */
public class LoggingStateThread extends Thread {
    private Thread target;
    private State lastState = State.TERMINATED;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        while (true) {
            State curTargetState = target.getState();
            if (curTargetState != lastState) {
                lastState = curTargetState;
                System.out.println(target.getState().toString());
                if (curTargetState == State.TERMINATED) {
                    //System.out.println("STOP");
                    return;
                }
            }
            yield();
        }
    }
}
