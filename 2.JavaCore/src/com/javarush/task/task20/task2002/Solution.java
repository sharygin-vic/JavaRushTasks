package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("task2002_", ".txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");

            User user = new User();
            javaRush.users.add(user);
            user.setLastName("Last_1");
            user.setFirstName("First_1");
            user.setMale(true);
            user.setBirthDate(fmt.parse("12-05-1990"));
            user.setCountry(User.Country.OTHER);

            user = new User();
            javaRush.users.add(user);
            user.setLastName("Last_2");
            user.setFirstName("First_2");
            user.setMale(false);
            user.setBirthDate(fmt.parse("02-12-2001"));
            user.setCountry(User.Country.RUSSIA);

            user = new User();
            javaRush.users.add(user);
            user.setLastName("Last_3");
            user.setFirstName("First_3");
            user.setMale(false);
            user.setBirthDate(fmt.parse("05-03-1965"));
            user.setCountry(User.Country.UKRAINE);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter prn = new PrintWriter(outputStream);
            //SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            prn.println(users.size());
            for (User user : users) {
                prn.println(user.getFirstName());
                prn.println(user.getLastName());
                //prn.println(fmt.format(user.getBirthDate()));
                prn.println(user.getBirthDate().getTime());
                prn.println(user.isMale());
                prn.println(user.getCountry());
            }
            prn.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            //SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            int count = Integer.parseInt(r.readLine());
            for (int i = 0; i < count; i++) {
                User user = new User();
                users.add(user);
                user.setFirstName(r.readLine());
                user.setLastName(r.readLine());
                //user.setBirthDate(fmt.parse(r.readLine()));
                Date date = new Date();
                date.setTime(Long.parseLong(r.readLine()));
                user.setBirthDate(date);
                user.setMale(Boolean.parseBoolean(r.readLine()));
                user.setCountry(User.Country.valueOf(r.readLine()));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
