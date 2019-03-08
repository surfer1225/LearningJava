package main.java.leetcode.RevisionQns;

import java.util.Arrays;

/**
 * Created by Ryan on 12/1/18.
 */

/*
Given an array consists of non-negative integers,
your task is to count the number of triplets chosen from the array
that can make triangles if we take them as side lengths of a triangle.
Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
 */
public class ValidTriNum {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ValidTriNum v = new ValidTriNum();
        System.out.println(v.triangleNumber(new int[]{1,3,4}));
    }
}
