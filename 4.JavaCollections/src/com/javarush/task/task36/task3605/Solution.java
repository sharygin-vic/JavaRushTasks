package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
//        String fileName = "c:/r/in.txt";

        TreeSet<Character> treeSet = new TreeSet<Character>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName)) ) {
            char[] buff = new char[1024];
            int count;

            while (reader.ready()) {
                count = reader.read(buff);
                for (int i = 0; i < count; i++) {
                    if (Character.isLetter(buff[i])) {
                        treeSet.add(Character.toLowerCase(buff[i]));
                    }
                }
            }
            count = 5;
            Iterator<Character> iter = treeSet.iterator();
            for (int i = 0; i < count; i++) {
                if (iter.hasNext()) {
                    System.out.print(iter.next());
                }
                else {
                    break;
                }
            }
        }
    }
}
