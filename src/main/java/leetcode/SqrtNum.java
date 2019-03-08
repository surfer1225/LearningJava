package main.java.leetcode;

/**
 * Created by Ryan on 14/1/18.
 */

/*
Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
 */

public class SqrtNum {


    /* another idea!!!!!
    if(x < 4) return x == 0 ? 0 : 1;
    int res = 2 * mySqrt(x/4);
    if((res+1) * (res+1) <= x && (res+1) * (res+1) >= 0) return res+1;
    return res;
     */
    public int mySqrt(int x) {
        if (x<=1) return x;
        return mySqrtHelper(x, 0);
    }

    private int mySqrtHelper(int x, int base) {
        int temp = (base + 1) * (base + 1);
        if (temp > x) return base;
        if (temp == x) return base + 1;
        int i = 2;
        while ((base + i) * (base + i) < x) {
            i += i;
        }
        return mySqrtHelper(x, base + i / 2);
    }

    public static void main(String[] args) {
        SqrtNum s = new SqrtNum();
        System.out.println(s.mySqrt(65));
    }
}
