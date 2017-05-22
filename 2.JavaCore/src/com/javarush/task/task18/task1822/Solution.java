package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(r.readLine()));
        String s;
        while((s = fileReader.readLine().trim()) != null) {
            if (s.startsWith(args[0])) {
                System.out.println(s);
                break;
            }
        }
        fileReader.close();
        r.close();
    }
}
