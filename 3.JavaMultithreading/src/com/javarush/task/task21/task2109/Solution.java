package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new A(i, j);
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Object clone = new C(getI(), getJ(), new String(getName()));
            return clone;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        C c = new C(1, 2, "CCC");
        C cloneC = (C)c.clone();

        System.out.println("cloneC : i = " + cloneC.getI() + ", j = " + cloneC.getJ() + ", name = " + cloneC.getName());
    }
}
