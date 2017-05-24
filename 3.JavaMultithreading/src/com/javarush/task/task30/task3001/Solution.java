package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumerationSystemType._16, "6df");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._8);
        System.out.println(result);    //expected 3337

//        number = new Number(NumerationSystemType._12, "6ac");
//        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._16);
//        System.out.println(result);

//        result = convertNumberToOtherNumerationSystem(null, NumerationSystemType._16);
//        System.out.println(result);

//        number = new Number(NumerationSystemType._12, null);
//        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._16);
//        System.out.println(result);

//        number = new Number(null, "6ac");
//        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._16);
//        System.out.println(result);

//        number = new Number(NumerationSystemType._16, "6df");
//        result = convertNumberToOtherNumerationSystem(number, null);
//        System.out.println(result);
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        //напишите тут ваш код
        if (number == null || number.getDigit() == null || number.getNumerationSystem() == null || expectedNumerationSystem == null) {
            throw new NumberFormatException();
        }

        int srcRadix = number.getNumerationSystem().getNumerationSystemIntValue();
        int destRadix = expectedNumerationSystem.getNumerationSystemIntValue();
        int decVal;
        if (srcRadix == 10) {
            decVal = Integer.parseInt(number.getDigit());
        }
        else {
            decVal = Integer.parseInt(number.getDigit(), srcRadix);
        }
        String outS = Integer.toUnsignedString(decVal, destRadix);
        Number res = new Number(expectedNumerationSystem, outS);

        return res;
    }
}
