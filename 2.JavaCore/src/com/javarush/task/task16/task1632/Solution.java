package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new UnlimiedThread());
        threads.add(new InterruptedThread());
        threads.add(new UraThread());
        threads.add(new MessageThread());
        threads.add(new CalcThread());
    }


    public static void main(String[] args) {
        //threads.get(4).start();
    }

    public static class UnlimiedThread extends Thread {
        @Override
        public void run() {
            while(true) {}
        }
    }

    public static class InterruptedThread extends Thread {
        @Override
        public void run() {
            try {
                while(true) {
                    sleep(1);
                }
            }
            catch (InterruptedException e ) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class UraThread extends Thread {
        @Override
        public void run() {
            while(true) {
                System.out.println("Ура");
                try {
                    sleep(500);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MessageThread extends Thread implements Message {
        @Override
        public void run() {
            while(!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static class CalcThread extends Thread {
        @Override
        public void run() {
            int sum = 0;
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            try {
                String s = r.readLine();
                while (!s.equals("N")) {
                    sum += Integer.parseInt(s);
                    s = r.readLine();
                }

                System.out.println(sum);
            }
            catch (IOException e) {

            }
//            catch (NumberFormatException e) {
//                //e.printStackTrace();
//            }
//            finally {
//                try {
//                    r.close();
//                }
//                catch (IOException ee) {}
//                System.out.println(sum);
//            }

        }
    }
}