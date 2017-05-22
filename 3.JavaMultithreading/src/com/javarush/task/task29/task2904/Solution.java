package com.javarush.task.task29.task2904;

/* 
Особенности автобоксинга
*/
public class Solution {
    private Integer[] array = new Integer[]{1, 2, 3, 4};

    public static void main(String[] args) {
        Number value1 = new Solution().getValueByIndex(5); //-1.0, class java.lang.Double expected
        Number value2 = new Solution().getValueByIndex(2); //3, class java.lang.Integer expected

        System.out.println(value1 + ", " + value1.getClass().toString());
        System.out.println(value2 + ", " + value2.getClass().toString());

//        Solution sol = new Solution();
//        for (int i = 0; i < sol.array.length; i++) {
//            Number val = sol.getValueByIndex(i);
//            System.out.println(val + ", " + val.getClass().toString());
//            Number valArr = sol.array[i];
//            System.out.println("  "  + valArr + ", " + valArr.getClass().toString());
//        }
    }

    Number getValueByIndex(int index) {
        return (index >= 0 && index < array.length) ?  array[index] : (Number) new Double(-1);
    }
}
