package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код
        BufferedReader r = null;
        //BufferedReader bufferedReader = null;
        Scanner scanner = null;
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        ArrayList<Integer> list = new ArrayList<>();
        try {
            r = new BufferedReader(new InputStreamReader(System.in));
            fileInputStream = new FileInputStream(r.readLine());
            inputStreamReader = new InputStreamReader(fileInputStream);
            //bufferedReader = new BufferedReader(inputStreamReader);
            scanner = new Scanner(inputStreamReader);
////            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(r.readLine())));

//            while (true) {
//                String s = bufferedReader.readLine();
//                if (s == null) break;
//                try {
//                    list.add(Integer.parseInt(s));
//                }
//                catch (NumberFormatException e) {
//                }
//
//            }

            while (scanner.hasNext()) {
                int val = scanner.nextInt();
                list.add(val);
            }


            ////inputStreamReader.close();
            ////fileInputStream.close();
        }
        finally {
      ////      inputStreamReader.close();
      //      fileInputStream.close();
      ////      bufferedReader.close();
            scanner.close();
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get((j + 1))) {
                    Integer tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }

        for (Integer val : list) {
            if (val % 2 == 0)
                System.out.println(val);
        }

    }
}
