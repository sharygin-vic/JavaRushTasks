package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("c:/r/result.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter res = new StringWriter();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (br.ready()) {
                res.write(br.readLine());
            }
        }
        catch (Exception ignor) { /* NOP */}
        finally {
            return res;
        }
    }
}