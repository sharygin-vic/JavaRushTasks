package com.javarush.task.task29.task2909.car;

/**
 * Created by dell on 29-Apr-17.
 */
public class Sedan extends Car {

    public Sedan(int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
