package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] res = new Solution[2];

        Solution sol = new Solution();
        sol.innerClasses[0] = sol.new InnerClass();
        sol.innerClasses[1] = sol.new InnerClass();
        res[0] = sol;

        sol = new Solution();
        sol.innerClasses[0] = sol.new InnerClass();
        sol.innerClasses[1] = sol.new InnerClass();
        res[1] = sol;

        return res;
    }

    public static void main(String[] args) {

    }
}
