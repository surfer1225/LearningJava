package main.java.leetcode.RevisionQns;

/*
55. Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums==null||nums.length<2) return true;
        boolean[] dp = new boolean[nums.length];
        dp[nums.length-1]=true;
        for (int i=nums.length-2;i>=0;i--) {
            for (int j=i+1;j<=i+nums[i]&&j<nums.length;j++) {
                if (dp[j]) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
