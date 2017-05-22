package com.javarush.task.task19.task1904;

import jdk.nashorn.internal.runtime.ParserException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String lastName = fileScanner.next();
            String firstName = fileScanner.next();
            String middleName = fileScanner.next();
            String d = fileScanner.next();
            String m = fileScanner.next();
            String y = fileScanner.next();
            SimpleDateFormat fmt = new SimpleDateFormat("ddMMyyyy");
            Date birthDate;
            try {
                birthDate = fmt.parse(d + m + y);
            }
            catch (ParseException e) {
                throw new IOException();
            }

            Person res = new Person(firstName, middleName, lastName, birthDate);
            return res;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
