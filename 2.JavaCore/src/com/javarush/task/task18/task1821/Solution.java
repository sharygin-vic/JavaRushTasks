package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

//import javax.xml.stream.events.Characters;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream r = new FileInputStream(args[0]);
        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        byte[] buf = new byte[1000];
        int bufCount = 0;
        do {
            bufCount = r.read(buf);
            for (int i = 0; i < bufCount; i++) {
                if (buf[i] >= 0 && buf[i] <= 255)
                {
                    if (map.containsKey((char)buf[i])) {
                        map.put((char)buf[i], map.get((char)buf[i]) +1);
                    }
                    else {
                        map.put((char)buf[i], 1);
                    }
                }
            }
        }  while (bufCount == buf.length);
        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        r.close();


//==========================

//        FileInputStream r = new FileInputStream(args[0]);
//        int[] chars = new int[256];
//        byte[] buf = new byte[1000];
//        int bufCount = 0;
//        do {
//            bufCount = r.read(buf);
//            for (int i = 0; i < bufCount; i++) {
//                if (buf[i] >= 20 && buf[i] <= 255)
//                {
//                    chars[(byte)buf[i]]++;
//                }
//            }
//        }
//        while (bufCount == buf.length);
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] > 0) {
//                System.out.println((char)i + " " + chars[i]);
//            }
//        }
//        r.close();

        //======================================================

//        BufferedReader r = new BufferedReader(new FileReader(args[0]));
//        int[] chars = new int[256];
//        char[] buf  = new char[1000];
//        int bufCount = 0;
//        do {
//            bufCount = r.read(buf);
//            for (int i = 0; i < bufCount; i++) {
//                if (buf[i] >= 20 && buf[i] <= 255)
//                {
//                    chars[(byte)buf[i]]++;
//                }
//            }
//        }
//        while (bufCount == buf.length);

//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] > 0) {
//                System.out.println((char)i + " " + chars[i]);
//            }
//        }
//        r.close();

    }
}
