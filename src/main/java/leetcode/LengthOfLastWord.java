package main.java.leetcode;

/**
 * Created by Ryan on 16/12/17.
 */
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.trim().equals("")) return 0;
        String[] arr = s.split(" ");
        return arr[arr.length-1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();
        System.out.println(l.lengthOfLastWord("Hello World"));
    }
}
