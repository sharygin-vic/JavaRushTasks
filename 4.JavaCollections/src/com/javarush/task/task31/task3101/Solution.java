package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        String newResultFileName = resultFileAbsolutePath.getParent() + "/allFilesContent.txt";
        File newResultFile = new File(newResultFileName);
        FileUtils.deleteFile(newResultFile);
        FileUtils.renameFile(resultFileAbsolutePath, newResultFile);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(newResultFile)) ;
            Map<String, File> map = new TreeMap<String, File>(String.CASE_INSENSITIVE_ORDER);
            processFiles(path, map);

            writeFiles(map, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void processFiles(File file, Map<String, File> map) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                processFiles(f, map);
            }
        }
        else if (file.isFile()) {
            if (file.length() > 50) {
                FileUtils.deleteFile(file);
            }
            else {
                map.put(file.getName(), file);
            }
        }
    }

    private static void writeFiles(Map<String, File> map, Writer writer)  {
        String delimiter = "\n";
        for (Map.Entry<String, File> item : map.entrySet()) {
            char[] buffer = new char[1024];
            int count;
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(item.getValue()));
                while ( (count = reader.read(buffer)) > 0) {
                    writer.write(buffer, 0, count);
                }
                writer.write(delimiter);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
