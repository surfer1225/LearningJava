package main.java.leetcode;

/**
 * Created by Ryan on 1/1/18.
 */

// is power of 3
public class isPow3 {
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        //return ( n>0 && 1162261467%n==0);

        // another way to do
        /*
        return (Math.log(num) / Math.log(4)) % 1 == 0;
         */

        return (Math.log(n) / Math.log(3)) % 1 == 0;
    }

    public static void main(String[] args) {
        isPow3 i = new isPow3();
        System.out.println(i.isPowerOfThree(27));
    }
}
