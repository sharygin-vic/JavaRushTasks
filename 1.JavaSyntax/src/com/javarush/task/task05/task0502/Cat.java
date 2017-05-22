package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        return getRaiting() > anotherCat.getRaiting();
    }

    private int getRaiting() {
        return weight + strength - age;
    }

    public static void main(String[] args) {

    }
}
