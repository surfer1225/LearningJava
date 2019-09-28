package main.java.leetcode.RevisionQns;

import java.util.*;

/*
139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);

        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for (int i=1;i<=s.length();++i) {
            for (int j=0;j<i;++j) {
                if (res[j] && dict.contains(s.substring(j,i))) {
                    res[i] = true;
                    break;
                }
            }
        }

        return res[s.length()];
    }

    /*
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
    add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

    Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.
    Example 1:

    Input:
    s = "catsanddog"
    wordDict = ["cat", "cats", "and", "sand", "dog"]
    Output:
    [
      "cats and dog",
      "cat sand dog"
    ]

     */

    public List<String> wordBreakII(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<Integer>[] graph = new LinkedList[s.length()+1];

        graph[0] = new LinkedList<>();

        for (int i=1;i<graph.length;++i) {
            for (int j=0;j<i;++j) {
                if (graph[j]!=null && dict.contains(s.substring(j,i))) {
                    if (graph[i]==null) graph[i] = new LinkedList<>();
                    graph[i].add(j);
                }
            }
        }

        if (graph[s.length()]==null) return new LinkedList<>();

        List<String> res = new LinkedList<>();
        dfs(res, "", graph, s, s.length());
        return res;
    }

    private void dfs(List<String> res, String acc, List<Integer>[] graph, String s, int end) {
        for (int i:graph[end]) {
            String newAcc = acc.isEmpty()?s.substring(i,end):s.substring(i, end) + " " + acc;
            if (i==0) res.add(newAcc);
            else dfs(res, newAcc, graph, s, i);
        }
    }

    // check all words
    /*
    private boolean wordBreakHelper(String s, Set<String> words) {
        if (words.contains(s)) return true;
        for (String word:words) {
            if (s.startsWith(word)) {
                if (wordBreakHelper(s.substring(word.length()), words)) return true;
            }
        }
        return false;
    }
     */

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        for (String word:wb.wordBreakII("catsanddog", Arrays.asList("cat","cats","and","sand","dog"))) System.out.println(word);
    }
}
