package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.Human;

/**
 * Created by dell on 12-Jun-17.
 */
public class MaleFactory {
    public Human getPerson(int age) {
        if (age <= KidBoy.MAX_AGE) {
            return new KidBoy();
        }
        else if (age <= TeenBoy.MAX_AGE) {
            return new TeenBoy();
        }
        else {
            return new Man();
        }
    }


}
