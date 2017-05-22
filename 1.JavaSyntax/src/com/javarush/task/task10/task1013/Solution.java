package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private String lastName;
        private boolean sex;
        private int age;
        private int height;
        private int weight;


        public Human(String name, String lastName, boolean sex, int age, int height, int weight) {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;

        }
        public Human(boolean sex, int age, int height, int weight) {
            //this.name = name;
            //this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
            //this.address = address;
            //this.passport = passport;
            //this.profession = profession;
            //this.citizen = citizen;
        }
        public Human(boolean sex, int age) {
//            this.name = name;
//            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
//            this.height = height;
//            this.weight = weight;
//            this.address = address;
//            this.passport = passport;
//            this.profession = profession;
//            this.citizen = citizen;
        }
        public Human(boolean sex, int height, int weight) {
//            this.name = name;
//            this.lastName = lastName;
            this.sex = sex;
//            this.age = age;
            this.height = height;
            this.weight = weight;
//            this.passport = passport;
//            this.profession = profession;
//            this.citizen = citizen;
        }
        public Human(String name, String lastName, boolean sex, int age) {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
//            this.height = height;
//            this.weight = weight;
//            this.profession = profession;
        }
        public Human(String lastName, boolean sex, int age, int height, int weight) {
//            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
//            this.profession = profession;
        }
        public Human(String name) {
            this.name = name;
//            this.lastName = lastName;
//            this.sex = sex;
//            this.age = age;
//            this.height = height;
//            this.weight = weight;
        }
        public Human(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
//            this.sex = sex;
//            this.age = age;
//            this.height = height;
//            this.weight = weight;
//            this.address = address;
//            this.passport = passport;
//            this.citizen = citizen;
        }
        public Human(String name, String lastName, boolean sex) {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
//            this.age = age;
//            this.height = height;
//            this.weight = weight;
//            this.profession = profession;
        }
        public Human() {
//            this.name = name;
//            this.lastName = lastName;
//            this.sex = sex;
//            this.age = age;
//            this.height = height;
//            this.weight = weight;
//            this.address = address;
//            this.passport = passport;
//            this.profession = profession;
        }

    }
}
