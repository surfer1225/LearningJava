package main.java.leetcode.RevisionQns;

import java.util.HashMap;
import java.util.Map;

/*
523. Continuous Subarray Sum

Given a list of non-negative numbers and a target integer k,
write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k,
that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 */
public class ContinuousSubArrSum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i+1] == 0) return true;
        }
        if (k == 0) return false; /* since we know we don't have continuous 0s in nums anymore after the previous for loop*/

        int[] sum = new int[nums.length];
        int preSum = 0;
        for (int i = 0; i < sum.length; i++) {
            sum[i] = nums[i] + preSum;
            preSum += nums[i];
        }

        /* There are two kind of possible solutions: 1) sum[J] itself is divisible by k. 2) sum[J] - sum[I] is divisible by k*/
        Map<Integer, Integer> remainderToIndex = new HashMap<>();
        remainderToIndex.put(0, -1); /* for case 1). if sum[J] is divisible by k, then the length is J + 1 (= J - (-1))*/

        for (int i = 0; i < sum.length; i++) {
            int remainder = sum[i] % k;
            if (remainderToIndex.containsKey(remainder)) {
                if (i - remainderToIndex.get(remainder) > 1) {
                    return true; /* i is J, remainderToIndex.get(remainder) is I
                                  If sum[J]%k = sum[I]%k, then (sum[J]-sum[I]) % k = 0. This is case 2)*/
                }
            } else {
                remainderToIndex.put(remainder, i);
            }
        }
        return false;
         /*
        int[] sum = new int[nums.length+1];

        sum[0]=0;
        for (int i=1;i<sum.length;i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }

        for (int i=0;i<sum.length-2;i++) {
            for (int j=i+2;j<sum.length;j++) {
                int diff = sum[j]-sum[i];
                if (diff==k || (k!=0&&diff%k==0)) return true;
            }
        }

        return false;
          */
    }

    public static void main(String[] args) {
        ContinuousSubArrSum c = new ContinuousSubArrSum();
        System.out.println(c.checkSubarraySum(new int[]{23,2,4,6,7},6));
        System.out.println(c.checkSubarraySum(new int[]{23,2,6,4,7},6));
        System.out.println(c.checkSubarraySum(new int[]{0,0},0));
    }
}