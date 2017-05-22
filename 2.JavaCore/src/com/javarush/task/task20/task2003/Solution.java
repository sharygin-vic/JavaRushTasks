package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException {
        //implement this method - реализуйте этот метод
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(r.readLine());
        r.close();

        try {
            load(inputStream);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
//        PrintStream prn = new PrintStream(outputStream);
//        for (Map.Entry<String, String> item : properties.entrySet()) {
//            prn.println(item.getKey() + "=" + item.getValue());
//        }
//        prn.flush();

        Properties prop = new Properties();
        for (Map.Entry<String, String> item : properties.entrySet()) {
            prop.put(item.getKey(), item.getValue());
        }
        prop.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
//        BufferedReader fr = new BufferedReader(new InputStreamReader(inputStream));
//        String line;
//        while (fr.ready()) {
//            line = fr.readLine().trim();
//            if (!line.startsWith("#") && !line.startsWith("!")) {
//                String[] words = line.split("=");
//                properties.put(words[0].trim(), words[1].trim());
//            }
//        }

        Properties prop = new Properties();
        prop.load(inputStream);
        for (Map.Entry<Object, Object> item : prop.entrySet()) {
            properties.put(item.getKey().toString(), item.getValue().toString());
        }
    }

    public static void main(String[] args) {

    }
}
