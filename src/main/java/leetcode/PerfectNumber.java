package main.java.leetcode;

/**
 * Created by Ryan on 14/1/18.
 */

/*
We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        int sqrt = (int) Math.sqrt(num);
        for (int i=2;i<=sqrt;i++) {
            if (num%i==0) sum+=(i+num/i);
        }
        if (sqrt*sqrt==num) sum-=sqrt;
        return num == sum+1;
    }
}
