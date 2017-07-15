package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by dell on 14-Jul-17.
 */
class WithdrawCommand implements Command {
    private ResourceBundle res;
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(CashMachine.RESOURCE_PATH + "withdraw_en.properties"))) {
            res = new PropertyResourceBundle(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currensyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currensyCode);
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));  //"Введите сумму:"
            try {
                int userSum = Integer.parseInt(ConsoleHelper.readString());
                if (userSum <= 0) {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));  //"Неправильная сумма (0 или отрицательное число)."
                    continue;
                }
                if (!currencyManipulator.isAmountAvailable(userSum)) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));  //"Недостаточно средств в банкомате."
                    continue;
                }

                Map<Integer, Integer> banknotesMap = currencyManipulator.withdrawAmount(userSum);
                Integer[] banknotes = banknotesMap.keySet().toArray(new Integer[0]);
                Arrays.sort(banknotes);
                StringBuilder sb = new StringBuilder();
                for (int i = banknotes.length - 1; i >= 0; i--) {
                    Integer nominal = banknotes[i];
                    int value = banknotesMap.get(nominal);
                    sb.delete(0, sb.length());
                    sb.append("\t").append(nominal).append(" - ").append(value);
                    ConsoleHelper.writeMessage(sb.toString());
                }
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), userSum, currensyCode));  //"Транзакция успешно завершена."
                return;
            }
            catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));  //"Ошибка ввода суммы."
                continue;
            }
            catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));  //"Недостаточно купюр для завершения транзакции."
                continue;
            }
        }
    }
}
