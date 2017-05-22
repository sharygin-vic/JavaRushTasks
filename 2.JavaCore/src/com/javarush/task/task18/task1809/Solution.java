package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String nameSrc = r.readLine();
        String nameDest = r.readLine();
        r.close();

        FileInputStream fSrc = new FileInputStream(nameSrc);
        byte[] data = new byte[fSrc.available()];
        fSrc.read(data);
        fSrc.close();

        int count = data.length / 2;
        for (int i = 0; i < count; i++) {
            byte tmp = data[i];
            data[i] = data[data.length-1-i];
            data[data.length-1-i] = tmp;
        }

        FileOutputStream fDest = new FileOutputStream(nameDest);
        fDest.write(data);
        fDest.close();
    }
}
//c:\r\1.txt