package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
            reset();
    }

    public static Flyable result;

    public static void reset()  {
        //add your code here - добавьте код тут
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = r.readLine();
            if ("helicopter".equals(s)) {
                result = new Helicopter();
            } else if ("plane".equals(s)) {
                int num = Integer.parseInt(r.readLine());
                result = new Plane(num);
            }
        }
        catch (IOException e){

        }
        finally {
            try {
                r.close();
            }
            catch (IOException ee) {}
        }
    }
}
