package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = r.readLine();
            secondFileName = r.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        //private String fullFileName;
        //private String res;

        private BufferedReader r = null;
        private StringBuilder sb = new StringBuilder();

        @Override
        public void setFileName(String fullFileName) {
            //this.fullFileName = fullFileName;

            try {
                r = new BufferedReader(new FileReader(fullFileName));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String getFileContent() {
            return sb.toString();
        }

        @Override
        public void run() {
            //BufferedReader r = null;

            try {
                //r = new BufferedReader(new FileReader(fullFileName));
                String s;
                while ((s = r.readLine()) != null) {
                    s = s.trim();
                    if (s.length()> 0) {
                        sb.append(s);
                        sb.append(" ");
                    }

//                    if (res == null) {
//                        res = s + " ";
//                    }
//                    else {
//                        res = res + " " + s;
//                    }
                    //s = r.readLine();
                }
                //res = sb.toString();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    r.close();
                }
                catch (IOException e) {}
            }
        }
    }
}


//c:\r\in1.txt