package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

/**
 * Created by dell on 14-Jul-17.
 */
class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Вы действительно хотите выйти? (y/n):");
        String userInput = ConsoleHelper.readString();
        if ("y".equals(userInput) || "Y".equals(userInput)) {
            ConsoleHelper.writeMessage("До встречи!");
        }
    }
}
