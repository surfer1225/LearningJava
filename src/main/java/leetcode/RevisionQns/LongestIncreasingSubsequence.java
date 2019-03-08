package main.java.leetcode.RevisionQns;

/**
 * Created by Ryan on 23/12/17.
 */

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101],
therefore the length is 4.
Note that there may be more than one LIS combination,
it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        if (l<=1) return l;
        int[] res = new int[l];
        res[0] = 1;
        int max = 0;
        for (int i=1;i<l;i++) {
            boolean found = false;
            for (int j=i-1;j>=0;j--) {
                if (nums[j]<nums[i]) {
                    res[i] = res[j]+1>res[i]?res[j]+1:res[i];
                    found = true;
                }
            }
            if (!found) res[i] = 1;
            max = res[i]>max?res[i]:max;
        }
        //for (int i=0;i<res.length;i++) System.out.println("element: "+res[i]);
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
