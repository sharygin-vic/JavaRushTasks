package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        int tabIndex1 = -1;
        int tabIndex5 = -1;
        int lastTabPos = -2;
        int curTabPos = -1;
        int tabsCount = 0;
        while (true) {
            curTabPos++;
            curTabPos = string.indexOf('\t', curTabPos);
            if (curTabPos == -1 && tabsCount < 2) {
                throw new TooShortStringException();
            }
            if (curTabPos - lastTabPos == 1) {
                lastTabPos = curTabPos;
            }
            else {
                tabsCount++;
                if (tabsCount == 1) {
                    tabIndex1 = curTabPos;
                }
                else if (tabsCount == 2) {
                    tabIndex5 = curTabPos;
                    break;
                }
            }
            lastTabPos = curTabPos;
        }

        String res;
        if (tabIndex5 >= 0) res = string.substring(tabIndex1+1, tabIndex5);
        else res = string.substring(tabIndex1+1);
        return res;
    }

    public static class TooShortStringException extends Exception {

    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
