package main.java.leetcode.RevisionQns;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ryan on 2/4/18.
 */

/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNum {
    public String largestNumber(int[] nums) {
        List<Integer> l = new LinkedList<>();
        boolean allZero = true;
        for (int i = 0;i<nums.length;i++) {
            if (nums[i]!=0) {
                allZero = false;
            }
            l.add(nums[i]);
        }
        if (allZero) return "0";
        StringBuilder sb = new StringBuilder();
        l.sort((m, n)  -> {
            if (m==n) return 0;
            int nDigit = numDigit(n), mDigit = numDigit(m);
            if (nDigit == mDigit) return n-m;
            else if (m * (Math.pow(10, nDigit)) + n > n * (Math.pow(10, mDigit)) + m) {
                return -1;
            }
            else return 1;
        });
        for (Integer i:l) sb.append(i.toString());
        return sb.toString();
    }

    private int numDigit(int n) {
        if (n==0) return 1;
        int length = 0;
        long temp = 1;
        while (temp <= n) {
            length++;
            temp *= 10;
        }
        return length;
    }

    private int firstDigit(int num)
    {
        if(num/10 == 0)
            return num;
        return firstDigit(num/10);
    }

    public static void main(String[] args) {
        LargestNum l = new LargestNum();
        //System.out.println(l.largestNumber(new int[]{98,97,99}));
        System.out.println(l.largestNumber(new int[]{0,1,2}));
    }
}
