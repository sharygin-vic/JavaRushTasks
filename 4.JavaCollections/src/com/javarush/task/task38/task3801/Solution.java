package com.javarush.task.task38.task3801;

/* 
Исправь ошибки в коде
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                System.out.println("Имя содержит " + NameChecker.getNumberOfCharacters(args[0]) + " символов");
//            } catch (Exception e) {                   //vic
//                System.out.println(e.toString());     //vic
//            }                                         //vic
            } catch (NameIsNullException e) {
                System.out.println("Ошибка: Имя не задано");
            } catch (NameIsEmptyException e) {
                System.out.println("Ошибка: Имя пустое");
            } catch (Exception e) {                     //vic
                System.out.println(e.toString());       //vic
            }                                           //vic
        }
    }
}
