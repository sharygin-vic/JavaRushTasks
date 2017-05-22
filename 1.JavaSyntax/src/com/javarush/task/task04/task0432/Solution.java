package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String str = r.readLine();
        int count = Integer.parseInt(r.readLine());

        int i = 0;
        while (i < count) {
            System.out.println(str);
            i++;
        }
    }
}
