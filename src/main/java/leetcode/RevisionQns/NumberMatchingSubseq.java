package main.java.leetcode.RevisionQns;

/*
Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :
Input:
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 */
public class NumberMatchingSubseq {

    // exceeding time limit :-(
    public int numMatchingSubseq(String S, String[] words) {
        int cnt = 0;
        for (String word:words) {
            if (isSubsequence(word, S)) {
                cnt++;
                System.out.println(word);
            }
        }
        return cnt;
    }

    private boolean isSubsequence(String s, String t) {
        if (s.length()<=1) return t.contains(s);
        int i = t.indexOf(s.charAt(0));
        return i >= 0 && isSubsequence(s.substring(1), t.substring(i + 1));
    }
}
