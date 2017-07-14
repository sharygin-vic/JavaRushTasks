package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 14-Jul-17.
 */
public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<String, CurrencyManipulator>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        String key = currencyCode.toUpperCase();
        CurrencyManipulator res = map.get(key);
        if (res == null) {
            res = new CurrencyManipulator(currencyCode);
            map.put(key, res);
        }
        return res;
    }

    private CurrencyManipulatorFactory() {}

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
