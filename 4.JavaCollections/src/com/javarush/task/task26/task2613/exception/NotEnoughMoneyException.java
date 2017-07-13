package com.javarush.task.task26.task2613.exception;

/**
 * Created by dell on 14-Jul-17.
 */
public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        super();
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
