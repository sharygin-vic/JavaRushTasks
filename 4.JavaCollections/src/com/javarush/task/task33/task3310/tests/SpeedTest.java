package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dell on 16-Jun-17.
 */
public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long start = new Date().getTime();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        return new Date().getTime() - start;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long start = new Date().getTime();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        return new Date().getTime() - start;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        HashSet<String> origStrings = new HashSet<String>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        HashSet<Long> outIdsShortener1 = new HashSet<Long>();
        long shortener1Time = getTimeForGettingIds(shortener1, origStrings,  outIdsShortener1);
        HashSet<Long> outIdsShortener2 = new HashSet<Long>();
        long shortener2Time = getTimeForGettingIds(shortener2, origStrings,  outIdsShortener2);
        Assert.assertTrue(shortener1Time > shortener2Time);

        HashSet<String> outStringsShortener1 = new HashSet<String>();
        shortener1Time = getTimeForGettingStrings(shortener1, outIdsShortener1, outStringsShortener1);
        HashSet<String> outStringsShortener2 = new HashSet<String>();
        shortener2Time = getTimeForGettingStrings(shortener2, outIdsShortener2, outStringsShortener2);
        Assert.assertEquals(shortener1Time, shortener2Time, 30);
    }
}
