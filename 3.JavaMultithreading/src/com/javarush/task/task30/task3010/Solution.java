package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String digits = "0123456789abcdefghijklmnopqrstuvwxyz";
        try {
            String src = args[0].toLowerCase();

//          String src = "12AS08z".toLowerCase();
//          String src = "00".toLowerCase();
//          String src = "12AS08Z/".toLowerCase();


            int radix = -1;
            for (int i = 0; i < src.length(); i++) {
                int curRadix = digits.indexOf(src.charAt(i)) + 1;
                if (curRadix > 0) {
                    if (curRadix > radix) {
                        radix = curRadix;
                    }
                } else {
                    radix = -1;
                    break;
                }
            }
            if (radix == 1) radix++;

            if (radix > 0) {
                System.out.println(radix);
            } else {
                System.out.println("incorrect");
            }
        }
        catch (Exception e) {
            System.out.println("incorrect");
        }
    }

}