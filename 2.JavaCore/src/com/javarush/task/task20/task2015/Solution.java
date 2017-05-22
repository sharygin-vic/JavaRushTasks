package com.javarush.task.task20.task2015;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        startThread();
    }

    public void run() {
        // do something here, does not matter

    }

    private void startThread() {
        runner = new Thread(this);
        runner.start();
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        startThread();
    }

    public static void main(String[] args) {

    }
}
