package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object n) {
        if (n == null) return false;
        if (n==this) return true;
        if (!(n instanceof Solution)) return  false;
        Solution nn = (Solution)n;

        //return (nn.first == null && first == null || nn.first.equals(first)) && (nn.last == null && last == null || nn.last.equals(last));
        return (Objects.equals(first, nn.first) && Objects.equals(last, nn.last));

//        if (nn.first == null || first == null || nn.last == null || last == null) return false;
//        return (nn.first.equals(first)) && (nn.last.equals(last));
    }

    @Override
    public int hashCode() {
        //return 31 * (first==null ? 0 : first.hashCode()) + last==null ? 0 : last.hashCode();
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<Solution>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));

//        s.add(new Solution(null, "Duck"));
//        System.out.println(s.contains(null));

//        s.add(null);
//        System.out.println(s.contains(new Solution(null, "Duck")));
//        System.out.println(s.contains(null));
    }
}
