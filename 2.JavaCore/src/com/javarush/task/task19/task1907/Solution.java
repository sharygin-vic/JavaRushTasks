package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static String delimiters = " .,:!?;()\\'\"/{}<>\n";
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(r.readLine());
        long countWords = 0;
        boolean wordStarted = false;
        StringBuilder sb = new StringBuilder();
        while (fr.ready()) {
            char ch = (char) fr.read();
            if (delimiters.indexOf(ch, 0) >= 0) {  // it is a delimiter char
                if (wordStarted) {
                    wordStarted = false;
                    if ("world".equals(sb.toString())) {
                        countWords++;
                    }
                }
            }
            else {
                if (!wordStarted) {
                    wordStarted = true;
                    //countWords++;
                    sb.delete(0, sb.length());
                }
                sb.append(ch);
            }
        }
        r.close();
        fr.close();
        System.out.println(countWords);
    }
}
//c:\r\2.txt
