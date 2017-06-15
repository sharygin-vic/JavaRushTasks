package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dell on 15-Jun-17.
 */
public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> res = new HashSet<Long>();
        for (String s : strings) {
            res.add(shortener.getId(s));
        }
        return res;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> res = new HashSet<String>();
        for (Long l : keys) {
            res.add(shortener.getString(l));
        }
        return res;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<String>();
        for (int i = 0; i < elementsNumber; i++) {
            //strategy.put(new Long(i), Helper.generateRandomString());
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        long startMsec = new Date().getTime();
        Set<Long> ids = getIds(shortener, strings);
        Helper.printMessage("" + (new Date().getTime() - startMsec));

        startMsec = new Date().getTime();
        Set<String> stringsFromShorter = getStrings(shortener, ids);
        Helper.printMessage("" + (new Date().getTime() - startMsec));

        if (stringsFromShorter.equals(strings)) {
            Helper.printMessage("Тест пройден.");
        }
        else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
