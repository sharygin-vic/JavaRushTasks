package com.javarush.task.task29.task2909.car;

/**
 * Created by dell on 29-Apr-17.
 */
public class Cabriolet extends Car {

    public Cabriolet(int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
