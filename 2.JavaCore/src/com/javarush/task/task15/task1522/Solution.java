package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем Singleton pattern
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = r.readLine();
            if (Planet.EARTH.equals(s)) {
                thePlanet = Earth.getInstance();
            }
            else if (Planet.MOON.equals(s)) {
                    thePlanet = Moon.getInstance();
            }
            else if (Planet.SUN.equals(s)) {
                thePlanet = Sun.getInstance();
            }
            else {
                thePlanet = null;
            }
        }
        catch (IOException e) {

        }
    }
}
