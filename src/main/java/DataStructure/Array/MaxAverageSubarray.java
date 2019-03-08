package main.java.DataStructure.Array;

/**
 * Created by Ryan on 10/1/18.
 */

/*
Given an array consisting of n integers,
find the contiguous subarray of given length k that has the maximum average value.
And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 */
public class MaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int l = nums.length;
        int sum=0;
        for (int i=0;i<k;i++) {
            sum+=nums[i];
        }
        int max=sum;
        for (int i=k;i<l;i++) {
            sum = sum - nums[i-k] + nums[i];
            max = sum>max?sum:max;
        }
        return max*1.0/k;
        //return Double.valueOf(max)/Double.valueOf(k);
    }

    public static void main(String[] args) {
        MaxAverageSubarray m = new MaxAverageSubarray();
        System.out.println(m.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
