package main.java.leetcode;

/**
 * Created by Ryan on 12/1/18.
 */

/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        String temp = "";
        for (String str:strArr) {
            temp+=(new StringBuilder(str).reverse().toString())+" ";
        }
        return temp.substring(0, temp.length()-1);
    }

    public static void main(String[] args) {
        ReverseWords rs = new ReverseWords();
        System.out.println(rs.reverseWords("Hello World"));
    }
}
