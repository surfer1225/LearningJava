package main.java.leetcode.RevisionQns;

/*
Given a positive integer n, break it into the sum of at least two positive integers
and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n==2) return 1;
        if (n==3) return 2;
        switch (n%3) {
            case 0: return (int) Math.pow(3, n/3);
            case 1: return ((int) Math.pow(3, n/3-1)) * 4;
            case 2: return ((int) Math.pow(3, n/3)) * 2;
        }
        return 0;
    }
}
