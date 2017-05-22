package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human dedone = new Human("Dedone", true, 70);
        Human dedtwo = new Human("Dedtwo", true, 72);
        Human babaone = new Human("Babaone", false, 63);
        Human babatwo = new Human("Babatwo", false, 67);
        Human father = new Human("Father", true, 45, dedone, babaone);
        Human mother = new Human("Mother", false, 40, dedtwo, babatwo);
        Human sunone = new Human("Sunone", true, 18, father, mother);
        Human suntwo = new Human("Suntwo", true, 14, father, mother);
        Human dotone = new Human("Dotone", false, 10, father, mother);

        System.out.println(dedone.toString());
        System.out.println(dedtwo.toString());
        System.out.println(babaone.toString());
        System.out.println(babatwo.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(sunone.toString());
        System.out.println(suntwo.toString());
        System.out.println(dotone.toString());
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = null;
            this.mother = null;
        }

        //public Human() {};

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















