package main.java.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.
Words in the paragraph are not case sensitive.  The answer is in lowercase.



Example:

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] arr = paragraph.toLowerCase().replaceAll("[^a-z ]"," ")
                .trim().split("\\s+");
        Set<String> s = new HashSet<>();
        for (String w:banned) s.add(w.toLowerCase());

        String result = arr.length>0?arr[0]:"";
        int max = 0;
        Map<String, Integer> m = new HashMap<>();
        for (String w:arr) {
            if (s.contains(w)) continue;
            if (m.containsKey(w)) {
                int n = m.get(w) + 1;
                if (n > max) {
                    max = n;
                    result = w;
                }
                m.put(w, n);
            }
            else {
                if (max==0) {
                    max = 1;
                    result = w;
                }
                m.put(w, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MostCommonWord m = new MostCommonWord();
        System.out.println(m.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[] {"hit"}));
    }
}
