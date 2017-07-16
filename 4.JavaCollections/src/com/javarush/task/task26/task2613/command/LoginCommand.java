package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by dell on 15-Jul-17.
 */
public class LoginCommand implements Command {
//    private ResourceBundle validCreditCards;
//    {
//        try (BufferedReader reader = new BufferedReader(new FileReader(CashMachine.RESOURCE_PATH + "verifiedCards.properties"))) {
//            validCreditCards = new PropertyResourceBundle(reader);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");

//    private ResourceBundle res;
//    {
//        try (BufferedReader reader = new BufferedReader(new FileReader(CashMachine.RESOURCE_PATH + "login_en.properties"))) {
//            res = new PropertyResourceBundle(reader);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while(true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String number = ConsoleHelper.readString();
            String pin = ConsoleHelper.readString();
            if (number.length() != 12 || pin.length() != 4) {
                ConsoleHelper.writeMessage(String.format(res.getString("try.again.with.details"), number));
                continue;
            }
            if (!cardIsOk(number, pin)) {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), number));
                ConsoleHelper.writeMessage(String.format(res.getString("try.again.or.exit"), number));
                continue;
            }
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), number));
            return;
        }
    }

    private boolean cardIsOk(String number, String pin) {
        boolean res = false;
        if (validCreditCards.containsKey(number) && pin.equals(validCreditCards.getString(number)))
            res = true;

        return res;

    }
}
