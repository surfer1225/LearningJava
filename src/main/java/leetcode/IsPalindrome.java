package main.java.leetcode;

/**
 * Created by Ryan on 2/12/17.
 */

// without adding extra space
public class IsPalindrome {

    private static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int digits = 0;
        int temp = x;
        while (temp / Math.pow(10, digits) > 0) {
            temp /= 10;
            digits += 1;
        }
        System.out.println(digits);
        int right = 0;
        int left = digits - 1;
        while (right < left) {
            int rightDigit = (x / (int) Math.pow(10, right)) % 10;
            int leftDigit = (x / (int) Math.pow(10, left)) % 10;
            if (rightDigit != leftDigit) return false;
            left -= 1;
            right += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1243));
        System.out.println(isPalindrome(1243421));
    }
}
