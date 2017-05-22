package com.javarush.task.task24.task2411;

public class C implements JustAnInterface {
    public C() {
        System.out.print("C");
        //JustAnInterface.B localB = JustAnInterface.B;
        B localB = B;
    }
}