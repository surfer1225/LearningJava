package main.java.leetcode.RevisionQns;

/**
 * Created by Ryan on 25/12/17.
 */

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaxProdArr {
    public int maxProduct(int[] nums) {
        // the max result we have so far
        int r = nums[0];

        for (int i=1, imax=r, imin=r; i<nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);


            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }

        return r;
    }

    public static void main(String[] args) {
        MaxProdArr m = new MaxProdArr();
        System.out.println(m.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(m.maxProduct(new int[]{-1,2,3,-2,4}));
        System.out.println(m.maxProduct(new int[]{3,-2,4}));
        System.out.println(m.maxProduct(new int[]{2,-5,-2,-4,3}));
    }
}
