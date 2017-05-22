package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args)   {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string)   {
        if (string == null) {
            throw new TooShortStringException();
        }
//        int spaceIndex1 = string.indexOf(' ');
//        if (spaceIndex1 == -1) {
//            throw new TooShortStringException();
//        }
//        int spaceIndex5 = -1;
//        for (int i = 1; i <= 5; i++) {
//            spaceIndex5 = string.indexOf(' ', spaceIndex5+1);
//            if (spaceIndex5 == -1 && i < 4) {
//                throw new TooShortStringException();
//            }
//        }

        int spaceIndex1 = -1;
        int spaceIndex5 = -1;
        int lastSpacePos = -2;
        int curSpacePos = -1;
        int spacesCount = 0;
        while (true) {
            curSpacePos++;
            curSpacePos = string.indexOf(' ', curSpacePos);
            if (curSpacePos == -1 && spacesCount < 4) {
                throw new TooShortStringException();
            }
            if (curSpacePos - lastSpacePos == 1) {
                    lastSpacePos = curSpacePos;
            }
            else {
                spacesCount++;
                if (spacesCount == 1) {
                    spaceIndex1 = curSpacePos;
                }
                else if (spacesCount == 5) {
                    spaceIndex5 = curSpacePos;
                    break;
                }
            }
            lastSpacePos = curSpacePos;
        }

        String res;
        if (spaceIndex5 >= 0) res = string.substring(spaceIndex1+1, spaceIndex5).trim();
        else res = string.substring(spaceIndex1+1).trim();
        return res;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
