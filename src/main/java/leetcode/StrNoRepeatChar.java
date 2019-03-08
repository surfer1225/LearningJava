package main.java.leetcode;

import java.util.*;

/**
 * Created by Ryan on 1/9/17.
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:
 Given "abcabcbb", the answer is "abc", which the length is 3.
 Given "bbbbb", the answer is "b", with the length of 1.
 Given "pwwkew", the answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 Solution: sliding window, i, j, as indices to go in 2 directions to check
 */
public class StrNoRepeatChar {
    public static String lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        int i = 0, j;
        String temp = null;
        for (j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                System.out.println("map data: j = " + j + " i = " + i + " char = " + s.charAt(j));
                i = Math.max(map.get(s.charAt(j)), i);
            }
//            ans = Math.max(ans, j - i + 1);
            if (ans < (j - i + 1)) {
                ans = j - i + 1;
                temp = s.substring(i, j + 1);
            }

            map.put(s.charAt(j), j + 1);
        }
//        System.out.println("length: " + ans);
        return temp;
    }

    private static int los(String s) {
        int longest = 0;
        int indexOfNoRepeat = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            if (m.containsKey(c)) {
                // for repeated char, begin index should be the one next to the last occurred repeating char
                indexOfNoRepeat = Math.max(m.get(c)+1, indexOfNoRepeat);
            }

            longest=Math.max(i-indexOfNoRepeat+1, longest);
            m.put(c, i);
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(los("abba"));
        System.out.println(los("dvdf"));
//        System.out.println(los("bbbbb"));
    }
}
