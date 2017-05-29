package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipName = args[1];

//        String fileName = "c:/r/ccc.txt";
//        String zipName = "c:/r/t/test.zip";

        Map<String, byte[]> bufferData = new HashMap<String, byte[]>();
        Map<String, ZipEntry> bufferZipEntry = new HashMap<String, ZipEntry>();

        try (
                ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipName));
        ){
            ZipEntry entry;
            while ((entry = zipIn.getNextEntry()) != null) {
                String name = entry.getName().toLowerCase();
                bufferZipEntry.put(name, entry);
                byte[] data = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int count;
                while ((count = zipIn.read(data)) != -1) {
                    byteArrayOutputStream.write(data, 0, count);
                }
                bufferData.put(name, byteArrayOutputStream.toByteArray());
                zipIn.closeEntry();
            }
        }

        try (
                ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipName));
        ){
            ZipEntry entryForAdd;

            String newName = "new/" + fileName.substring(fileName.lastIndexOf("/") + 1);
            String newNameForTestInMap = newName.toLowerCase();
            if (bufferZipEntry.containsKey(newNameForTestInMap)) {
                bufferZipEntry.remove(newNameForTestInMap);
                bufferData.remove(newNameForTestInMap);
            }
            entryForAdd = new ZipEntry(newName);
            zipOut.putNextEntry(entryForAdd);
            Files.copy(Paths.get(fileName), zipOut);
            zipOut.closeEntry();

            for (Map.Entry<String, ZipEntry> item : bufferZipEntry.entrySet()) {
                ZipEntry oldZipEntry = item.getValue();
                entryForAdd = new ZipEntry(oldZipEntry.getName());
                zipOut.putNextEntry(entryForAdd);
                zipOut.write(bufferData.get(oldZipEntry.getName()));
                zipOut.closeEntry();
            }
        }
    }
}
