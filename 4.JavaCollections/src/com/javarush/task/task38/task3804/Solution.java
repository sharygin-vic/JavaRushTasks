package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

import java.lang.reflect.InvocationTargetException;

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) throws Throwable {
        //test   vic ->
        Class factoryClass = getFactoryClass();

        //throw (Throwable) factoryClass.getDeclaredMethods()[0].invoke(factoryClass.newInstance(), ExceptionApplicationMessage.UNHANDLED_EXCEPTION);  //Ok
        //throw (Throwable) factoryClass.getDeclaredMethods()[0].invoke(factoryClass.newInstance(), ExceptionApplicationMessage.SOCKET_IS_CLOSED);  //Ok

        //throw (Throwable) factoryClass.getDeclaredMethods()[0].invoke(factoryClass.newInstance(), ExceptionDBMessage.NOT_ENOUGH_CONNECTIONS);  //Ok
        //throw (Throwable) factoryClass.getDeclaredMethods()[0].invoke(factoryClass.newInstance(), ExceptionDBMessage.RESULT_HAS_NOT_GOTTEN_BECAUSE_OF_TIMEOUT);  //Ok

        //throw (Throwable) factoryClass.getDeclaredMethods()[0].invoke(factoryClass.newInstance(), ExceptionUserMessage.USER_DOES_NOT_EXIST);  //Ok
        throw (Throwable) factoryClass.getDeclaredMethods()[0].invoke(factoryClass.newInstance(), ExceptionUserMessage.USER_DOES_NOT_HAVE_PERMISSIONS);  //Ok

        // <- vic
    }
}