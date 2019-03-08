package main.java.leetcode.RevisionQns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan on 1/9/17.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        for (int i:twoSum(new int[]{2, 7, 11, 15}, 9))
            System.out.println(i);
    }
}
