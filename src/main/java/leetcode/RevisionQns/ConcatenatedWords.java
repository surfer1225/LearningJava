package main.java.leetcode.RevisionQns;

import java.util.*;

/*
472. Concatenated Words

Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 */
public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new LinkedList<>();
        if (words == null || words.length == 0) return list;
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String s: words){
            set.remove(s);
            if (this.search(s, set)) list.add(s);
            set.add(s);
        }
        return list;
    }

    private boolean search(String s, Set<String> set){
        if (set.contains(s)) return true;

        for (int i = 1; i <= s.length(); i++)
            if(set.contains(s.substring(0, i)) && this.search(s.substring(i), set)) return true;

        return false;
    }

    /*
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new LinkedList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        Set<String> wordSet = new LinkedHashSet<>(Arrays.asList(words));
        for (int i=0;i<words.length;++i) {
            wordSet.remove(words[i]);
            if (canWordBeComposed(wordSet, words[i])) res.add(words[i]);

        }
        return res;
    }

    private boolean canWordBeComposed(Set<String> words, String word) {
        if (word.isEmpty()) return false;
        boolean[] res = new boolean[word.length()+1];
        res[0] = true;
        for (int i=1;i<res.length;++i) {
            for (int j=0;j<i;++j) {
                if (res[j]) {
                    if (words.contains(word.substring(j))) return true;
                    if (words.contains(word.substring(j,i))) res[i] = true;
                }
            }
        }
        return res[word.length()];
    }
     */

    public static void main(String[] args) {
        ConcatenatedWords cw = new ConcatenatedWords();
        for (String word:cw.findAllConcatenatedWordsInADict(
                new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"})) {
            System.out.println(word);
        }
    }
}
