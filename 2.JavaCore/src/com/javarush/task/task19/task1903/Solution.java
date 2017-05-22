package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
//        TestIncomeData test = new TestIncomeData();
//        IncomeDataAdapter ad = new IncomeDataAdapter(test);
//        System.out.println(ad.getCompanyName());
//        System.out.println(ad.getCountryName());
//        System.out.println(ad.getName());
//        System.out.println(ad.getPhoneNumber());
    }

//    public static class TestIncomeData implements IncomeData {
//
//        @Override
//        public String getCountryCode() {
//            return "UA";
//        }
//
//        @Override
//        public String getCompany() {
//            return "JavaRush Ltd.";
//        }
//
//        @Override
//        public String getContactFirstName() {
//            return "Ivan";
//        }
//
//        @Override
//        public String getContactLastName() {
//            return "Ivanov";
//        }
//
//        @Override
//        public int getCountryPhoneCode() {
//            return 38;
//        }
//
//        @Override
//        public int getPhoneNumber() {
//            return 501234567;
//        }
//    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }


        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
//            String s = "" + data.getPhoneNumber();
//
//            StringBuilder sb = new StringBuilder();
//            sb.append("+").append(data.getCountryPhoneCode()).append("(");
//            int countSpace = 10 - s.length();
//            for (int i = 0; i < countSpace; i++) {
//                sb.append(0);
//            }
//            sb.append(s);
//            sb.insert(7, ")").insert(11, "-").insert(14, "-");
//
//            return sb.toString();

            String phone = String.valueOf(data.getPhoneNumber());
            StringBuilder allNumber = new StringBuilder(data.getCountryPhoneCode());
            if (phone.length()< 10){
                for (int i = 0; i < 10 - phone.length(); i++) {
                    allNumber.insert(0,'0');
                }
            }
            allNumber.append(phone);
            return  String.format( "+" + data.getCountryPhoneCode() + "("+ allNumber.substring(0,3) + ")"
                    + allNumber.substring(3,6) + "-" + allNumber.substring(6,8) + "-" + allNumber.substring(8,10));
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}