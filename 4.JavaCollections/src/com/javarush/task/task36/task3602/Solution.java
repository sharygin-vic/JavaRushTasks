package com.javarush.task.task36.task3602;


import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class clazz : classes) {
//            System.out.println("Class = " + clazz.getName());
            int modifiers = clazz.getModifiers();
            if (List.class.isAssignableFrom(clazz)
                && clazz.isMemberClass()
                && Modifier.isStatic(modifiers)
                && Modifier.isPrivate(modifiers)

            ) {
                ////System.out.println("Class = " + clazz.getName());
                //все три кидают IndexOutOfBoundsException - unchecked exception:
                //Class = java.util.Collections$CopiesList
                //Class = java.util.Collections$EmptyList
                //Class = java.util.Collections$SingletonList

                // не работает - не предоставляют информацию об unchecked exceptions
//                Method[] methods = clazz.getDeclaredMethods();
//                for (Method m : methods) {
//                    //System.out.println(m.toString());
//                    Class<?>[] xType = m.getExceptionTypes();
//                    Type[] gxType = m.getGenericExceptionTypes();
//                    for (int i = 0; i < xType.length; i++) {
//                        System.out.println("ExceptionType = " + xType[i]);
//                    }
//                    for (int i = 0; i < gxType.length; i++) {
//                        System.out.println("GenericExceptionType = " + gxType[i]);
//                    }
//                }

                String nameOfClass = clazz.getName();
                try {
                    Object object = clazz.newInstance();
                    List list = (List) object;
                } catch (InstantiationException e) {
                    //e.printStackTrace();
                } catch (IllegalAccessException e) {
                    //e.printStackTrace();
                    return clazz;   // костыль
                }

            }
        }



        return null;
    }
}
