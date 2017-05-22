package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String fNameUtf8 = args[0];
        String fNameWin1251 = args[1];

//        try (
//            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(fNameUtf8), "UTF-8"));
//            OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream(fNameWin1251), "Windows-1251");
//        )
//        {
//            while (r.ready()) {
//                String s = r.readLine();
//                w.write(s);
//            }
//        }

        try (
                InputStreamReader r = new InputStreamReader(new FileInputStream(fNameUtf8), "UTF-8");
                OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream(fNameWin1251), "Windows-1251");
                )
        {
            char[] buf = new char[1000];
            while (r.ready()) {
                int bufCount = r.read(buf);
                w.write(buf, 0, bufCount);
            }
        }
    }
}
//c:\\r\\1.txt