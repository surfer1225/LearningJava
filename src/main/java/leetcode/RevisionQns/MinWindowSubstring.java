package main.java.leetcode.RevisionQns;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
76. Minimum Window Substring

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
 */
public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCharCntMap = new HashMap<>();
        for (char c:t.toCharArray()) tCharCntMap.put(c,tCharCntMap.getOrDefault(c,0)+1);
        Set<Character> missingChars = new HashSet<>(tCharCntMap.keySet());

        Map<Character, Integer> sCharCntMap = new HashMap<>();
        int j=0, min=Integer.MAX_VALUE;
        String result="";
        for (int i=0;i<s.length();++i) {
            char right = s.charAt(i);
            if (tCharCntMap.containsKey(right)) {
                sCharCntMap.put(right,sCharCntMap.getOrDefault(right,0)+1);
                if (sCharCntMap.get(right).equals(tCharCntMap.get(right))) missingChars.remove(right);
            }
            if (missingChars.isEmpty()) {
                while (missingChars.isEmpty() && j<=i) {
                    char left = s.charAt(j);
                    if (tCharCntMap.containsKey(left)) {
                        sCharCntMap.put(left, sCharCntMap.get(left) - 1);
                        if (sCharCntMap.get(left)<tCharCntMap.get(left)) {
                            missingChars.add(left);
                        }
                    }
                    j++;
                }
                if (i-j+2<min) {
                    result = s.substring(j-1,i+1);
                    min = i-j+2;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinWindowSubstring m = new MinWindowSubstring();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(m.minWindow("a", "a"));
    }
}
