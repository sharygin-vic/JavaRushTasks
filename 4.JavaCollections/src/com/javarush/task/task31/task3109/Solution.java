package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties res = new Properties();
        fileName = Paths.get(fileName).toAbsolutePath().toString();
        try {
            if (fileName.toLowerCase().endsWith(".xml")) {
                res.loadFromXML(new FileInputStream(fileName));
            }
            else {
                res.load(new FileInputStream(fileName));
            }
        }
        catch (Exception ignored) { /* NOP */ }

        return res;
    }
}
