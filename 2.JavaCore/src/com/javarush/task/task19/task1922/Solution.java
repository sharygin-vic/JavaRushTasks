package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fName = r.readLine();
        //String fName = "c:\\r\\1922.txt";
        r.close();

        BufferedReader fr = new BufferedReader(new FileReader(fName));

        while (fr.ready()) {
            String s = fr.readLine();
            String[] lineWords = s.split(" ");
            int count = 0;
            //int index1 = -1;
            for (int lineWordI = 0; lineWordI < lineWords.length; lineWordI++) {
                for (int searchWordI = 0; searchWordI < words.size(); searchWordI++) {
                    String s1 = lineWords[lineWordI];
                    String s2 = words.get(searchWordI);
                    if (s1.equals(s2)) {
                        count++;
                    }
                }
            }
            if (count == 2) {
                System.out.println(s);
            }
        }

        fr.close();

    }
}
//c:\r\1922.txt