package main.java.leetcode;

import java.util.*;

/**
 * Created by Ryan on 10/9/17.
 */
public class ParenMatchGen {
    public List<String> generateParenthesis(int n) {
        if (n==1) {
            List<String> l = new LinkedList<>();
            l.add("()");
            return l;
        }
        else {
            Set<String> resSet = new HashSet<>();
            List<String> l = generateParenthesis(n-1);
            for (String s:l) {
                for (int i=0;i<=s.length();i++) {
                    resSet.add("("+s.substring(0, i)+")"+s.substring(i));
                }
            }
            return new ArrayList<>(resSet);
        }
    }

    public static void main(String[] args) {
        for (String s: new ParenMatchGen().generateParenthesis(3)) {
            System.out.println(s);
        }
    }
}
