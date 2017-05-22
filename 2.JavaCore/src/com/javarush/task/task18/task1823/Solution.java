package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        List<String> fileNames = new ArrayList();
        String s;
        while (!(s = r.readLine()).equals("exit")) {
            fileNames.add(s);
        }
        for (String name : fileNames) {
            new ReadThread(name).start();
        }
        r.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            FileInputStream fs = null;
            int[] bytes = new int[256];
            byte[] buf = new byte[1000];
            int bufCount = 0;
            int maxBytesIndex = 0, maxBytesVal = 0;
            try {
                // file reading and bytes frequency culculation and find byte with max frequency:
                fs = new FileInputStream(fileName);
                do {
                    bufCount = fs.read(buf);
                    for (int i = 0; i < bufCount; i++) {
                        bytes[buf[i]]++;
                        if (bytes[buf[i]] > maxBytesVal) {
                            maxBytesVal = bytes[buf[i]];
                            maxBytesIndex = buf[i];
                        }
                    }
                }
                while (bufCount == buf.length);

                resultMap.put(fileName, maxBytesIndex);

            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
