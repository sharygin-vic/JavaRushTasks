package com.javarush.task.task29.task2909.car;

/**
 * Created by dell on 29-Apr-17.
 */
public class Truck extends Car {

    public Truck(int numberOfPassengers) {
        super(Car.TRUCK, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
