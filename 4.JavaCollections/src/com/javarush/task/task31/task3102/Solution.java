package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> files = new PriorityQueue<File>(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o2.isDirectory()) return 1;
                else if (o2.isFile()) return -1;
                else return 0;
            }
        });
        files.add(new File(root));
        File lastFolder;
        while (files.peek().isDirectory()) {
            lastFolder = files.poll();
            for (File subFile : lastFolder.listFiles()) {
                files.offer(subFile);
            }
        }

        List<String> res = new ArrayList<String>();
        for (File f : files) {
            res.add(f.getAbsolutePath());
        }
        return res;

    }

    public static void main(String[] args) {
        try {
            List<String> fileNames = getFileTree("c:/r/t");

            for (String s : fileNames) {
                System.out.println(s);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
