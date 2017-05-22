package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 16-May-17.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String res = null;
        res = bufferedReader.readLine().trim();
        return res;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> res = new ArrayList<Dish>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Выберите блюдо (print 'exit' for stop):");
        String inStr;
        while (!"exit".equals(inStr = readString())) {
            Dish dish = null;
            try {
                dish = Dish.valueOf(inStr);
                res.add(dish);
            }
            catch (IllegalArgumentException e) {
                writeMessage("Такого блюда нет в меню.");
            }
        }
        return res;
    }
}
