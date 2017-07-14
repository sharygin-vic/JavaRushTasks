package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 14-Jul-17.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();  // Map<номинал, количество>

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        Integer val = denominations.get(denomination);
        if (val == null) {
            val = count;
        }
        else {
            val += count;
        }
        denominations.put(denomination, val);
    }

    public int getTotalAmount() {
        int count = 0;
        for (Map.Entry<Integer, Integer> item : denominations.entrySet()) {
            count += item.getKey() * item.getValue();
        }
        return count;
    }
}
