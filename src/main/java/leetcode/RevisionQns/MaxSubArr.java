package main.java.leetcode.RevisionQns;

/**
 * Created by Ryan on 16/12/17.
 */
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
which is more subtle.
 */
public class MaxSubArr {

    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int max = sum[0];
        for (int i=1;i<nums.length;i++) {
            sum[i] = sum[i-1]<0?nums[i]:sum[i-1]+nums[i];
            max = sum[i]>max?sum[i]:max;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArr m = new MaxSubArr();
        System.out.println(m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
