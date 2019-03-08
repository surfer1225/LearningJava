package main.java.leetcode;

/**
 * Created by Ryan on 1/1/18.
 */

//Given an integer, write a function to determine if it is a power of two.

public class IsPow2 {
    public boolean isPowerOfTwo(int n) {
        return n>0 && ((n & (n-1)) == 0);//bit operation!!!
    }
}
