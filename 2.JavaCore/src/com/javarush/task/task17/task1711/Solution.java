package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args.length > 1) {
            switch (args[0]) {
                case "-c": synchronized (allPeople){
                    try {
                        for (int i = 1; i < args.length; i+=3) {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                            Date bd = sdf.parse(args[i+2]);
                            if (args[i+1].equals("м")) {
                                allPeople.add(Person.createMale(args[i], bd));
                            } else if (args[i+1].equals("ж")) {
                                allPeople.add(Person.createFemale(args[i], bd));
                            }
                            System.out.println(allPeople.size() - 1);
                        }
                    }
                    catch (ParseException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                break;
                case "-u": synchronized (allPeople){
                    try {
                        for (int i = 1; i < args.length; i+=4) {
                            int id = Integer.parseInt(args[i]);
                            Person person = allPeople.get(id);
                            person.setName(args[i+1]);
                            if (args[i+2].equals("м")) {
                                person.setSex(Sex.MALE);
                            } else if (args[i+2].equals("ж")) {
                                person.setSex(Sex.FEMALE);
                            }
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                            person.setBirthDay(sdf.parse(args[i+3]));
                        }

                    }
                    catch (ParseException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                break;
                case "-d": synchronized (allPeople){
                    for (int i = 1; i < args.length; i++) {
                        try {
                            int id = Integer.parseInt(args[i]);
                            Person person = allPeople.get(id);
                            person.setName(null);
                            person.setSex(null);
                            person.setBirthDay(null);
                        }
                        catch (IndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
                case "-i": synchronized (allPeople){
                    for (int i = 1; i <= args.length-1; i++) {
                        int id = Integer.parseInt(args[i]);
                        Person person = allPeople.get(id);
                        String sex = null;
                        if (person.getSex() == Sex.FEMALE) {
                            sex = "ж";
                        } else {
                            sex = "м";
                        }
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        System.out.println(person.getName() + " " + sex + " " + sdf.format(person.getBirthDay()));
                    }
                }
            }
        }

        //debug
//        for (Person person : allPeople) {
//            String sex = null;
//            if (person.getSex() == Sex.FEMALE) {
//                sex = "ж";
//            } else if (person.getSex() == Sex.MALE) {
//                sex = "м";
//            }
//            String bd = null;
//            if (person.getBirthDay() != null) {
//                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//                bd = sdf.format(person.getBirthDay());
//            }
//            System.out.println(person.getName() + " " + sex + " " + bd);
//        }

    }
}


//-c name_ж1 ж 18/03/1990 name_м2 м 01/02/1998
//-u 0 name_ж1 ж 18/03/1990 1 name_м2 м 01/02/1998
//-d 0 1