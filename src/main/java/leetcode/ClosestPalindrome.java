package main.java.leetcode;

/**
 * Created by Ryan on 25/1/18.
 */

/*
Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"
Note:
The input n is a positive integer represented by string, whose length will not exceed 18.
If there is a tie, return the smaller one as answer.
 */

public class ClosestPalindrome {
    public String nearestPalindromic(String n) {
        int l = n.length();
        String fir=fir=n.substring(0,l/2), mid="", tail="";
        if (l%2==0) {
            tail=n.substring(l/2);
        }
        else {
            tail=n.substring((l+1)/2);
            mid =n.substring(l/2,l/2+1);
        }
        return fir+mid+mirror(fir);
    }

    private String mirror(String m) {
        return new StringBuilder(m).reverse().toString();
    }
}
