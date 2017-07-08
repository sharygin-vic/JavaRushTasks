package com.javarush.task.task38.task3810;

public @interface Revision {
    //напиши свой код
    int revision();                     //vic
    Date date();                        //vic
    String comment() default "";        //vic
    Author[] authors() default {};      //vic
}
