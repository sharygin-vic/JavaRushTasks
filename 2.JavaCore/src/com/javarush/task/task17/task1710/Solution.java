package com.javarush.task.task17.task1710;

import jdk.nashorn.internal.parser.DateParser;
import jdk.nashorn.internal.runtime.ParserException;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args.length > 1) {
            if (args[0].equals("-c") && args.length == 4) {
                //name sex bd
                try {
                    //String name = args[1];
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date bd = sdf.parse(args[3]);
                    //Sex sex;
                    if (args[2].equals("м")) {
                        //sex = Sex.MALE;
                        allPeople.add(Person.createMale(args[1], bd));
                    } else if (args[2].equals("ж")) {
                        //sex = Sex.FEMALE;
                        allPeople.add(Person.createFemale(args[1], bd));
                    }
                    System.out.println(allPeople.size()-1);
                }
                catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }

            }
            else if (args[0].equals("-u") && args.length == 5) {
                //id name sex bd
                try {
                    int id = Integer.parseInt(args[1]);
                    Person person = allPeople.get(id);
                    person.setName(args[2]);
                    if (args[3].equals("м")) {
                        person.setSex(Sex.MALE);
                    } else if (args[3].equals("ж")) {
                        person.setSex(Sex.FEMALE);
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    person.setBirthDay(sdf.parse(args[4]));

                }
                catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }
            }
            else if (args[0].equals("-d") && args.length == 2) {
                int id = Integer.parseInt(args[1]);
                Person person = allPeople.get(id);
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
            }
            else if (args[0].equals("-i") && args.length == 2) {
                int id = Integer.parseInt(args[1]);
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
            else {
                System.out.println("Error in parameters");
            }
        }
        //debug
//        else {
//            int id = 1;
//            Person person = allPeople.get(id);
//            String sex = null;
//            if (person.getSex() == Sex.FEMALE) {
//                sex = "ж";
//            } else {
//                sex = "м";
//            }
//            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//            System.out.println(person.getName() + " " + sex + " " + sdf.format(person.getBirthDay()));
//        }
    }
}
