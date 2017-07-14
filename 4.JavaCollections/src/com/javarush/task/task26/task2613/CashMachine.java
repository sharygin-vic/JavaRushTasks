package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;

import java.util.Locale;

/**
 * Created by dell on 14-Jul-17.
 */
public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

//        String currensyCode = ConsoleHelper.askCurrencyCode();
//        String[] banknotes = ConsoleHelper.getValidTwoDigits(currensyCode);
//        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currensyCode);
//        currencyManipulator.addAmount(Integer.parseInt(banknotes[0]), Integer.parseInt(banknotes[1]));
//
//        int totalAmount = currencyManipulator.getTotalAmount();
//        System.out.println(totalAmount);

        Operation operation = Operation.EXIT;
        do {
            operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);

        } while (operation != Operation.EXIT);
    }
}
