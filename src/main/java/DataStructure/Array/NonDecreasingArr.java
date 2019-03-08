package main.java.DataStructure.Array;

/**
 * Created by Ryan on 15/1/18.
 */

/*
Given an array with n integers,
your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
 */
public class NonDecreasingArr {
    public boolean checkPossibility(int[] nums) {
        int l = nums.length;
        if (l<=1) return true;
        int cnt=0;
        for (int i=1;i<l;i++) {
            if (nums[i]<nums[i-1]) {
                if (cnt==1) return false;
                cnt++;
                if (i>=2&&nums[i]<nums[i-2]) nums[i]=nums[i-1];
            }
        }
        return true;
    }
}
