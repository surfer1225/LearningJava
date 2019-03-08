package main.java.leetcode.RevisionQns;

/**
 * Created by Ryan on 4/5/18.
 */

import java.util.*;

/**
 *
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output: 5

 Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 Example 2:

 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 Output: 0

 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        q.add(null);//null to set different levels apart
        int level = 1;
        while (!q.isEmpty()) {
            String s = q.poll();

            if (s == null) {
                level++;
                if (!q.isEmpty()) q.offer(null);
            }
            else {
                for (String word:new LinkedList<>(wordList)) {
                    if (isOneLetter(s, word)) {
                        if (word.equals(endWord)) return level+1;
                        q.offer(word);
                        wordList.remove(word);
                    }
                }
            }
        }
        return 0;
    }

    private boolean isOneLetter(String a, String b) {
        int diff = 0;
        for (int i=0;i<a.length();i++) {
            if (a.charAt(i)!=b.charAt(i)) {
                if (diff==1) return false;
                else diff++;
            }
        }
        return true;
    }

    /** bad solution with poor performance
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //end word not in the list
        if (!wordList.contains(endWord)) return 0;
        //prepare the list
        wordList.remove(beginWord);
        wordList.remove(endWord);
        wordList.add(endWord);

        List<String> cur = new LinkedList<>();
        cur.add(beginWord);
        int level = 1;

        while (wordList.contains(endWord)) {
            List<String> temp = new LinkedList<>();
            for (String str:new LinkedList<>(wordList)) {
                for (String curStr:cur) {
                    if (isOneLetter(curStr, str)) {
                        temp.add(str);
                        wordList.remove(str);
                    }
                }
            }
            cur = temp;
            if (temp.isEmpty()) return 0;
            level++;
        }
        return level;
    }
     */

    public static void main(String[] args) {
        WordLadder w = new WordLadder();
        System.out.println(
                w.ladderLength("leet", "code",
                        new ArrayList<>(Arrays.asList("lest","leet","lose","code","lode","robe","lost"))));
    }
}
