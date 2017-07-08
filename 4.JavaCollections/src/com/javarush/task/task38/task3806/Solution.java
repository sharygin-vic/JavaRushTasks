package com.javarush.task.task38.task3806;

/* 
Улучшения в Java 7 (try-with-resources)
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public void printFile1() throws IOException {
        //FileInputStream fileInputStream = null;                                   //vic

        try (FileInputStream fileInputStream = new FileInputStream("file.txt"))     //vic
        {
            //fileInputStream = new FileInputStream("file.txt");                    //vic

            int data = fileInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = fileInputStream.read();
            }
        }
        //finally {                             //vic
        //    if (fileInputStream != null) {    //vic
        //        fileInputStream.close();      //vic
        //    }                                 //vic
        //}                                     //vic
    }

    public void printFile2() throws IOException {
        //FileInputStream fileInputStream = null;                               //vic
        //BufferedInputStream bufferedInputStream = null;                       //vic
        try (
            FileInputStream fileInputStream =new FileInputStream("file.txt");                   //vic
            BufferedInputStream bufferedInputStream =new BufferedInputStream(fileInputStream);  //vic
        )
        {
            //fileInputStream = new FileInputStream("file.txt");                //vic
            //bufferedInputStream = new BufferedInputStream(fileInputStream);   //vic

            int data = bufferedInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = bufferedInputStream.read();
            }
        }
        //finally {
        //    if (fileInputStream != null) {
        //        fileInputStream.close();
        //    }

        //    if (bufferedInputStream != null) {
        //        bufferedInputStream.close();
        //    }
        //}
    }

    public static void main(String[] args) {

    }
}