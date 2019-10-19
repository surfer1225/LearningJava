package main.java.Company.Facebook;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
953. Verifying an Alien Dictionary

In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet,
return true if and only if the given words are sorted lexicographicaly in this alien language.

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.)
According to lexicographical rules "apple" > "app", because 'l' > '∅',
where '∅' is defined as the blank character which is less than any other character (More info).
 */
public class AlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {

        if (words == null || words.length<=1) return true;

        Map<Character, Integer> orderMap = new HashMap<>();
        int cnt = 0;
        for (char c:order.toCharArray()) {
            orderMap.put(c,cnt++);
        }

        Comparator<String> alienComparator = (o1, o2) -> {
            int i=0,j=0;
            while (i<o1.length() && j<o2.length()) {
                int charComparisonResult = orderMap.get(o1.charAt(i++)).compareTo(orderMap.get(o2.charAt(j++)));
                if (charComparisonResult != 0) return charComparisonResult;
            }
            return Integer.valueOf(o1.length()).compareTo(Integer.valueOf(o2.length()));
        };

        for (int i=1;i<words.length;++i) {
            if (alienComparator.compare(words[i-1],words[i])==1) return false;
        }

        return true;
    }
}
