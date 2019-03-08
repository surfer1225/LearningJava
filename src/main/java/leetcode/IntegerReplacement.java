package main.java.leetcode;

/*
397. Integer Replacement

Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
 */
public class IntegerReplacement {
    public static int integerReplacement(int n) {
        /* memory limit exceeded
        int[] dp = new int[n];
        dp[0]=0;

        for (int i=1;i<n;i++) {
            if (i%2==1) dp[i]=dp[i/2]+1;
            else dp[i]=Math.min(dp[(i+1)/2]+2,dp[i-1]+1);
        }

        return dp[n-1];
        */
        if (n==1) return 0;
        if (n%2==0) return integerReplacement(n/2)+1;
        if (n==Integer.MAX_VALUE) return integerReplacement(n-1);
        return Math.min(integerReplacement(n+1), integerReplacement(n-1))+1;
    }

    public static void main(String[] args) {

        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(2147483647));
    }
}
