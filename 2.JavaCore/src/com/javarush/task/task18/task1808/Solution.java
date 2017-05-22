package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String src = r.readLine();
        String dest1 = r.readLine();
        String dest2 = r.readLine();
        FileInputStream fSrc = new FileInputStream(src);
        int data1Size = fSrc.available() / 2;
        byte[] data2 = new byte[data1Size];
        byte[] data1 = new byte[fSrc.available() - data1Size];
        fSrc.read(data1);
        fSrc.read(data2);

        FileOutputStream fDest1 = new FileOutputStream(dest1);
        fDest1.write(data1);
        fDest1.close();

        FileOutputStream fDest2 = new FileOutputStream(dest2);
        fDest2.write(data2);
        fDest2.close();

        r.close();;
        fSrc.close();
    }
}
//c:\r\1.txt