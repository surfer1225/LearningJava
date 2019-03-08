package main.java.leetcode.RevisionQns;

/**
 * Created by Ryan on 13/5/18.
 */

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int n = s.length();
        int w2 = 1;
        int w1 = s.charAt(n-1)=='0'?0:1;
        int cur = w1;

        for (int i = n-2;i>=0;i--) {
            if (s.charAt(i)=='0') {
                cur=0;
            }
            else {
                cur = Integer.parseInt(s.substring(i,i+2))<27?w1+w2:w1;
            }

            w2 = w1;
            w1 = cur;
        }

        return cur;
    }

    /*
    public int numDecodings(String s) {
        char c = s.charAt(0);
        if (c=='0') return 0;
        int l=s.length();
        if (l==1) return 1;
        char c1 = s.charAt(1);
        if (l==2) {
            if (c1=='0') return (c-'0')>2?0:1;
            if (isLetter(s)) return 2;
            else return 1;
        }
        if (c1=='0') return (c=='1'||c=='2')?numDecodings(s.substring(2)):0;
        if (isLetter(s.substring(0,2))) return numDecodings(s.substring(1))+numDecodings(s.substring(2));
        return numDecodings(s.substring(1));
    }

    private boolean isLetter(String s) {
        return Integer.valueOf(s)<=26;
    }
    */
}
