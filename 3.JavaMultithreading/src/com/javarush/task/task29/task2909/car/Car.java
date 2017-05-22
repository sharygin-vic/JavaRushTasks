package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        //if (date.before(SummerStart) || date.after(SummerEnd)) {
        if (isSummer(date, SummerStart, SummerEnd)) {
            consumption = getSummerConsumption(length);
        } else {
            consumption = getWinterConsumption(length);
        }
        return consumption;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd) {
        return date.getTime() >= summerStart.getTime() && date.getTime() <= summerEnd.getTime();
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && fuel > 0;
    }


    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public static final int MAX_TRUCK_SPEED = 80;
    public static final int MAX_SEDAN_SPEED = 120;
    public static final int MAX_CABRIOLET_SPEED = 90;


    public abstract int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers) {
        Car res = null;
        switch (type) {
            case TRUCK :
                res = new Truck(numberOfPassengers);
                break;
            case SEDAN:
                res = new Sedan(numberOfPassengers);
                break;
            case CABRIOLET:
                res = new Cabriolet(numberOfPassengers);
                break;
        }
        return res;
    }



}