package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 16-Jun-17.
 */
public class OurHashBiMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> k2v = new HashMap<Long, String>();  // data
    private HashMap<String, Long> v2k = new HashMap<String, Long>();

    @Override
    public boolean containsKey(Long key) {
        return k2v.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return v2k.containsKey(value);
    }

    @Override
    public void put(Long key, String value) {
        k2v.put(key, value);
        v2k.put(value, key);
    }

    @Override
    public Long getKey(String value) {
        return v2k.get(value);
    }

    @Override
    public String getValue(Long key) {
        return k2v.get(key);
    }
}
