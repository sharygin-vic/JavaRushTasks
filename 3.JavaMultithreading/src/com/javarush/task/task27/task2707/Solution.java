package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {       //  obj2
            synchronized (obj2) {   //  obj1
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        boolean res = false;
        synchronized (o1) {
            System.out.println("xxxx");

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
                        solution.someMethodWithSynchronizedBlocks(o1, o2);
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                    }

                }
            });
            t1.start();

            Thread.sleep(10);
            System.out.println("t1 - " + t1.getState());


            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (o2) {
                            Thread.sleep(20);
                        }
                    } catch (InterruptedException e) {
                    }

                }
            });
            t2.start();

            Thread.sleep(10);
            System.out.println("------------------");
            System.out.println("t1 - " + t1.getState());
            System.out.println("t2 - " + t2.getState());
            res = t2.getState() != Thread.State.BLOCKED;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
        //System.out.println(isNormalLockOrder(solution, o2, o1));
    }
}
