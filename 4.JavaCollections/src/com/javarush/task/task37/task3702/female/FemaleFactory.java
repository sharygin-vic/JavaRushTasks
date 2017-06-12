package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.Human;

/**
 * Created by dell on 12-Jun-17.
 */
public class FemaleFactory {
    public Human getPerson(int age) {
        if (age <= KidGirl.MAX_AGE) {
            return new KidGirl();
        }
        else if (age <= TeenGirl.MAX_AGE) {
            return new TeenGirl();
        }
        else {
            return new Woman();
        }
    }
}
