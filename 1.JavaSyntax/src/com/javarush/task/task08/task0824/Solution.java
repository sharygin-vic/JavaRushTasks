package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human ded1 = new Human("Dedok", true, 72);
        Human ded2 = new Human("Dedulja", true, 75);
        Human baba1 = new Human("Babka", false, 70);
        Human baba2 = new Human("Babulja", false, 63);
        Human father = new Human("Father", true, 45);
        Human mother = new Human("Mother", false, 33);
        Human son1 = new Human("Son", true, 12);
        Human son2 = new Human("Sonchik", true, 8);
        Human doter = new Human("Dota", false, 5);
        ded1.children.add(father);
        baba1.children.add(father);
        ded2.children.add(mother);
        baba2.children.add(mother);
        father.children.add(son1);
        father.children.add(son2);
        father.children.add(doter);
        mother.children.add(son1);
        mother.children.add(son2);
        mother.children.add(doter);

        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(baba1.toString());
        System.out.println(baba2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(doter.toString());
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
