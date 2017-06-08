package com.javarush.task.task25.task2515;

/**
 * Created by dell on 07-Jun-17.
 */
public class SpaceShip extends BaseObject {
    private double dx;

    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }

    public void moveLeft() {
        dx = -1.0;
    }

    public void moveRight() {
        dx = 1.0;
    }
}
