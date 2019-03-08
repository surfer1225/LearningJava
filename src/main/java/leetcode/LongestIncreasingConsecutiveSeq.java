package main.java.leetcode;

/**
 * Created by Ryan on 8/1/18.
 */
/*
Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 */
public class LongestIncreasingConsecutiveSeq {
    public int findLengthOfLCIS(int[] nums) {
        int l = nums.length;
        if (l==0) return 0;
        if (l==1) return 1;
        int max = 0;
        int cnt = 1;
        for (int i=1;i<l;i++) {
            if (nums[i]>nums[i-1]) {
                cnt++;
            }
            else {
                max = cnt>max?cnt:max;
                cnt = 1;
            }
        }
        return cnt>max?cnt:max;
    }
}
