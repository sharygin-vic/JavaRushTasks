package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

/**
 * Created by dell on 14-Jul-17.
 */
interface Command {
    void execute() throws InterruptOperationException;
}
