package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 14-Jul-17.
 */
public class CommandExecutor {
    private static final Map<Operation, Command> allKnownCommandsMap;
    static {
        allKnownCommandsMap = new HashMap<Operation, Command>();
        allKnownCommandsMap.put(Operation.DEPOSIT, new DepositCommand());
        allKnownCommandsMap.put(Operation.INFO, new InfoCommand());
        allKnownCommandsMap.put(Operation.WITHDRAW, new WithdrawCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
        allKnownCommandsMap.put(Operation.LOGIN, new LoginCommand());
    }

    private CommandExecutor() {}

    public static void execute(Operation operation) throws InterruptOperationException {
        Command command = allKnownCommandsMap.get(operation);
        if (command != null) {
            command.execute();
        }
    }
}
