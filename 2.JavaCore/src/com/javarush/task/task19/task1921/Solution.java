package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader r = new BufferedReader(new FileReader(args[0]));

        while (r.ready()) {
            String s = r.readLine();
            String[] ss = s.split(" ");
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < ss.length-3; i++) {
                name.append(ss[i]).append(" ");
            }
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String dStr = (ss[ss.length-3].length() == 1) ? "0" + ss[ss.length-3] : ss[ss.length-3];
            String MStr = (ss[ss.length-2].length() == 1) ? "0" + ss[ss.length-2] : ss[ss.length-2];
            PEOPLE.add(new Person(name.substring(0, name.length()-1),
                    df.parse("" + Integer.parseInt(dStr) + "-" + Integer.parseInt(MStr) + "-" + Integer.parseInt(ss[ss.length-1]))));
        }

        r.close();

//        for (Person p : PEOPLE) {
//            System.out.println(p.getName() + "  " + p.getBirthday());
//        }
    }
}
//c:\r\1.txt