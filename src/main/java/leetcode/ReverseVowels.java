package main.java.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ryan on 13/1/18.
 */

/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        char[] charArr = s.toCharArray();
        while (i < j) {
            char left = Character.toLowerCase(charArr[i]), right = Character.toLowerCase(charArr[j]);
            if (set.contains(left)) {
                if (set.contains(right)) {
                    char temp = charArr[i];
                    charArr[i] = charArr[j];
                    charArr[j] = temp;
                    i++;
                }
                j--;
            }
            else {
                i++;
                if (!set.contains(right)) j--;
            }
        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        ReverseVowels r = new ReverseVowels();
        System.out.println(r.reverseVowels("leetcode"));
    }
}
