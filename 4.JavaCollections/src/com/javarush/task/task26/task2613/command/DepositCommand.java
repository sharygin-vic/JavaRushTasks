package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by dell on 14-Jul-17.
 */
class DepositCommand implements Command {
//    private ResourceBundle res;
//    {
//        try (BufferedReader reader = new BufferedReader(new FileReader(CashMachine.RESOURCE_PATH + "deposit_en.properties"))) {
//            res = new PropertyResourceBundle(reader);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        try {
            String currensyCode = ConsoleHelper.askCurrencyCode();

            String[] banknotes = ConsoleHelper.getValidTwoDigits(currensyCode);

            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currensyCode);
            int nominal = Integer.parseInt(banknotes[0]);
            int count = Integer.parseInt(banknotes[1]);
            currencyManipulator.addAmount(nominal, count);

            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), nominal * count, currensyCode));
        }
        catch (NumberFormatException ex) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
