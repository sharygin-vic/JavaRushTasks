package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс
*/

/*
Требования:
1. +++ В классе Solution должно существовать приватное статическое финальное поле logger.
2. +++ Добавь логирование уровня error один раз.
3. --- Добавь логирование уровня debug шесть раз.
      (Надоело после 30 попыток сдать, бубен сломался. Жалко тратить время на подобную ерунду.)
4. +++ Добавь логирование уровня trace четыре раза.
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        logger.debug("Solution(): value1 = " + value1 + " , value2 = " + value2 + " , value3 = " + value3);
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(111, "222", new Date());
    }

    public void calculateAndSetValue3(long value) {
        logger.trace("calculateAndSetValue3( " + value + " )");
        logger.debug("old value1 = " + value1);
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
        } else {
            value1 = (int) value;
        }
        logger.debug("new value1 = " + value1);
    }

    public void printString() {
        logger.trace("printString(): value2 = " + value2);
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("printDateAsLong(): value3 = " + value3);
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        logger.trace("divide( " + number1 + ", " + number2 + " )");
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("Divide error: ", e);
        }
    }

    public void setValue1(int value1) {
        logger.debug("setValue1(): value1 = " + value1);
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        logger.debug("setValue2(): value2 = " + value2);
        this.value2 = value2;
    }

    public void setValue3(Date value3) {
        logger.debug("setValue3(): value3 = " + value3);
        this.value3 = value3;
    }
}
