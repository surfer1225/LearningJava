package main.java.DataStructure.String;

/**
 * Created by Ryan on 31/12/17.
 */

/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] strings = s.trim().replaceAll(" +", " ").split(" ");
        String str = "";
        for (int i=strings.length-1;i>=0;i--) {
            str+=(strings[i]+" ");
        }
        return str.trim();
    }
}
