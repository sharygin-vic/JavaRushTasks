package com.javarush.task.task28.task2810.model;

/**
 * Created by dell on 09-Jul-17.
 */
public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
