package main.java.leetcode;

import java.util.Set;
import java.util.TreeSet;

/*
5086. Smallest Subsequence of Distinct Characters

Return the lexicographically smallest subsequence of text that contains all the distinct characters of text exactly once.

Example 1:

Input: "cdadabcc"
Output: "adbc"
 */
public class SmallestSubseqWithDistinctCharStupicSolution {
    public String smallestSubsequence(String text) {
        Set<Character> sortedSet = new TreeSet<>();

        for (char c:text.toCharArray()) {
            if (!sortedSet.contains(c)) sortedSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character c:sortedSet) sb.append(c);
        String initialSmallest = sb.toString();

        while (!isSubseq(initialSmallest,text)) initialSmallest = nextPermutation(initialSmallest.toCharArray());

        return initialSmallest;
    }

    private boolean isSubseq(String sub, String s) {
        if (sub.length()<=1) return s.contains(sub);
        int i = s.indexOf(sub.charAt(0));
        return i >= 0 && isSubseq(sub.substring(1), s.substring(i + 1));
    }

    private String nextPermutation(char[] chars) {
        int i = chars.length - 2;
        while (i >= 0 && chars[i + 1] <= chars[i]) {
            i--;
        }
        if (i >= 0) {
            int j = chars.length - 1;
            while (j >= 0 && chars[j] <= chars[i]) {
                j--;
            }
            swap(chars, i, j);
        }
        reverse(chars, i + 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start) {
        int i = start, j = chars.length - 1;
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


    public static void main(String[] args) {
        SmallestSubseqWithDistinctCharStupicSolution s = new SmallestSubseqWithDistinctCharStupicSolution();
        System.out.println(s.smallestSubsequence("cdadabcc"));
    }
}
