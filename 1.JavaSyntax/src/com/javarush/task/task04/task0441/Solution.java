package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(r.readLine());
        int i2 = Integer.parseInt(r.readLine());
        int i3 = Integer.parseInt(r.readLine());

        if (i1 <= i2 && i1 >= i3  || i1 >= i2 && i1 <= i3) {
            //System.out.print("  1    ");
            System.out.println(i1);
        } else if (i2 <= i1 && i2 >= i3  || i2 >= i1 && i2 <= i3) {
            //System.out.print("  2    ");
            System.out.println(i2);
        } else {
            //System.out.print("  3    ");
            System.out.println(i3);
        }
    }
}
