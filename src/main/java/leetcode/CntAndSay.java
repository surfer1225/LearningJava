package main.java.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ryan on 16/12/17.
 */

/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.
 */
public class CntAndSay {
    public String countAndSay(int n) {
        String prev = "1";
        if (n==1) return prev;
        for (int i=1;i<n;i++) {
            char c = prev.charAt(0);
            int num = 0;
            List<Helper> l = new LinkedList<>();
            for (int j=0;j<prev.length();j++) {
                if (prev.charAt(j)==c) {
                    num++;
                }
                else {
                    l.add(new Helper(num, c));
                    c = prev.charAt(j);
                    num = 1;
                }
            }
            l.add(new Helper(num, c));
            prev = "";
            for (Helper h: l) {
                prev+=h.n;
                prev+=h.num;
            }
        }

        return prev;
    }

    public static void main(String[] args) {
        CntAndSay cs = new CntAndSay();
        System.out.println(cs.countAndSay(4));
    }

    private class Helper {
        int n;
        char num;
        public Helper(int n, char num) {
            this.n = n;
            this.num = num;
        }
    }
}
