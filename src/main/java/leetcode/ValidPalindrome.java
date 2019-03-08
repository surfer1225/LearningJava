package main.java.leetcode;

/**
 * Created by Ryan on 25/12/17.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9 ]", "").toLowerCase();
        System.out.println(s);
        for (int i=0,j=s.length()-1;i<=j;i++,j--) {
            if (s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }

    /*
    Given a non-empty string s, you may delete at most one character.
    Judge whether you can make it a palindrome.
    Example 1:
    Input: "aba"
    Output: True
    Example 2:
    Input: "abca"
    Output: True
    Explanation: You could delete the character 'c'.
     */
    public boolean validPalindrome(String s) {
        return validPalindromeHelper(s, true);
    }

    private boolean validPalindromeHelper(String s, boolean noDelete) {
        System.out.println(s);
        for (int i=0,j=s.length()-1;i<=j;i++,j--) {
            if (s.charAt(i)!=s.charAt(j)) {
                if (!noDelete) return false;
                else {
                    return validPalindromeHelper(s.substring(i+1, j+1), false) ||
                    validPalindromeHelper(s.substring(i, j), false);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome("a ba"));
    }
}
