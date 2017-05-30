package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(reader);
            String tmp;
            while (br.ready() && (tmp = br.readLine()) != null) {
                sb.append(tmp);
            }
            for (int i = 0; i < sb.length(); i++) {
                char cur = sb.charAt(i);
//                if (Character.isLetterOrDigit(cur)) {
                    cur = (char) (cur + key);
//                }
                sb.setCharAt(i, cur);
            }
        }
        catch (Exception ignor) { /* NOP */ }
        finally {
            return sb.toString();
        }
    }

}
