package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        String partNames[] = new String[args.length-1];
        for (int i = 1; i < args.length; i++) {
            partNames[i-1] = args[i];
        }
        Arrays.sort(partNames);

        ByteArrayOutputStream byteArrayOutputStreamZipAll = new ByteArrayOutputStream();
        int count;
        byte[] buff = new byte[2048];

        // сшиваем части по порядку в один файл:
        for (String s : partNames) {
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(s))
            ){
                while (inputStream.available() > 0) {
                    count = inputStream.read(buff);
                    byteArrayOutputStreamZipAll.write(buff, 0, count);
                }
            }
        }

        // разархивируем и пишем в файл разархивированные данные::
        ByteArrayInputStream byteArrayInputStreamZipAll = new ByteArrayInputStream(byteArrayOutputStreamZipAll.toByteArray());
        try (ZipInputStream zipIn = new ZipInputStream(byteArrayInputStreamZipAll);
             FileOutputStream outputStream = new FileOutputStream(resultFileName);
        ){
            ZipEntry entry;
            while ((entry = zipIn.getNextEntry()) != null) {
                while ((count = zipIn.read(buff)) > 0) {
                    outputStream.write(buff, 0, count);
                }
                zipIn.closeEntry();
            }
        }
    }
}
