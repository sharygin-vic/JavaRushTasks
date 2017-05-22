package com.javarush.task.task29.task2909.human;

/**
 * Created by dell on 29-Apr-17.
 */
public class Soldier extends Human implements Alive{

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
            fight();
    }

    public void fight() {
    }

}
