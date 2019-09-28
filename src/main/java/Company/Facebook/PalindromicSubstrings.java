package main.java.Company.Facebook;

/*
647. Palindromic Substrings

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are
counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".


Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length(), res = 0;

        for (int i=0;i<n;i++) {
            int left = i;
            int right = i;

            while (left>=0 && right<n && s.charAt(left) == s.charAt(right)) {
                ++res;
                --left;
                ++right;
            }
        }

        for (int i=1;i<n;i++) {
            int left = i-1;
            int right = i;

            while (left>=0 && right<n && s.charAt(left) == s.charAt(right)) {
                ++res;
                --left;
                ++right;
            }
        }

        return res;
    }
}
