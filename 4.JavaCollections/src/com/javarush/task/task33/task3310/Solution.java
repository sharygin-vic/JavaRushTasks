package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

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

//        FileBucket fb = new FileBucket();
//        Entry eWrite1 = new Entry(11, 1111L, "1111value",
//                new Entry(22, 2222L, "2222value", null));
//        fb.putEntry(eWrite1);
//        Entry eRead1 = fb.getEntry();  // ok

        testStrategy(new FileStorageStrategy(), 100);

        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);        //Guava
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);        //Apache Commons Collections
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
