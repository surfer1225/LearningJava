package main.java.leetcode.RevisionQns;

import java.util.*;
import java.util.stream.Collectors;

/*
312. Burst Balloons

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
You are asked to burst all the balloons.
If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloon {

    Map<String, Integer> dp = new HashMap<>();

    public int maxCoins(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0]*nums[1]+Math.max(nums[0],nums[1]);
        return maxCoins(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    private int maxCoins(List<Integer> nums) {
        if (nums.size() == 3) {
            int tripletMax = nums.get(0) * nums.get(1) * nums.get(2) + nums.get(0) * nums.get(2) +
                    Math.max(nums.get(0),nums.get(2));
            dp.put(nums.get(0)+","+nums.get(1)+","+nums.get(2), tripletMax);
            return tripletMax;
        }

        String numsKey = nums.stream().map(String::valueOf).collect(Collectors.joining(","));
        if (dp.containsKey(numsKey)) {
            System.out.println("result found for: " + numsKey);
            return dp.get(numsKey);
        }

        int max = Integer.MIN_VALUE;

        for (int i=0;i<nums.size();++i) {
            int cur = (i==0?1:nums.get(i-1))*nums.get(i)*(i==nums.size()-1?1:nums.get(i+1));
            List<Integer> smallerList = new ArrayList<>(nums);
            smallerList.remove(i);
            int smallerResult = maxCoins(smallerList);
            dp.put(smallerList.stream().map(String::valueOf).collect(Collectors.joining(",")),smallerResult);
            max = Math.max(max,cur + smallerResult);
        }

        return max;
    }

    public static void main(String[] args) {
        BurstBalloon bb = new BurstBalloon();
        System.out.println(bb.maxCoins(new int[]{3,1,5,8}));
    }
}

/*
Idea
This problem can be solved via divider conquer and dynamic programming.
We use sum[i][j] to denote the max coins we can get for ballons from index i to index j.

How can we calculate sum[i][j]? Imagine kth (i <= k <= j) ballon is the last one we burst in the subarray [i, j].
Then the coin we can get for bursting kth ballon is apparently nums[i - 1] * nums[k] * nums[j + 1].
And the total coins for [i, j] is sum[i][k - 1] + sum[k + 1][j] + nums[i - 1] * nums[k] * nums[j + 1].
What we need to do is traverse from i to j to get the best k.

Note that we add two dummy ballons to the head and tail respectively for the convenience of calculation.

class Solution {
    public int maxCoins(int[] nums) {
        // add dummy head and tail
        int helpNum[] = new int[nums.length + 2];
        for(int i = 1; i <= nums.length; i++)
            helpNum[i] = nums[i - 1];
        helpNum[0] = 1;
        helpNum[nums.length + 1] = 1;

        int sum[][] = new int[helpNum.length][helpNum.length];
        for(int gap = 0; gap < nums.length; gap++) {
            for(int begin = 1; begin < nums.length - gap + 1; begin++) { // we don't consider the dummy head and tail
                int end = begin + gap;
                sum[begin][end] = Integer.MIN_VALUE;
                int left = helpNum[begin - 1];
                int right = helpNum[end + 1];

                // head and tail for current subrange need to be special processed
                sum[begin][end] = Math.max(sum[begin][end], sum[begin + 1][end] + helpNum[begin] * left * right);
                sum[begin][end] = Math.max(sum[begin][end], sum[begin][end - 1] + helpNum[end] * left * right);

                for(int j = begin + 1; j < end; j++)
                    sum[begin][end] = Math.max(sum[begin][end], sum[begin][j - 1] + sum[j + 1][end] + helpNum[j] * left * right);
            }
        }
        return sum[1][nums.length];
    }
}
 */